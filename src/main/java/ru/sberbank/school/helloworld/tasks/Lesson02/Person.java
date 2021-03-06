package ru.sberbank.school.helloworld.tasks.lesson02;

import java.util.Objects;

public class Person {
    private final boolean man;
    private final String name;
    private Integer age;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public Person(boolean man, String name, Integer age) {
        this.man = man;
        this.name = name;
        this.age = age;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife.
     * Example:
     * if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (person == null) {
            System.out.println("ERROR: " + this.toString() + ".marry(null)");
            return false;
        }
        if (man == person.man) {
            return false;
        }
        if (spouse != null && spouse.equals(person)) {
            return false;
        }
        divorce();
        person.divorce();
        spouse = person;
        person.spouse = this;
        return true;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (spouse != null) {
            spouse.spouse = null;
            spouse = null;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person that = (Person) o;
        return Objects.equals(man, that.man) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(man, name);
    }

    @Override
    public String toString() {
        if (man) {
            return "man" + name;
        } else {
            return "woman" + name;
        }
    }
}
