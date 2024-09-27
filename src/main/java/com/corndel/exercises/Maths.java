package com.corndel.exercises;

public class Maths {
  public static double PI = 3.14;

  public static double max(double a, double b) {
    return a > b ? a : b;
  }

  public static int round(double n) {
    double decimal = n - (int) n;
    return decimal >= 0.5 ? (int) n + 1 : (int) n;
  }
}
