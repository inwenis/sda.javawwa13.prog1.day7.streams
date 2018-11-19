package cars;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        File file = new File(classLoader.getResource("cars/fuel.csv").getFile());
        Path path = Paths.get(file.getAbsolutePath());
        List<String> allLInes = Files.readAllLines(path);

        // Model Year,Division,Carline,Eng Displ,# Cyl,City FE,Hwy FE,Comb FE

        // Exercise 1 - read data from CSV into objects
        List<CarModel> carModels = allLInes
                .stream()
                .skip(1) // skip headers
                .map(x -> {
                    String[] split = x.split(",");
                    CarModel carModel = new CarModel();
                    carModel.year = Integer.parseInt(split[0]);
                    carModel.division = split[1];
                    carModel.carline = split[2];
                    carModel.engineDisplay = split[3];
                    carModel.numberOfCylinders = Integer.parseInt(split[4]);
                    carModel.cityFuelEfficiency = Integer.parseInt(split[5]);
                    carModel.highwayFuelEfficiency = Integer.parseInt(split[6]);
                    carModel.combinedFuelEfficiency = Integer.parseInt(split[7]);
                    return carModel;
                })
                .collect(Collectors.toList());

        // Exercise 2
        System.out.println("\nExercise 2 - 10 most fuel efficient cars (by city fuel efficiency)");
        printHeaders();
        carModels
                .stream()
                .sorted(Comparator.comparingInt(x -> -x.cityFuelEfficiency))
//                .sorted((a, b) -> b.cityFuelEfficiency - a.cityFuelEfficiency) // another way of comparing
                .limit(10)
                .forEach(Main::printCarModel);

        // Exercise 3
        System.out.println("\nExercise 3 - 10 most fuel efficient cars (by l/100km)");
        List<CarModelEurope> carModelsEurope = carModels
                .stream()
                .map(CarModel::toEuropeanFuelConsumption)
                .collect(Collectors.toList());

        printHeadersEurope();
        carModelsEurope
                .stream()
                .sorted(Comparator.comparingDouble(x -> x.combinedFuelConsumption))
                .limit(10)
                .forEach(Main::printCarModel);

        // Exercise 4
        System.out.println("\nExercise 4 - 10 most fuel efficient cars sorted by Carline");
        printHeaders();
        carModels
                .stream()
                .sorted(Comparator.comparingDouble((CarModel x) -> -x.cityFuelEfficiency).thenComparing(x -> x.carline))
                .limit(20)
                .forEach(Main::printCarModel);

        // Exercise 5
        System.out.println("\nExercise 5 - 10 most fuel efficient cars from Mercedes-Benz");
        printHeadersEurope();
        carModelsEurope
                .stream()
                .filter(x -> x.division.equals("Mercedes-Benz"))
                .sorted(Comparator.comparingDouble(x -> x.cityFuelConsumption))
                .limit(10)
                .forEach(Main::printCarModel);

        // Exercise 6
        System.out.println("\nExercise 6 - if present find a BMW with consumption less than 7 l/100Km");
        Optional<CarModelEurope> optionalBmw = carModelsEurope
                .stream()
                .filter(x -> x.division.equals("BMW"))
                .filter(x -> x.combinedFuelConsumption < 7)
                .findFirst();

        if (optionalBmw.isPresent()) {
            System.out.println("We have found a BMW Model with fuel consumption less than 7 l/100Km");
            printHeadersEurope();
            printCarModel(optionalBmw.get());
        } else {
            System.out.println("There is no BMW with fuel consumption less then 7 l/100Km");
        }
    }

    private static void printHeaders() {
        String line = String.format("|%10s|%30s|%20s|%10s|%10s|%10s|%10s|%10s|",
                "Model Year",
                "Division",
                "Carline",
                "Eng Displ",
                "# Cyl",
                "City FE",
                "Hwy FE",
                "Comb FE");
        System.out.println(line);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    private static void printHeadersEurope() {
        String line = String.format("|%10s|%30s|%25s|%10s|%10s|%10s|%10s|%10s|(l/100Km)",
                "Model Year",
                "Division",
                "Carline",
                "Eng Displ",
                "# Cyl",
                "City FC",
                "Hwy FC",
                "Comb FC");
        System.out.println(line);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");

    }

    private static void printCarModel(CarModel carModel) {
        String line = String.format("|%10d|%30s|%25s|%10s|%10d|%10d|%10d|%10d|",
                carModel.year,
                carModel.division,
                carModel.carline,
                carModel.engineDisplay,
                carModel.numberOfCylinders,
                carModel.cityFuelEfficiency,
                carModel.highwayFuelEfficiency,
                carModel.combinedFuelEfficiency);
        System.out.println(line);
    }

    private static void printCarModel(CarModelEurope carModelEurope) {
        String line = String.format("|%10d|%30s|%25s|%10s|%10d|%10f|%10f|%10f|",
                carModelEurope.year,
                carModelEurope.division,
                carModelEurope.carline,
                carModelEurope.engineDisplay,
                carModelEurope.numberOfCylinders,
                carModelEurope.cityFuelConsumption,
                carModelEurope.highwayFuelConsumption,
                carModelEurope.combinedFuelConsumption);
        System.out.println(line);
    }
}
