package org.ifellow.korobkina;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Lada vesta = new Lada(2024,"Вариатор","Lada Vesta Cross", "черный", 173, 1.8);
        Mazda mazda6 = new Mazda(2018,"Автомат", "6", "белый", 207, 2.5);
        Nissan nissanX = new Nissan(2016,"Автомат", "X-Trail", "зеленый", 200, 2.4);
        Suzuki suzukiGV = new Suzuki(2014, "Механика", "Grand Vitara", "зеленый", 175, 1.9, "Sport");
        Toyota toyotaM2 = new Toyota(2004,"Механика","Mark II", "серебристый металик", 140, 1);
        Lada vaz = new Lada(2004,"Механика","ВАЗ 2110", "серый", 180, 1.6);
        Mazda mazda3 = new Mazda(2003,"Автомат", "3", "синий", 216, 2);
        Nissan nissanT = new Nissan(2014,"Вариатор", "Teana", "красный", 230, 2.5);
        Suzuki suzukiJ = new Suzuki(1998, "Автомат", "Jimni", "коричневый", 140, 1.4, "NotSport");
        Toyota toyotaS = new Toyota(1981,"Автомат","Supra", "голубой", 250, 3);

        List<Car> car = new ArrayList<>(Arrays.asList(vesta, mazda6, nissanX, suzukiGV, toyotaM2, vaz, mazda3, nissanT, suzukiJ, toyotaS));

        ActionWithCars action = new ActionWithCars();
        Scanner sc = new Scanner(System.in);
        String s;

        do {
            System.out.println("Введите old - чтобы найти старые авто");
            System.out.println("Введите change - чтобы изменить цвет зеленого авто на красный");
            System.out.println("Введите slow - чтобы найти медленные авто");
            System.out.println("Введите end - чтобы остановить выполнение программы");
            s = sc.nextLine();
            switch(s) {
                case "old":
                    action.oldAuto(car);
                    break;
                case "change":
                    action.changeColor(car);
                    break;
                case "slow":
                    action.slowAuto(car);
                    break;
                case "end":
                    break;
                default:
                    System.out.println("Введена неверная команда");
                    break;
            }
        } while (!s.equals("end"));

    }
}
