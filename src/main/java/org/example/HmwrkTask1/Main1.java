package org.example.HmwrkTask1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class Main1 {
    /**
     * 2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
     *
     * @param args
     */
    public static void main(String[] args) {

        Student student1 = new Student("Igor", 35, 4.8);
        System.out.println("Before serialization: ");
        student1.printFields();

        try {
            // Сериализация в XML
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File("student1.xml"), student1);
            // Сериализация в JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("student1.json"), student1);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Десериализация из XML
            XmlMapper xmlMapper = new XmlMapper();
            Student studentFromXml = xmlMapper.readValue(new File("student1.xml"), Student.class);
            System.out.println("After deserialization from XML: ");
            studentFromXml.printFields();
            // Десериализация из JSON
            ObjectMapper objectMapper = new ObjectMapper();
            Student studentFromJson = objectMapper.readValue(new File("student1.json"), Student.class);
            System.out.println("After deserialization from JSON: ");
            studentFromJson.printFields();
            if (studentFromJson.getGpa() == 0.0 | studentFromXml.getGpa() == 0.0)
                System.out.println("""
                        ! GPA не было сохранено в файл.\s
                        Это произошло потому что поле 'gpa' было объявлено как transient,\s
                        что означает, что оно не участвует в процессе сериализации.\s
                        Поэтому при десериализации объекта это поле получает значение по умолчанию \s 
                        для своего типа данных, в данном случае - 0.0. !""");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}