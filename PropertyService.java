import java.util.*;
import java.util.stream.*;

public class PropertyService {

    private List<Property> properties = new ArrayList<>();

    
    public void addProperty(Property p) {
        properties.add(p);
    }

    
    public void viewAll() {
        if (properties.isEmpty()) {
            System.out.println("No properties available.");
            return;
        }
        for(Property p : properties)
        {
            System.out.println(p);
        }
    }

    
    public void filterByCity(String city) {
        List<Property> result = properties.stream()
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No properties found in this city.");
        } else {
           for(Property p : result)
           {
            System.out.println(p);
           }
        }
    }

    
    public void filterByPrice(double min, double max) {
        List<Property> result = properties.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No properties found in this price range.");
        } else {
           for(Property p : result)
           {
            System.out.println(p);
           }
        }
    }

    
    public void sortByPrice() {
        List<Property> sorted = properties.stream()
                .sorted(Comparator.comparingDouble(Property::getPrice))
                .collect(Collectors.toList());

        if(sorted.isEmpty())
        {
            System.out.println("No properties to sort.");
        }
        else{
            for(Property p : sorted){
                System.out.println(p);
            }
        }
    }
}