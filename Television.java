public class Television {
    
    private String brand;
    private String model;
    private String serialNumber;
    private double price;

    
    public Television(String brand, String model, String serialNumber, double price) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Бренд: " + brand +
                "\nМодель: " + model +
                "\nСерийный номер: " + serialNumber +
                String.format("\nСтоимость: $%.2f", price);
    }
}
class App {
    public static void main(String[] args) {

        Television tv1 = new Television("Samsung", "QLED 75Q80A", "SN-SAM-12345", 1299.99);
        Television tv2 = new Television("LG", "OLED55C1", "SN-LG-67890", 1499.00);
        Television tv3 = new Television("Sony", "XR-55A80J", "SN-SONY-54321", 1399.49);

        
        System.out.println("===== Телевизор 1 =====");
        System.out.println(tv1);

        System.out.println("\n===== Телевизор 2 =====");
        System.out.println(tv2);

        System.out.println("\n===== Телевизор 3 =====");
        System.out.println(tv3);

    }
}
