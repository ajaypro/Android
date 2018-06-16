package tryo.com.roomview.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import tryo.com.roomview.room.Car;
import tryo.com.roomview.room.CarRepository;

public class CarViewModel extends AndroidViewModel {

    private CarRepository carRepository;

    private LiveData<List<Car>> dataAllCars;

    public CarViewModel(Application application){

        super(application);
        carRepository = new CarRepository(application);
        dataAllCars = carRepository.getAllCars();
    }

    public LiveData<List<Car>> getAllCars(){
        return dataAllCars;
    }

    public void insert(Car car){

        carRepository.insert(car);

    }
}
