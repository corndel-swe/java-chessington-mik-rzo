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
}