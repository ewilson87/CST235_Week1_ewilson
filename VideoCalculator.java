/**
 * Program: CST-235 Short Project 1a
 * File: VideoCalculator.java
 * Summary: JavaBean that determines data size of a video based on resolution (720p, 1080p) and time in seconds. Display in MB and GB
 * Author: Evan Wilson
 * Date: August 9th, 2018
 **/

import java.io.Serializable;

// Java EE JavaBean example class. implements Serializable interface, public no parameter
// constructor, private variables with getters and setters using standard naming convention.
public class VideoCalculator implements Serializable {

    //private fields
    private int lengthInSeconds;
    private int resolution;
    private int fileSizeMB;
    private int fileSizeGB;

    //no argument constructor
    public VideoCalculator() {
    }

    //not mandatory in JavaBean, but still allowed
    public VideoCalculator(int lengthInSeconds, int resolution) {
        this.lengthInSeconds = lengthInSeconds;
        this.resolution = resolution;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public int getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(int dataSizeMB) {
        this.fileSizeMB = dataSizeMB;
    }

    public int getFileSizeGB() {
        return fileSizeGB;
    }

    public void setFileSizeGB(int dataSizeGB) {
        this.fileSizeGB = dataSizeGB;
    }

    //recommended resolutions retrieved from https://support.google.com/youtube/answer/1722171?hl=en
    public void calculateFileSize()
    {
        if(getResolution() == 720){
            setFileSizeGB((lengthInSeconds * 5 / 8) / 1000); // 5mbps is recommended bitrate size per second for 720p video using H.264.
            setFileSizeMB((lengthInSeconds * 5 / 8) % 1000);
        }else if(getResolution() == 1080){
            setFileSizeGB((lengthInSeconds * 8 / 8) / 1000); // 8mbps is recommended bitrate size per second for 1080p video using H.264.
            setFileSizeMB((lengthInSeconds * 8 / 8) % 1000);
        }
    }

    //toString method to properly display time in minutes/seconds and data size in GB and MB
    public String toString()
    {
        return "For " + (getLengthInSeconds()/60) + " minutes and " + (getLengthInSeconds()%60) + " seconds of " + getResolution() +
                "p video, the file size would be " + getFileSizeGB() + "GB and " + getFileSizeMB() + "MB";
    }
}
