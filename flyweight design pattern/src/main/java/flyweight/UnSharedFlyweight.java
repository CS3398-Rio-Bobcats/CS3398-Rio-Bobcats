package com.hundredwordsgof.flyweight;

/**
 * UnsharedFlyweight, defines objects which are not shared.
 *
 */
public class UnSharedFlyweight implements Flyweight {

  private Object state;

  public UnSharedFlyweight(Object state) {
    this.state = state;
  }

  public void operation(Object extrinsicState) {

  }

  public Object getState() {
    return state;
  }
}
