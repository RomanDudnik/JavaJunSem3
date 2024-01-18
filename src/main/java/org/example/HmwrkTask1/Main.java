package org.example.HmwrkTask1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;


public class Main {
    /**
     * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
     * Обеспечьте поддержку сериализации для этого класса.
     * Создайте объект класса Student и инициализируйте его данными.
     * Сериализуйте этот объект в файл.
     * Десериализуйте объект обратно в программу из файла.
     * Выведите все поля объекта, включая GPA, и ответьте на вопрос,
     * почему значение GPA не было сохранено/восстановлено.
     */

    public static void main(String[] args) {

        Student student = new Student("Ivan", 18, 4.5);
        System.out.println("Before serialization: ");
        student.PrintFields();

        try {
            // Поток для записи объекта в файл
            FileOutputStream fileOut = new FileOutputStream("student.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            // Сериализация
            objectOut.writeObject(student);
            // Закрытие потоков
            objectOut.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Поток для чтения объекта из файла
            FileInputStream fileIn = new FileInputStream("student.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            // Десериализация
            Student deserializedStudent = (Student) objectIn.readObject();
            // Закрытие потоков
            objectIn.close();
            fileIn.close();

            System.out.println("After deserialization: ");
            deserializedStudent.PrintFields();
            if (deserializedStudent.getGpa() == 0.0)
                System.out.println("GPA не было сохранено в файл. \n Это произошло потому " +
                    "что поле 'gpa' было объявлено как transient, \n что означает, " +
                    "что оно не участвует в процессе сериализации. " +
                    "\n Поэтому при десериализации объекта это поле получает значение по умолчанию " +
                    "для своего типа данных, в данном случае - 0.0.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

    }
}
