package sit707_week5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherControllerTest {

    private static WeatherController weatherController;
    private static int[] temperatureValues;

    @Before
    public void setUp() {
        if (weatherController == null) {
            weatherController = WeatherController.getInstance();
            int totalHours = weatherController.getTotalHours();
            temperatureValues = new int[totalHours];
            for (int hour = 1; hour <= totalHours; hour++) {
                temperatureValues[hour - 1] = weatherController.getTemperatureForHour(hour);
            }
        }
    }

    @After
    public void tearDown() {
        // Ensure we don't close the WeatherController instance to avoid resetting cached values
    }

    @Test
    public void testStudentIdentity() {
        // Provide your name and ID to fix the test
        String studentId = "s223676061";
        assertNotNull("Student ID is", studentId);
    }

    @Test
    public void testStudentName() {
        // Provide your name to fix the test
        String studentName = "Dhruv Kaswala";
        assertNotNull("Student name is", studentName);
    }

    @Test
    public void testTemperatureMin() {
        int minTemperature = weatherController.getTemperatureMinFromCache();
        int calculatedMin = calculateMin(temperatureValues);
        assertEquals(calculatedMin, minTemperature);
    }

    @Test
    public void testTemperatureMax() {
        int maxTemperature = (int) weatherController.getTemperatureMaxFromCache();
        int calculatedMax = calculateMax(temperatureValues);
        assertEquals(calculatedMax, maxTemperature);
    }

    @Test
    public void testTemperatureAverage() {
        int averageTemperature = (int) weatherController.getTemperatureAverageFromCache();
        int calculatedAverage = calculateAverage(temperatureValues);
        assertEquals(calculatedAverage, averageTemperature);
    }

    // Helper methods for calculating min, max, and average
    private int calculateMin(int[] values) {
        int min = Integer.MAX_VALUE;
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private int calculateMax(int[] values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private int calculateAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}
