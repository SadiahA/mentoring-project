package com.msm.app;

import java.util.ArrayList;
import java.util.List;

public class TemperatureConverter {

    public TemperatureConverter() {
    }

    public double convert(double fahrenheit) throws InvalidTemperatureException {
        if (fahrenheit > -459.67) {
            double celsius = (fahrenheit - 32) * (5d/9d);
            return Math.round(celsius * 100.0)/100.0;
        } else {
            throw new InvalidTemperatureException("Temperature must be less than Absolute zero");
        }
    }

    public double[] convert(double[] fahrenheit) throws InvalidTemperatureException {
        double[] temperatureInCelsiusArray = new double[fahrenheit.length];

        for(int i=0; i < fahrenheit.length; i++) {
            temperatureInCelsiusArray[i] = convert(fahrenheit[i]);
        }
         return temperatureInCelsiusArray;
    }

    public List<Double> convert(List<Double> fahrenheitList) throws InvalidTemperatureException {

        List<Double> tempListInCelsius = new ArrayList<>();

        for (double f : fahrenheitList) {
            tempListInCelsius.add(convert(f));
        }
        return tempListInCelsius;
    }


}
