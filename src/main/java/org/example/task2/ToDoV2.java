package org.example.task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Сущность задачи ToDoList:
 * Описание главной сущности приложения ToDoList
 * работа с интерфейсом Externalizable:
 * для построения логики(в ручном режиме) сериализации и десериализации
 */
public class ToDoV2 implements Externalizable {

    /**
     * Наименование задачи
     */
    private String title;

    /**
     * Статус задачи
     */
    private boolean isDone;

    // конструктор по умолчанию (должен быть!)
    public ToDoV2() {
    }

    public ToDoV2(String title) {
        this.title = title;
        isDone = false;
    }

    /** Переделяем методы для наших задач
     * используем необходимые методы интерфейса Externalizable
     * @param out the stream to write the object to
     * @throws IOException
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // соблюдаем последовательность записи
        out.writeObject(title);
        out.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // соблюдаем последовательность записи
        title = (String)in.readObject();
        isDone = in.readBoolean();
    }

    /**
     * Получить наименование задачи
     * @return наименование задачи
     */
    public String getTitle() {
        return title;
    }

    /**
     * Получить статус выполнения задачи
     * @return статус выполнения задачи
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Изменить статус выполнения задачи
     * @param done новый статус задачи
     */
    public void setDone(boolean done) {
        isDone = done;
    }

}

