package tryo.com.roomview.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import tryo.com.roomview.room.CarRoomDb;

import java.util.List;

public class CarRepository {

    private CarDAO carDAO;
    private LiveData<List<Car>> allCars;

    public CarRepository(Application application){

        CarRoomDb  carRoomDb = CarRoomDb.getCarRoomDb(application);
        carDAO = carRoomDb.carDAO();
        allCars =  carDAO.getAllCars();
    }

    public LiveData<List<Car>> getAllCars (){
        return allCars;
    }

    public void insert(Car car){
        new insertAsyncTask(carDAO).execute(car);
    }



    private static class insertAsyncTask extends AsyncTask<Car, Void, Void>{

       private CarDAO carDAO;

        insertAsyncTask(CarDAO asyncWordDao){
           carDAO = asyncWordDao;
       }

        @Override
        protected Void doInBackground(final Car... cars) {
            carDAO.insert(cars[0]);
            return null;
        }
    }

}


