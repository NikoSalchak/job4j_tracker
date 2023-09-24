package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Niko Salchak");
        student.setGroup(132);
        student.setAdmissionDate("01.08.2023");
        System.out.println("ФИО студента: " + student.getName() + "\n" + "Группа студента: "
                + student.getGroup() + "\n" + "Дата постпления: " + student.getAdmissionDate());
    }
}
