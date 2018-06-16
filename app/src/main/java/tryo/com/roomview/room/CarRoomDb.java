package tryo.com.roomview.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


@Database(entities = {Car.class}, version = 1)
public abstract class CarRoomDb extends RoomDatabase{

    public abstract CarDAO carDAO();

    private static CarRoomDb dbInstace;

    public static CarRoomDb getCarRoomDb(final Context context){

        if(dbInstace == null){

            synchronized (CarRoomDb.class){

                if(dbInstace == null){
                    dbInstace = Room.databaseBuilder(context.getApplicationContext(),
                            CarRoomDb.class, "Car_db")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomDbCallback)
                            .build();
                }
            }
        }
        return dbInstace;
    }

    private static RoomDatabase.Callback roomDbCallback =
            new RoomDatabase.Callback(){

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(dbInstace).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{

        private  final CarDAO carDAO;
        PopulateDbAsync(CarRoomDb roomDb){
              carDAO = roomDb.carDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            carDAO.deleteAll();
            Car car = new Car("Benz");
            carDAO.insert(car);
            car = new Car("Elegant and smooth");
            carDAO.insert(car);
            return null;
        }
    }
}

