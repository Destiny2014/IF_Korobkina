package org.ifellow.korobkina;

import java.util.List;

public class ActionWithCars {

    public void oldAuto(List<Car> list) {
        for (Car car : list) {
            if (car.getYear() > 2006) {
                car.getInfo();
            } else {
                System.out.println(car.getBrand() + ' ' + car.getNameModel() + ' ' + "устаревший авто");
                System.out.println(" ");
            }
        }
    }

    public void changeColor(List<Car> list, String oldCol, String newCol) {
        for (Car car : list) {
            if (car.getColor().equals(oldCol)) {
                System.out.println("Инфа об авто ДО изменения цвета:");
                car.getInfo();
                car.changeColor(newCol);
                System.out.println("Инфа об авто ПОСЛЕ изменения цвета");
                car.getInfo();
            }
        }
    }

    public void slowAuto(List<Car> list) {
        for (Car car : list) {
            if (car.getMaxSpeed() > 200) {
                System.out.println("Быстрый авто:");
                car.getInfo();
            } else {
                System.out.println("Медленный авто");
                car.getInfo();
            }
        }
    }
}