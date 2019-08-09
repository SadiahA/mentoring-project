package com.msm.app;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        TemperatureConverter temperatureConverter = new TemperatureConverter();

        double celsius = 0;
        try {
            celsius = temperatureConverter.convert(100);
        } catch (InvalidTemperatureException e) {
            e.printStackTrace();
        }

        System.out.println(celsius);

        double[] tempInFahrenheit = {30.5, -20.0, 10.0};

        try {
            temperatureConverter.convert(tempInFahrenheit);
        } catch (InvalidTemperatureException e) {
            e.printStackTrace();
        }

    }
}
