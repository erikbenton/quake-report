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
import android.graphics.drawable.GradientDrawable;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>
{
    private Context mContext;
    private List<Earthquake> earthquakeList;

    /**
     * Contructor for the EarthquakeAdapter
     * @param context
     * @param list - List of Earthquakes
     */
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
        // Gets the current view
        View listItem = convertView;

        // Gets the current earthquake for the list
        final Earthquake currentQuake = earthquakeList.get(position);

        // Setting up magnitude string for display
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitude = formatter.format(currentQuake.getMagnitude());

        // Setting up location variables for display
        String location = currentQuake.getPlace();
        String vicinity;
        String place;

        //Find index of "of"
        int ofIndex = location.indexOf("of");

        // If there is an "of"
        if(ofIndex > 0)
        {
            vicinity = location.substring(0, ofIndex + 2);
            place = location.substring(ofIndex + 3);
        }
        else // If there isn't an "of"
        {
            vicinity = "Near the";
            place = location;
        }

        // Inflates the list item if null
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        }

        // Getting all the views
        TextView magnitudeView = (TextView) listItem.findViewById(R.id.magnitude_view);
        TextView vicinityView = (TextView) listItem.findViewById(R.id.vicinity_view);
        TextView placeView = (TextView) listItem.findViewById(R.id.place_view);
        TextView dateView = (TextView) listItem.findViewById(R.id.date_view);
        TextView timeView = (TextView) listItem.findViewById(R.id.time_view);

        // Set proper background color on magnitude circle
        // Fetch the background from the TextView
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(currentQuake.getMagnitude()));

        // Assigning appropriate values to the views
        magnitudeView.setText(magnitude);
        vicinityView.setText(vicinity);
        placeView.setText(place);
        dateView.setText(currentQuake.getFormattedDate());
        timeView.setText(currentQuake.getFormattedTime());


        return listItem;
    }

    private int getMagnitudeColor(double magnitude)
    {
        int color;

        switch ((int) magnitude)
        {
            case 0:
            case 1:
                color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }

        return color;
    }
}
