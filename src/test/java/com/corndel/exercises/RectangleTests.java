package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTests {
  @Test
  public void getAreaReturnsArea() {
    // arrange
    Rectangle rectangle  = new Rectangle(10, 20);

    // act
    double area = rectangle.getArea();

    // assert
    assertEquals(200, area);
  }

  @Test
  public void getPerimeterReturnsPerimeter() {
    // arrange
    Rectangle rectangle = new Rectangle(10, 20);

    // act
    double perimeter = rectangle.getPerimeter();

    // assert
    assertEquals(60, perimeter);
  }
}
