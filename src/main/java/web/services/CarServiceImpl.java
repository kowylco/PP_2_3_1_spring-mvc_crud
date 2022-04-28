package web.services;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService{
    List<Car> carList = new ArrayList<>();
    private static long CARID;

    {
        carList.add(new Car(++CARID, "Geng", 1977));
        carList.add(new Car(++CARID, "Pony", 1987));
        carList.add(new Car(++CARID, "Fora", 1993));
        carList.add(new Car(++CARID, "Xiao", 2005));
        carList.add(new Car(++CARID, "Soma", 2022));
    }

    @Override
    public Car getCar(long id) {
        return carList.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<Car> getCars(int count) {
        if (count >= 0 && count < 5) {
            return carList.stream().limit(count).toList();
        } else {
            return carList;
        }
    }

    @Override
    public List<Car> getAllCars() {
        return carList;
    }
}
