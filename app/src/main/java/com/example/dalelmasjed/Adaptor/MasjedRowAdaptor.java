package com.example.dalelmasjed.Adaptor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dalelmasjed.Model.Masjed;
import com.example.dalelmasjed.R;

import java.util.List;

public class MasjedRowAdaptor extends BaseAdapter

{
    Activity activity ;
    LayoutInflater inflater ;
    List <Masjed> masjedList ;

    public MasjedRowAdaptor(Activity activity, List<Masjed> masjedList) {
        this.activity = activity;
        this.masjedList = masjedList;
    }

    @Override
    public int getCount() {
        return masjedList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null )
        {

            inflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        if (convertView == null)
            convertView = inflater.inflate(R.layout.masjedrow,null);
/*
* linking adaptor to the row activity
* returning views value
* */
        TextView Masjed_Name , Capacity , Rate;
        ImageView WomenSection  , WodoSection , Parking , Jumaah ;
        Masjed_Name = convertView.findViewById(R.id.msjdrmn);
        WomenSection = convertView.findViewById(R.id.WomenSection);
        WodoSection = convertView.findViewById(R.id.WodoSection);
        Parking = convertView.findViewById(R.id.Parking);
        Capacity = convertView.findViewById(R.id.Capacity);
        Rate = convertView.findViewById(R.id.rating);
        Jumaah = convertView.findViewById(R.id.Jumah);

        Masjed_Name.setText(masjedList.get(position).getName());

        if (masjedList.get(position).getWomensec())
        {
            WomenSection.setImageResource(R.drawable.women);
        }
        else
        {
            WomenSection.setImageResource(R.drawable.no_women);
        }

        if (masjedList.get(position).getWodhow())
        {
            WodoSection.setImageResource(R.drawable.wash);
        }
        else
        {
            WodoSection.setImageResource(R.drawable.no_wash);
        }


        if (masjedList.get(position).getParking())
        {
            Parking.setImageResource(R.drawable.parking);
        }
        else
        {
            Parking.setImageResource(R.drawable.no_park);
        }

        if (masjedList.get(position).getJumaah())
        {
            Jumaah.setImageResource(R.drawable.jumaah);
        }
        else
        {
            Jumaah.setImageResource(R.drawable.no_jumaah);
        }

        Capacity.setText(masjedList.get(position).getCapacity()+"");
        Rate.setText(masjedList.get(position).getRating()+"");

        return convertView;

    }

}
