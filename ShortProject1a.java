/**
 * Program: CST-235 Short Project 1a
 * File: ShortProject1a.java
 * Summary: JavaBean that determines data size of a video based on resolution (720p, 1080p) and time in seconds. Display in MB and GB
 * Author: Evan Wilson
 * Date: August 9th, 2018
 **/

//driver for VideoCalculator
public class ShortProject1a
{
    public static void main(String[] args) {

        //create 2 new VideoCalculator object and set values, then run the calculateFileSize() method
        VideoCalculator video1 = new VideoCalculator();
        video1.setResolution(720);
        video1.setLengthInSeconds(3600); //1 hour
        video1.calculateFileSize();

        VideoCalculator video2 = new VideoCalculator();
        video2.setResolution(1080);
        video2.setLengthInSeconds(3600); //1 hour
        video2.calculateFileSize();

        //write to console the file size of each video
        System.out.println(video1.toString());
        System.out.println(video2.toString());

        //changes video lengths and re-calculates file size
        video1.setLengthInSeconds(1000); //16 minutes, 40 seconds
        video1.calculateFileSize();

        video2.setLengthInSeconds(1000); //16 minutes, 40 seconds
        video2.calculateFileSize();

        //write to console new file size of each video
        System.out.println(video1.toString());
        System.out.println(video2.toString());
    }

}