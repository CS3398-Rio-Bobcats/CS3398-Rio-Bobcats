package com.hundredwordsgof.flyweight;

import org.joda.time.LocalTime;

public class MainProgram {
  public static void main(String[] args)
  {
    //Initialize Subject
    SharedFlyweight sfwRed,sfwWhite, sfwBlue; 
    UnSharedFlyweight usfwGreen, usfwYellow, usfwPink;

    LocalTime currentTime = new LocalTime();
    System.out.println("The local time is: " + currentTime);
    
    FlyweightFactory fwFactory = new FlyweightFactory();
    
    Flyweight sharedflyweightRed = fwFactory.getFlyweight("key1", "red");
    Flyweight sharedflyweightWhite = fwFactory.getFlyweight("key2", "white");
    Flyweight sharedflyweightBlue = fwFactory.getFlyweight("key1", "blue");

    Flyweight unsharedflyweightGreen = fwFactory.getFlyweight("unsharedKey1",
        "green");
    Flyweight unsharedflyweightYellow = fwFactory.getFlyweight("unsharedKey2",
        "yellow");
    Flyweight unsharedflyweightPink = fwFactory.getFlyweight("unsharedKey1",
        "pink");

    
    sfwRed = (SharedFlyweight) sharedflyweightRed;
    sfwWhite = (SharedFlyweight) sharedflyweightWhite;
    sfwBlue = (SharedFlyweight) sharedflyweightBlue;

    System.out.println(sfwRed.getIntrinsicState());
    System.out.println(sfwWhite.getIntrinsicState());
    System.out.println(sfwBlue.getIntrinsicState());

    usfwGreen = (UnSharedFlyweight) unsharedflyweightGreen;
    usfwYellow = (UnSharedFlyweight) unsharedflyweightYellow;
    usfwPink = (UnSharedFlyweight) unsharedflyweightPink;

    System.out.println(usfwGreen.getState());
    System.out.println(usfwYellow.getState());
    System.out.println(usfwPink.getState());



  }
}
