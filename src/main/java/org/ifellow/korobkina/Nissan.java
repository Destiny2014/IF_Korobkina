package org.ifellow.korobkina;

public class Nissan extends Car {

    public Nissan(int year, String transmission, String nameModel, String color, int maxSpeed, double capasityEngine) {
        super(year, transmission, nameModel, color, maxSpeed, capasityEngine);
    }

    @Override
    public String getBrand() {
        return "Nissan";
    }

    @Override
    public String getCountry() {
        return "Япония";
    }
}