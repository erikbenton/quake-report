package com.example.android.quakereport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Date;

public class Earthquake
{
    // Variables for an Earthquake
    private double mMagnitude;
    private String mPlace;
    private long mTime;

    /**
     * Constructor fo Earthquake
     * @param mag - Magnitude of the earthquake
     * @param place - Where the Earthquake happened
     * @param time - Time in epoch time (seconds) when earthquake occurred
     */
    public Earthquake(double mag, String place, long time)
    {
        mMagnitude = mag;
        mPlace = place;
        mTime = time;
    }

    /**
     * Get the magnitude of the earthquake
     * @return
     */
    public double getMagnitude()
    {
        return mMagnitude;
    }

    /**
     * Get the place of the Earthquake
     * @return
     */
    public String getPlace()
    {
        return mPlace;
    }

    /**
     * Gets the time of the earthquake in epoch (seconds) time
     * @return
     */
    public long getTime()
    {
        return mTime;
    }

    /**
     * Formats the mTime variable from milliseconds to an actual date formatted:
     * "Oct 2, 1990"
     * @return formattedDate
     */
    public String getFormattedDate()
    {
        // Create String for date
        String formattedDate;

        // Get the time in ms and create date with it
        Date date = new Date(this.getTime());

        // Format the date to be: "Oct 2, 1990"
        DateFormat format = new SimpleDateFormat("LLL DD, yyyy");
        formattedDate = format.format(date);

        return formattedDate;
    }

    public String getFormattedTime()
    {
        // Create String for date
        String formattedTime;

        // Get the time in ms and create date with it
        Date date = new Date(this.getTime());

        // Format the date to be: "Oct 2, 1990"
        DateFormat format = new SimpleDateFormat("h:mm a");
        formattedTime = format.format(date);

        return formattedTime;
    }
}
