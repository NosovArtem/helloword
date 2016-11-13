package ru.sberbank.school.helloworld.tasks.lesson17_GoodCode.SalaryHtmlReportNotifier;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SalaryHtmlReportNotifier {

    private final String HOST = "mail.google.com";

    private Connection connection;


    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;

    }

    public void generateAndSendHtmlSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) {
        try {
            List<DataDTO> results = getDataReport(departmentId, dateFrom, dateTo);
            String resultingHtml = createHtmlResponse(results);
            sendSalaryReport(recipients, resultingHtml);

        } catch (SQLException | MessagingException e) {
            e.printStackTrace();
        }
    }

    // TODO: class type of MODEL
    public List getDataReport(String departmentId, LocalDate dateFrom, LocalDate dateTo) throws SQLException {
        List<Object> listDTO = new ArrayList<>();

        String sqlRequest = "select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary " +
                "from employee emp left join salary_payments sp on emp.id = sp.employee_id " +
                "where emp.department_id = ? and sp.date >= ? and sp.date <= ? " +
                "group by emp.id, emp.name";

        try (PreparedStatement ps = connection.prepareStatement(sqlRequest)) {
            ps.setString(0, departmentId);
            ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
            ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));

            try (ResultSet results = ps.executeQuery()) {
                while (results.next()) {
                    DataDTO dto = new DataDTO(results.getInt("emp_id"),
                            results.getString("emp_name"),
                            results.getDouble("salary"));
                    listDTO.add(dto);
                }
            }
            return listDTO;
        }
    }

    // TODO: class type of VIEW
    public String createHtmlResponse(List results) throws SQLException {
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        Iterator<DataDTO> iter = results.iterator();
        while (iter.hasNext()) {
            DataDTO data = iter.next();

            resultingHtml.append("<tr>");
            resultingHtml.append("<td>").append(data.getEmp_name()).append("</td>");
            resultingHtml.append("<td>").append(data.getSalary()).append("</td>");
            resultingHtml.append("</tr>");
            totals += data.getSalary();
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");
        return resultingHtml.toString();
    }

    // TODO: class type of SERVICE
    public void sendSalaryReport(String recipients, String resultingHtml) throws MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(HOST);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipients);
        helper.setText(resultingHtml, true);
        helper.setSubject("Monthly department salary report");
        mailSender.send(message);
    }


}