package tryo.com.roomview.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Car_table")
public class Car {

    public Car(){}

    public Car(String car){
        this.myCar = car;
    }


    @PrimaryKey
    @ColumnInfo(name = "car")
    @NonNull
    private String myCar;


    public void setMyCar(String myCar) {
        this.myCar = myCar;
    }
    public String getMyCar(){
        return this.myCar;
    }
}
