package generator;

import data.AirportInfo;
import data.Condition;
import data.conditions.*;
import data.conditions.WeatherPhenomena;
import data.enums.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 27.03.17.
 */
public class AirportInfoGenerator {
    private final Random RANDOM = new Random();
    private final int MIN_DAY = (int) LocalDate.of(2016, 1, 1).toEpochDay();
    private final int MAX_DAY = (int) LocalDate.of(2017, 3, 25).toEpochDay();
    private AirportInfo airportInfo;
    private Condition condition;
    private Pressure pressure;

    public AirportInfoGenerator() {
    }

    public AirportInfo generate() {
        airportInfo = new AirportInfo();
        airportInfo.setAirport(generateAirport());
        airportInfo.setDate(generateDate());
        airportInfo.setCondition(generateCondition());

        return airportInfo;
    }

    public List<AirportInfo> generate(int count) {
        if (count > 0) {
            List<AirportInfo> infos = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                infos.add(this.generate());
            }
            return infos;
        } else throw new IllegalArgumentException("Count should be positive!");
    }

    private Airport generateAirport() {
        return Airport.randomAirport();
    }

    private LocalDate generateDate() {
        long randomDay = MIN_DAY + RANDOM.nextInt(MAX_DAY - MIN_DAY);
        LocalDate day = LocalDate.ofEpochDay(randomDay);
        return day;
    }

    private Condition generateCondition() {
        condition = new Condition();
        condition.setIKAO(airportInfo.getAirport().getIkao());
        condition.setPressure(new Pressure(PressureType.randomPressureType(), RANDOM.nextInt(9999)));
        condition.setSkyCondition(new SkyCondition(SkyConditions.randomSkyCondition(), RANDOM.nextInt(999)));
        condition.setTemperature(new Temperature(RANDOM.nextInt((99 - -99) + 1) + -99, RANDOM.nextInt((99 - -99) + 1) + -99));
        condition.setTime(new Time(airportInfo.getDate().getDayOfMonth() + 1, airportInfo.getDate().getMonthValue() + 1, RANDOM.nextInt(60)));
        condition.setType(data.enums.Type.randomType());
        condition.setVisibility(new Visibility(RANDOM.nextInt(9999), DistanceType.randomDistanceType(), new Runway(RANDOM.nextInt(9), 'R')));
        condition.setWind(new Wind(RANDOM.nextInt(360), RANDOM.nextInt(99), RANDOM.nextInt(99), Speed.randomSpeed()));
        List<data.enums.WeatherPhenomena> phenomenas = new ArrayList<>();
        for (int i = 0; i < RANDOM.nextInt(5); i++) {
            phenomenas.add(data.enums.WeatherPhenomena.randomWeatherPhenomena());
        }
        condition.setWeatherPhenomena(new WeatherPhenomena(Qualifier.randomQualifier(), Specification.randomSpecification(), phenomenas));

        return condition;
    }
}
