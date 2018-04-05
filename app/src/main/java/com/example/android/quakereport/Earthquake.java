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

    public String getFormattedDate()
    {
        String formattedDate;

        Date date = new Date(this.getTime()*1000);
        DateFormat format = new SimpleDateFormat("MMM d, yyyy");
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        formattedDate = format.format(date);
        System.out.println(formattedDate);
        format.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        formattedDate = format.format(date);

        return formattedDate;
    }
}
