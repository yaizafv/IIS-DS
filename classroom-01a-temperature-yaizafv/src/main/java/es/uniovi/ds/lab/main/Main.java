package es.uniovi.ds.lab.main;

import es.uniovi.ds.lab.temperature.Temperatura;

public class Main {

    public static void main(String[] args) {
        Temperatura[] temperatures = new Temperatura[100];

        // Data input
        for (int i = 0; i < temperatures.length; i++)
            temperatures[i] = new Temperatura(readSensorCelsius());

        // Calculation with data in Celsius
        double meanCelsius = 0;
        for (int i = 0; i < temperatures.length; i++)
            meanCelsius += temperatures[i].getCelsius();
        meanCelsius = meanCelsius / temperatures.length;
        System.out.println(meanCelsius);

        // Calculation with data in Fahrenheit
        double meanFahrenheit = 0;
        for (int i = 0; i < temperatures.length; i++)
            meanFahrenheit += temperatures[i].getFahrenheit();
        meanFahrenheit = meanFahrenheit / temperatures.length;
        System.out.println(meanFahrenheit);

        // Another calculation with data in Fahrenheit
        double variance = 0;
        for (int i = 0; i < temperatures.length; i++)
            variance += Math.pow((temperatures[i].getFahrenheit()) - meanFahrenheit, 2);
        variance = variance / temperatures.length;
        System.out.println(variance);
    }

    public static double readSensorCelsius() {
        return Math.random() * 30;
    }
}
