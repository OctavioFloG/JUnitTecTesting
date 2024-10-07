package org.example;

public class Rectangulo {
    private double base, altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getArea() {
        double area = 0;
        area = this.base * this.altura;
        return area;
    }

    public double getPerimetro() {
        double perimetro = 0;
        perimetro = this.base * 2 + this.altura * 2;
        return perimetro;
    }
}
