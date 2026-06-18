import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        PropertyService service = new PropertyService();

        while(true)
        {
            System.out.println("\n===== Property Manager =====");
            System.out.println("1. Add Property");
            System.out.println("2. View All Properties");
            System.out.println("3. Filter by City");
            System.out.println("4. Filter by Price Range");
            System.out.println("5. sort by price");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");



            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Type: ");
                    String type = sc.nextLine();

                    Property p = new Property(id, city, price, type);
                    service.addProperty(p);

                    System.out.println("Property Added Successfully");
                    break;

                case 2:
                    service.viewAll();
                    break;
                case 3:
                    
                    System.out.print("Enter City: ");
                    sc.nextLine();
                    String searchCity = sc.nextLine();
                    service.filterByCity(searchCity);
                    break;
                case 4:
                    System.out.print("Enter Min Price: ");
                    double min = sc.nextDouble();
                    System.out.print("Enter Max Price: ");
                    double max = sc.nextDouble();
                    service.filterByPrice(min, max);
                    break;
                case 5:
                    service.sortByPrice();
                    break;
                case 6:
                    System.out.println("Exiting.....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");


            }
        }
    }
}