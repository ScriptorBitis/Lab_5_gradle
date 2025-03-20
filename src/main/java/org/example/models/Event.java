package org.example.models;

import org.example.utility.Validatable;

/**
 * Класс для создания объектов Event
 */
public class Event implements Validatable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int ticketsCount; //Значение поля должно быть больше 0
    private String description; //Поле может быть null

    public Event() {
    }

    /**
     * Вернуть {@link Event#id}
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Валидация события
     * @return значение true/false
     */
    @Override
    public boolean validate() {
        if (id <= 0
                || ticketsCount <= 0
                || name == null
                || name.isBlank()) {
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ticketsCount=" + ticketsCount +
                ", description=" + description +
                '}';
    }

    /**
     * Реализованный шаблон 'билдер'
     */
    public static class Builder {
        private String name = null;
        private int ticketsCount = 0;
        private String description = null;

        /**
         * @param name - имя события
         * @return - объект класса {@link Builder} с назначенным полем
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * @param ticketsCount
         * @return - объект класса {@link Builder} с назначенным полем
         */
        public Builder ticketsCount(int ticketsCount) {
            this.ticketsCount = ticketsCount;
            return this;
        }

        /**
         * @param description
         * @return - объект класса {@link Builder} с назначенным полем
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Собрать объект класса {@link Event}
         * @return  объект класса {@link Event}
         */
        public Event build() {
            Event event = new Event();
            event.name = this.name;
            event.ticketsCount = this.ticketsCount;
            event.description = this.description;
            event.id = IdGenerator.assigntEventIdCounter();

            return event;

        }


    }


}
