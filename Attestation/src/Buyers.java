import java.util.*;
import java.util.stream.Collectors;

class Product {
 private String name;
 private double cost;

 public Product(String name, double cost) {
  setName(name);
  setCost(cost);
 }

 public String getName() {
  return name;
 }

 public double getCost() {
  return cost;
 }

 public void setName(String name) {
  if (name == null || name.trim().isEmpty()) {
   throw new IllegalArgumentException("Имя продукта не может быть пустым");
  }
  this.name = name;
 }

 public void setCost(double cost) {
  if (cost < 0) {
   throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной");
  }
  this.cost = cost;
 }

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  Product product = (Product) o;
  return Double.compare(product.cost, cost) == 0 &&
          Objects.equals(name, product.name);
 }

 @Override
 public int hashCode() {
  return Objects.hash(name, cost);
 }

 @Override
 public String toString() {
  return name;
 }
}

class Person {
 private String name;
 private double money;
 private List<Product> products = new ArrayList<>();

 public Person(String name, double money) {
  setName(name);
  setMoney(money);
 }

 public String getName() {
  return name;
 }

 public double getMoney() {
  return money;
 }

 public List<Product> getProducts() {
  return products;
 }

 public void setName(String name) {
  if (name == null || name.trim().isEmpty()) {
   throw new IllegalArgumentException("Имя не может быть пустым");
  }
  if (name.length() < 3) {
   throw new IllegalArgumentException("Имя не может быть короче 3 символов");
  }
  this.name = name;
 }

 public void setMoney(double money) {
  if (money < 0) {
   throw new IllegalArgumentException("Деньги не могут быть отрицательными");
  }
  this.money = money;
 }

 public boolean buyProduct(Product product) {
  if (product.getCost() <= money) {
   products.add(product);
   money -= product.getCost();
   System.out.println(name + " купил(а) " + product.getName());
   return true;
  }
  System.out.println(name + " не может позволить себе " + product.getName());
  return false;
 }

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  Person person = (Person) o;
  return Double.compare(person.money, money) == 0 &&
          Objects.equals(name, person.name) &&
          Objects.equals(products, person.products);
 }

 @Override
 public int hashCode() {
  return Objects.hash(name, money, products);
 }

 @Override
 public String toString() {
  if (products.isEmpty()) {
   return name + " - Ничего не куплено";
  }
  return name + " - " + products.stream()
          .map(Product::getName)
          .collect(Collectors.joining(", "));
 }
}

class App {
 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  Map<String, Person> people = new HashMap<>();
  Map<String, Product> products = new HashMap<>();

  // Ввод покупателей
  System.out.println("Введите покупателей в формате: Имя = Сумма");
  String input;
  while (!(input = scanner.nextLine()).isEmpty()) {
   try {
    String[] parts = input.split("=");
    String name = parts[0].trim();
    double money = Double.parseDouble(parts[1].trim());
    people.put(name, new Person(name, money));
   } catch (Exception e) {
    System.out.println(e.getMessage());
   }
  }

  // Ввод продуктов
  System.out.println("Введите продукты в формате: Название = Стоимость");
  while (!(input = scanner.nextLine()).isEmpty()) {
   try {
    String[] parts = input.split("=");
    String name = parts[0].trim();
    double cost = Double.parseDouble(parts[1].trim());
    products.put(name, new Product(name, cost));
   } catch (Exception e) {
    System.out.println(e.getMessage());
   }
  }

  // Обработка покупок
  System.out.println("Введите покупки в формате: Имя покупателя - Название продукта (END для завершения)");
  while (!(input = scanner.nextLine()).equalsIgnoreCase("END")) {
   try {
    String[] parts = input.split("-");
    String personName = parts[0].trim();
    String productName = parts[1].trim();

    Person person = people.get(personName);
    Product product = products.get(productName);

    if (person == null) {
     System.out.println("Покупатель не найден: " + personName);
     continue;
    }
    if (product == null) {
     System.out.println("Продукт не найден: " + productName);
     continue;
    }

    person.buyProduct(product);
   } catch (Exception e) {
    System.out.println("Ошибка формата: используйте 'Имя - Продукт'");
   }
  }

  // Вывод результатов
  System.out.println("\nРезультаты покупок:");
  for (Person person : people.values()) {
   System.out.println(person);
  }
 }
}
