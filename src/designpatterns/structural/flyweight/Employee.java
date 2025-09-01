package designpatterns.flyweight;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Heshan Karunaratne
 */
interface Employee {
    public void assignSkill(String skill);

    public void task();
}

class Developer implements Employee {
    private final String job;
    private String skill;

    public Developer() {
        job = "Fix the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with job: " + this.job);
    }
}

class Tester implements Employee {
    private final String job;
    private String skill;

    public Tester() {
        job = "Test the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with skill: " + this.skill + " with job: " + this.job);
    }
}

class EmployeeFactory {
    private static HashMap<String, Employee> m = new HashMap<>();

    public static Employee getEmployee(String type) {
        Employee p = null;
        if (m.get(type) != null) {
            p = m.get(type);
        } else {
            switch (type) {
                case "Developer":
                    System.out.println("Developer created");
                    p = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("no such employee");
            }
            m.put(type, p);
        }
        return p;
    }
}

class FlyweightTest {
    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", "Python", "React"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Employee e = EmployeeFactory.getEmployee(getRandomEmployee());
            e.assignSkill(getRandomSkill());
            e.task();
        }
    }

    private static String getRandomSkill() {
        return skills[new Random().nextInt(skills.length)];
    }

    private static String getRandomEmployee() {
        return employeeType[new Random().nextInt(employeeType.length)];
    }
}