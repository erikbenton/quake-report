package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>
{
    private Context mContext;
    private List<Earthquake> earthquakeList;

    public EarthquakeAdapter(@NonNull Activity context, ArrayList<Earthquake> list)
    {
        super(context, 0, list);
        mContext = context;
        earthquakeList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;

        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        }

        final Earthquake currentQuake = earthquakeList.get(position);

        TextView magnitudeView = (TextView) listItem.findViewById(R.id.magnitude_view);
        TextView placeView = (TextView) listItem.findViewById(R.id.place_view);
        TextView timeView = (TextView) listItem.findViewById(R.id.time_view);

        magnitudeView.setText(Double.toString(currentQuake.getMagnitude()));
        placeView.setText(currentQuake.getPlace());
        timeView.setText(currentQuake.getFormattedDate());


        return listItem;
    }
}
