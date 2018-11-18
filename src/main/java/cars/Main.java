package cars;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

        carModels
                .stream()
                .limit(10)
                .forEach(Main::printCarModel);

    }

    private static void printCarModel(CarModel x) {
        String line = String.format("%d %s %s %s %d %d %d %d",
                x.year,
                x.division,
                x.carline,
                x.engineDisplay,
                x.numberOfCylinders,
                x.cityFuelEfficiency,
                x.highwayFuelEfficiency,
                x.combinedFuelEfficiency);
        System.out.println(line);
    }
}
