package geekBrains.lesson5;

public class Task1to5 {
    public static void main(String[] args) {
        Staff[] workersArray = new Staff[5];
        workersArray[0] = new Staff("Иванов Андрей", "главный специалист", "ivanov_a@compamy.ru", "89252344554", 70000, 29);
        workersArray[1] = new Staff("Дмитриева Марина", "эксперт", "dmitrieva_m@company.ru", "89165552287", 105000, 34);
        workersArray[2] = new Staff("Пеших  Артем", "заместитель начальника отдела", "peshykh_a@company.ru", "89247628383", 155000, 38);
        workersArray[3] = new Staff("Громова Елена", "начальник отдела", "gromova_e@company.ru", "89159925262", 200000, 42);
        workersArray[4] = new Staff("Стоянов Олег", "эксперт", "stoyanov_o@company.ru", "89856676253", 110000, 41);

        for (int i = 0; i < workersArray.length; i++) {
            if (workersArray[i].age > 40) {
                workersArray[i].workerInfo();
            }
        }
    }
}

class Staff {
    private String name;
    private String position;
    private String email;
    private String cell;
    private int salary;
    public int age;


    public Staff (String name, String position, String email, String cell, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.cell = cell;
        this.salary = salary;
        this.age = age;
    }

    public void workerInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Должность: " + position);
        System.out.println("e-mail: " + email);
        System.out.println("Cell number: " + cell);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
    }
}