package org.example.models;

import org.example.utility.Validatable;

import java.time.LocalDateTime;

/**
 * Класс для создания билетов
 */
public class Ticket implements Validatable {
    private final int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer price; //Поле может быть null, Значение поля должно быть больше 0
    private float discount; //Значение поля должно быть больше 0, Максимальное значение поля: 100
    private Boolean refundable; //Поле может быть null
    private Coordinates coordinates; //Поле не может быть null
    private TicketType type; //Поле может быть null
    private Event event; //Поле может быть null

    /**
     * конструктор. При создании выдается id и дата создания
     * @see IdGenerator
     */
    public Ticket() {
        this.creationDate = LocalDateTime.now().withNano(0);
        this.id = IdGenerator.assigntTicketId();
    }

    /**
     * Получить id текущего билета
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Получить {@link Event} текущего билета
     * @return  объект {@link Event}
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Возвращает {@link Ticket#price}, если значение Integer null, то возвращается Integer.MIN_VALUE
     * @return {@link Ticket#price}
     */
    public Integer getPrice() {
        if (this.price == null) {
            return Integer.MIN_VALUE;
        }
        return price;
    }

    /**
     * Возвращает {@link Ticket#coordinates}
     * @return {@link Coordinates}
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Возвращает значение из {@link TicketType}
     * @return
     */
    public TicketType getType() {
        return type;
    }

    /**
     * Валидация объекта
     * @return значение true/false
     */
    @Override
    public boolean validate() {
        if (id <= 0
                || creationDate == null
                || (price != null && price <= 0)
                || discount <= 0.0
                || discount >100.0
                || refundable==null
                || coordinates == null
                || name == null
                || name.isEmpty()
                || this.coordinates.validate() ) {
            return false;
        }
        if (this.event==null){
            return true;
        }
        return this.event.validate();
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", name='" + name + '\'' + ", creationDate=" + creationDate + ", price=" + price + ", discount=" + discount + ", refundable=" + refundable + ", coordinates=" + coordinates + ", type=" + type + ", event=" + event + '}';
    }

    /**
     * Реализованный шаблон 'билдер'
     */
    public static class Builder {
        private String name = null;
        private Integer price = null;
        private float discount = 0;
        private Boolean refundable = null;
        private Coordinates coordinates = new Coordinates();
        private TicketType type = null;
        private Event event = new Event();

        /**
         * @param name имя
         * @return объект класса {@link Builder} с поставленным значением
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * @param price цена билета
         * @return объект класса {@link Builder} с поставленным значением
         */
        public Builder price(Integer price) {
            this.price = price;
            return this;
        }

        /**
         * @param discount скидка билета
         * @return объект класса {@link Builder} с поставленным значением
         */
        public Builder discount(float discount) {
            this.discount = discount;
            return this;
        }

        /**
         * @param refundable можно ли вернуть билет (true/false)
         * @return объект класса {@link Builder} с поставленным значением
         */
        public Builder refundable(Boolean refundable) {
            this.refundable = refundable;
            return this;
        }

        /**
         * @param coordinates координаты билета
         * @return объект класса {@link Builder} с поставленным значением
         */
        public Builder coordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        /**
         * @param type тип билета
         * @return объект класса {@link Builder} с поставленным значением
         */
        public Builder type(TicketType type) {
            this.type = type;
            return this;
        }


        /**
         * @param event событие билета
         * @return объект класса {@link Builder} с поставленным значением
         */
        public Builder event(Event event) {
            this.event = event;
            return this;
        }

        /**
         * @return объект класса {@link Ticket}
         */
        public Ticket build() {
            Ticket ticket = new Ticket();
            ticket.name = this.name;
            ticket.price = this.price;
            ticket.discount = this.discount;
            ticket.refundable = this.refundable;
            ticket.coordinates = this.coordinates;
            ticket.type = this.type;
            ticket.event = this.event;
            return ticket;
        }
    }
}
