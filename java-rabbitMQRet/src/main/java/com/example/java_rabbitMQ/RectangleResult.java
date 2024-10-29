package com.example.java_rabbitMQ;
public class RectangleResult {
  private double base;
  private double altura;
  private double area;
  private double perimetro;

  public RectangleResult(double base, double altura, double area, double perimetro) {
    this.base = base;
    this.altura = altura;
    this.area = area;
    this.perimetro = perimetro;
  }

  public double getBase() {
    return base;
  }

  public double getAltura() {
    return altura;
  }

  public double getArea() {
    return area;
  }

  public double getPerimetro() {
    return perimetro;
  }

  @Override
  public String toString() {
    return "RectangleResult{" +
        "base=" + base +
        ", altura=" + altura +
        ", area=" + area +
        ", perimetro=" + perimetro +
        '}';
  }
}
