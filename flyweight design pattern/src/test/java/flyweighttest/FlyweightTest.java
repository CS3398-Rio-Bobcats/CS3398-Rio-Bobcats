package com.hundredwordsgof.flyweight;

//import static org.junit.Assert.*;
//import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test Flyweight pattern.
 */
public class FlyweightTest {

  @Test
  public void testFlyweight() {

    // Create 3 SharedFlyweight instances.
    Flyweight sharedflyweight1 = FlyweightFactory.getFlyweight("key1", "value1");
    Flyweight sharedflyweight2 = FlyweightFactory.getFlyweight("key2", "value2");
    Flyweight sharedflyweight3 = FlyweightFactory.getFlyweight("key1", "value3");

    // Create 3 UnSharedFlyweight instances. 
    Flyweight unsharedFlyweight1 = FlyweightFactory.getFlyweight("unsharedKey1",
        "value1");
    Flyweight unsharedFlyweight2 = FlyweightFactory.getFlyweight("unsharedKey2",
        "value2");
    Flyweight unsharedFlyweight3 = FlyweightFactory.getFlyweight("unsharedKey1",
        "value3");

    // 3 shared flyweight object equivalency tests
    assertNotEquals(sharedflyweight1, sharedflyweight2);
    assertEquals(sharedflyweight1, sharedflyweight3);
    assertNotEquals(sharedflyweight2, sharedflyweight3);

    // 3 unshared flyweight object non-equivalency tests
    assertNotEquals(unsharedFlyweight1, unsharedFlyweight2);
    assertNotEquals(unsharedFlyweight1, unsharedFlyweight3);
    assertNotEquals(unsharedFlyweight2, unsharedFlyweight3);

   // 3 shared flyweight tests assessing the values for the shared (instrinsic) state.

    if (sharedflyweight1 instanceof com.hundredwordsgof.flyweight.SharedFlyweight) {
      assertEquals("value1",
          ((com.hundredwordsgof.flyweight.SharedFlyweight) sharedflyweight1)
              .getIntrinsicState());
    }

    if (sharedflyweight2 instanceof com.hundredwordsgof.flyweight.SharedFlyweight) {
      assertEquals("value2",
          ((com.hundredwordsgof.flyweight.SharedFlyweight) sharedflyweight2)
              .getIntrinsicState());
    }

    if (sharedflyweight3 instanceof com.hundredwordsgof.flyweight.SharedFlyweight) {
      assertEquals("value1",
          ((com.hundredwordsgof.flyweight.SharedFlyweight) sharedflyweight3)
              .getIntrinsicState());
    }

    // 3 unshared flyweight tests assessing the values of their states.

    if (unsharedFlyweight1 instanceof com.hundredwordsgof.flyweight.UnSharedFlyweight) {
      assertEquals("value1",
          ((com.hundredwordsgof.flyweight.UnSharedFlyweight) unsharedFlyweight1)
              .getState());
    }

    if (unsharedFlyweight2 instanceof com.hundredwordsgof.flyweight.UnSharedFlyweight) {
      assertEquals("value2",
          ((com.hundredwordsgof.flyweight.UnSharedFlyweight) unsharedFlyweight2)
              .getState());
    }

    if (unsharedFlyweight3 instanceof com.hundredwordsgof.flyweight.UnSharedFlyweight) {
      assertEquals("value3",
          ((com.hundredwordsgof.flyweight.UnSharedFlyweight) unsharedFlyweight3)
              .getState());
    }
  }
}
