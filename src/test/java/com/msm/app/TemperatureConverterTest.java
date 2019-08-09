package com.msm.app;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TemperatureConverterTest {

    private TemperatureConverter temperatureConverter;

    @Before
    public void setUp() throws Exception {
        temperatureConverter = new TemperatureConverter();
    }

    @Test
    public void shouldConvertSingleFahrenheitValueToCelsius() throws InvalidTemperatureException {
        // when
        double actualCelsius = temperatureConverter.convert(75);

        // then
        assertEquals(23.89, actualCelsius, 0);
    }

    @Test
    public void shouldConvertArrayOfFahrenheitValuesToCelsius() throws InvalidTemperatureException {
        // given
        double[] tempArrayInFahrenheit = new double[]{-40, 70, 90};
        double[] expectedArrayInCelsius = {-40.0, 21.11, 32.22};

        // when
        double[] actualArrayInCelsius = temperatureConverter.convert(tempArrayInFahrenheit);

        // then
        assertArrayEquals(expectedArrayInCelsius, actualArrayInCelsius, 0);
    }

    @Test
    public void shouldConvertListOfFahrenheitValuesToCelsius() throws InvalidTemperatureException {
        // given
        List<Double> tempListInFahrenheit = Arrays.asList(-30.0, 60.0, 102.0);
        List<Double> expectedTempsInCelsius = Arrays.asList(-34.44, 15.56,38.89);
        // when
        List<Double> actualTempsInFahrenheit = temperatureConverter.convert(tempListInFahrenheit);

        // then
        assertEquals(expectedTempsInCelsius, actualTempsInFahrenheit);
    }


    @Test(expected = InvalidTemperatureException.class)
    public void shouldThrowExceptionWhenConvertingAbsoluteValueFromFahrenheitToCelsius() throws InvalidTemperatureException {
        temperatureConverter.convert(-459.67);
    }

    @Test(expected = InvalidTemperatureException.class)
    public void shouldThrowExceptionWhenConvertingAbsoluteValueFromFahrenheitToCelsiusInArray() throws InvalidTemperatureException {
        // given
        double[] tempArrayInFahrenheit = new double[]{-40, -459.67, 90};

        // when
        temperatureConverter.convert(tempArrayInFahrenheit);
    }

    @Test(expected = InvalidTemperatureException.class)
    public void shouldThrowExceptionWhenConvertingAbsoluteValueFromFahrenheitToCelsiusInList() throws InvalidTemperatureException {
        // given
        List<Double> tempListInFahrenheit = Arrays.asList(-30.0, 60.0, -459.67);

        // when
        temperatureConverter.convert(tempListInFahrenheit);
    }

    @Test
    public void sun() throws InvalidTemperatureException {
        double convert = temperatureConverter.convert(9941);
        assertThat(convert, is(5505.0));
    }

    @Test(expected = InvalidTemperatureException.class)
    public void shouldThrowExceptionForInvalidTemperature() throws InvalidTemperatureException {
        temperatureConverter.convert(-460);
    }
}