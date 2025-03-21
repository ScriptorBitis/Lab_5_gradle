package org.example.models;

import org.example.utility.Validatable;

/**
 * Класс для создания координат с реализованным шаблоном билдер
 * Прописаны геттеры всех полей
 */
public class Coordinates implements Validatable {
    private double x;
    private Double y; //Максимальное значение поля: 484, Поле не может быть null

    /**
     * вернуть координату x
     * @return {@link Coordinates#x}
     */
    public Double getY() {
        return y;
    }

    /**
     * вернуть координату y
     * @return {@link Coordinates#y}
     */
    public double getX() {
        return x;
    }

    /**
     * Валидация координат
     * @return значение true/false
     */
    @Override
    public boolean validate() {
        if (y == null) {
            return false;
        }
        return 484 <= y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Реализованный шаблон 'билдер'
     */
    public static class Builder {
        private double x = 0;
        private Double y = null;

        /**
         * @param x - значение координаты x
         * @return - объект билдера с назначенным полем
         */
        public Builder x(int x) {
            this.x = x;
            return this;
        }

        /**
         * @param y - значение координаты y
         * @return - объект билдера с назначенным полем
         */
        public Builder y(Double y) {
            this.y = y;
            return this;
        }

        /**
         * Собрать координаты
         * @return объект класса {@link Coordinates}
         */
        public Coordinates build() {
            Coordinates coordinates = new Coordinates();
            coordinates.y = this.y;
            coordinates.x = this.x;

            return coordinates;
        }

    }
}
