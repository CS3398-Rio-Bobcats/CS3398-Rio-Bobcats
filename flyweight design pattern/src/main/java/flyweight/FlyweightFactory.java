package com.hundredwordsgof.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * FlyweightFactory, creates and manages the flyweight objects.
 *
 */
public class FlyweightFactory {

  private static Map<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

  /**
   * Returns Flyweight object. Just for sake of example following logic is
   * applied, if key starts with phrase:unshared than UnsharedFlyweight
   * object is created. Otherwise SharedFlyweight object is created.
   * 
   * @param key
   * @return Flyweight
   * 
   */

   

  public static Flyweight getFlyweight(String key, String value) {

    if (key.startsWith("unshared")) {
      flyweights.put(key, new UnSharedFlyweight(value));
    } else {
      if (!flyweights.containsKey(key)) {
        flyweights.put(key, new SharedFlyweight(value));
      }
    }

    return (Flyweight) flyweights.get(key);
  }
}
