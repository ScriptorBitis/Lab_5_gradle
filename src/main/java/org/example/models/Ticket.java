package org.example.models;

import org.example.utility.Validatable;

import java.time.LocalDateTime;

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

    public Ticket() {
        this.creationDate = LocalDateTime.now().withNano(0);
        this.id = IdGenerator.assigntTicketId();
    }

    public int getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public Integer getPrice() {
        if (this.price == null) {
            return Integer.MIN_VALUE;
        }
        return price;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public TicketType getType() {
        return type;
    }

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

    public static class Builder {
        private String name = null;
        private Integer price = null;
        private float discount = 0;
        private Boolean refundable = null;
        private Coordinates coordinates = new Coordinates();
        private TicketType type = null;
        private Event event = new Event();


        public Builder name(String name) {
            this.name = name;
            return this;
        }


        public Builder price(Integer price) {
            this.price = price;
            return this;
        }

        public Builder discount(float discount) {
            this.discount = discount;
            return this;
        }

        public Builder refundable(Boolean refundable) {
            this.refundable = refundable;
            return this;
        }

        public Builder coordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Builder type(TicketType type) {
            this.type = type;
            return this;
        }

        public Builder event(Event event) {
            this.event = event;
            return this;
        }

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
