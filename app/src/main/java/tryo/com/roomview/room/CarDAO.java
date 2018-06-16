package tryo.com.roomview.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

import java.util.List;

@Dao
public interface CarDAO {

    @Insert
    public void insert(@NonNull Car car);



    @Query("SELECT * from car_table ORDER BY car ASC")
    public LiveData<List<Car>> getAllCars();


    @Query("DELETE FROM car_table")
    public void deleteAll();
}
