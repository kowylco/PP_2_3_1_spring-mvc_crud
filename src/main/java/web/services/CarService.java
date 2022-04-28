package web.services;

import web.models.Car;

import java.util.List;

public interface CarService {
    Car getCar(long id);
    List<Car> getCars(int count);
    List<Car> getAllCars();
}
