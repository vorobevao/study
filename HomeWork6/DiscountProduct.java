package HomeWork6;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product{

    private double discount;
    private LocalDate expiryDate;

    public DiscountProduct(String name, double cost, double discount, LocalDate expiryDate) {
        super(name, cost);
        setDiscount(discount);
        setExpiryDate(expiryDate);
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        if (expiryDate == null) {
            throw new IllegalArgumentException("Дата окончания скидки не может быть пустой");
        }
        this.expiryDate = expiryDate;
    }
    @Override
    public double getCost() {
        if (LocalDate.now().isAfter(expiryDate)) {
            return super.getCost(); // Возвращаем полную цену после истечения срока
        }
        double discountedPrice = super.getCost() - discount;
        return Math.max(discountedPrice, 0); // Цена не может быть отрицательной
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Double.compare(that.discount, discount) == 0 &&
                Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, expiryDate);
    }

    @Override
    public String toString() {
        return super.getName() + " (Обычная цена: " + super.getCost() +
                ", Скидка: " + discount +
                ", Цена со скидкой: " + getCost() +
                ", Скидка действует до: " + expiryDate + ")";
    }
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount <= 0) {
            throw new IllegalArgumentException("Скидка должна быть положительной");
        }
        if (discount >= super.getCost()) {
            throw new IllegalArgumentException("Скидка не может быть больше или равна стоимости продукта");
        }
    }
    @Override
    public String toString() {
        return super.getName() + " (Обычная цена: " + super.getCost() +
                ", Скидка: " + discount +
                ", Цена со скидкой: " + getCost() +
                ", Скидка действует до: " + expiryDate + ")";
}
