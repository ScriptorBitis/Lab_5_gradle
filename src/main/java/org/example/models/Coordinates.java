package org.example.models;

import java.lang.Double;
import org.example.utility.Validatable;


public class Coordinates implements Validatable {
    private double x;
    private Double y; //Максимальное значение поля: 484, Поле не может быть null


    public Double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public static class Builder {
        private double x=0;
        private Double y=null;


        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(Double y) {
            this.y = y;
            return this;
        }


        public Coordinates build() {
            Coordinates coordinates=new Coordinates();
            coordinates.y=this.y;
            coordinates.x=this.x;

            return coordinates;
        }

    }

    @Override
    public boolean validate() {
        if (y == null) {
            return false;
        }
        if (y > 484) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
