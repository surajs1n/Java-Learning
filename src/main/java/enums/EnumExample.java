package enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EnumExample {
    private enum Level {
        HIGH,
        MEDIUM,
        LOW,
        VERY_LOW
    }

    private static void doItForLevels() {
        // Print normally;
        System.out.println(Level.HIGH);
        System.out.println(Level.MEDIUM);
        System.out.println(Level.LOW);
        System.out.println(Level.VERY_LOW);

        // Print using toString();
        System.out.println(Level.HIGH.toString());
        System.out.println(Level.MEDIUM.toString());
        System.out.println(Level.LOW.toString());
        System.out.println(Level.VERY_LOW.toString());

        for(Level level: Level.values()) {
            System.out.println(level);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            if (Level.HIGH.equals(input)) {
                System.out.println("Input is HIGH.");
            } else if (Level.MEDIUM.equals(input)) {
                System.out.println("Input is MEDIUM.");
            } else if (Level.LOW.equals(input)) {
                System.out.println("Input is LOW.");
            } else if (Level.VERY_LOW.equals(input)) {
                System.out.println("Input is VERY LOW.");
            } else {
                System.out.println("Input is something else.");
            }

            // This seems like the best way to compare the string converted ENUM with input string.
            input = reader.readLine();
            if (Level.HIGH.toString().equals(input)) {
                System.out.println("Input is HIGH.");
            } else if (Level.MEDIUM.toString().equals(input)) {
                System.out.println("Input is MEDIUM.");
            } else if (Level.LOW.toString().equals(input)) {
                System.out.println("Input is LOW.");
            } else if (Level.VERY_LOW.toString().equals(input)) {
                System.out.println("Input is VERY LOW.");
            } else {
                System.out.println("Input is something else.");
            }

            input = reader.readLine();
            switch (Level.valueOf(input)) {
                case HIGH:     System.out.println("Input is HIGH.");          break;
                case MEDIUM:   System.out.println("Input is MEDIUM.");        break;
                case LOW:      System.out.println("Input is LOW.");           break;
                case VERY_LOW: System.out.println("Input is VERY LOW.");      break;
                default:       System.out.println("Input is something else"); break;
            }
        } catch (IOException e) {
            System.err.println("Input Exception.");
        }
    }

    @Data
    private static class DrivingLicenseData {
        private String country;
        private String state;
        private int cityCode;

        public DrivingLicenseData(final String country, final String state, final int cityCode) {
            this.country = country;
            this.state = state;
            this.cityCode = cityCode;
        }
    }

    private enum DrivingLicensePlace {
        KANPUR(1,"India", "UP", 72),
        DHANBAD(2,"India", "Jharkhand", 32),
        BANGLORE(3,"India", "Karnataka", 23),
        LUCKNOW(4,"India", "UP", 32),
        RANCHI(5,"India", "Bihar", 12),
        SINGAPORE(6,"Malaysia", "Singapore", 22);

        private final int Id;
        private final String country;
        private final String state;
        private final int cityCode;

        DrivingLicensePlace(final int Id, final String country, final String state, final int cityCode) {
            this.Id = Id;
            this.country = country;
            this.state = state;
            this.cityCode = cityCode;
        }

        private static final Map<Integer, DrivingLicensePlace> dlMap = new HashMap<>();
        static {
            for(DrivingLicensePlace place : DrivingLicensePlace.values()) {
                dlMap.put(place.Id, place);
            }
        }

        public static DrivingLicensePlace getDrivingLicensePlace(final Integer id) throws Exception {
            if (dlMap.containsKey(id)) {
                return dlMap.get(id);
            } else  {
                throw new Exception("Couldn't find what you are looking for.");
            }
        }

        public DrivingLicenseData getDLValues() {
            return new DrivingLicenseData(this.country, this.state, this.cityCode);
        }
    }

    private static void doItForTypes() throws Exception {
        DrivingLicensePlace license = DrivingLicensePlace.BANGLORE;
        System.out.println(license + " has values => " + license.getDLValues() + " license\'s hashCode => " + license.hashCode());

        license = DrivingLicensePlace.KANPUR;
        System.out.println(license + " has values => " + license.getDLValues() + " license\'s hashCode => " + license.hashCode());

        license = DrivingLicensePlace.getDrivingLicensePlace(5);
        System.out.println(license + " has values => " + license.getDLValues() + " license\'s hashCode => " + license.hashCode());

        List<DrivingLicensePlace> drivingLicensePlaceList = new ArrayList<>();
        drivingLicensePlaceList.add(DrivingLicensePlace.BANGLORE);
        drivingLicensePlaceList.add(DrivingLicensePlace.BANGLORE);
        System.out.println(drivingLicensePlaceList);

        EnumSet<DrivingLicensePlace> drivingLicensePlaceSet = EnumSet.of(DrivingLicensePlace.SINGAPORE, DrivingLicensePlace.RANCHI);
        System.out.println(drivingLicensePlaceSet);
    }

    public static void main(String []args) throws Exception {
        doItForLevels();
        for(int i=0; i<80; i++)
            System.out.print("*");
        System.out.print("\n");
        doItForTypes();
    }
}
