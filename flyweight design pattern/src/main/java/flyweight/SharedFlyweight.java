package com.hundredwordsgof.flyweight;

/**
 * 
 * SharedFlyweight,implements Flyweight, and add storage for intrisnic state.
 * Addding a comment to see if I can kick off a build with Travis CI.
 *
 */
public class SharedFlyweight implements Flyweight {

  private Object intrinsicState;

  public SharedFlyweight(Object intrinsicState) {
    this.intrinsicState = intrinsicState;
  }

  // Using extrinsicState as context and does NOT modify intrinsic state.
  public void operation(Object extrinsicState) {
  }

  /**
   * @return intrinsic state
   */
  public Object getIntrinsicState() {
    return intrinsicState;
  }
}
