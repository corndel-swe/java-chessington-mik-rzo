package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTests {
  @Test
  public void piEqualTo3dot14() {
    assertEquals(3.14, Maths.PI);
  }

  @Test
  public void maxReturnsLargestOfTwoNumbers() {
    assertEquals(8, Maths.max(5, 8));
  }

  @Test
  public void roundReturnsSameNumberGivenInteger() {
    assertEquals(5, Maths.round(5));
  }

  @Test
  public void roundReturnsNumberRoundedDown() {
    assertEquals(8, Maths.round(8.2));
  }

  @Test
  public void roundReturnsNumberRoundedUp() {
    assertEquals(10, Maths.round(9.6));
  }
}