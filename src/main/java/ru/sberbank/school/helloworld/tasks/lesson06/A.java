package ru.sberbank.school.helloworld.tasks.lesson06;


@Component
public class A { //TODO: не абстрактный и не интерфейс

    @Autowired
    private B b;

    @Autowired
    private CImlp d;

    @PostConstruct
    private void init() {
        //TODO: some logic
        System.err.println("init!!!!");
    }

    public void execute() {
        System.err.println(b.getSomeData());
        System.err.println(d.getSomeStr());
    }

    @PreDestroy
    private void destroy() {
        //TODO: some logic
        System.err.println("destroy!!!!");
    }

}