package tryo.com.roomview.adapter;


import android.content.Context;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tryo.com.roomview.R;
import tryo.com.roomview.room.Car;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarViewHolder> {



    class CarViewHolder extends RecyclerView.ViewHolder {
        private final TextView carItemView;

        public CarViewHolder(View itemView) {
            super(itemView);
            carItemView = itemView.findViewById(R.id.textView);
        }
    }

    private List<Car> mCars;
    private final LayoutInflater layoutInflater;

    public CarListAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.recycleview_item,parent,false);
        return new CarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarListAdapter.CarViewHolder holder, int position) {
        if(mCars != null){
            Car car = mCars.get(position);
            holder.carItemView.setText(car.getMyCar());
        } else {
            holder.carItemView.setText("No Car");
        }
    }

    public void setmWords(List<Car> cars){
        mCars = cars;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        if(mCars != null){
            return mCars.size();
        }else {
            return 0;
        }
    }
}
