package hr.java.production.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Item extends  NamedEntity implements Serializable {

    private Discount discount;
    private Category category;
    private BigDecimal width;
    private BigDecimal highth;
    private BigDecimal lenght;
    private BigDecimal productionCost;
    private BigDecimal sellingPrice;

    public Item(Long id,Discount discount,String name, Category category, BigDecimal width, BigDecimal highth, BigDecimal lenght, BigDecimal productionCost, BigDecimal sellingPrice) {
        super(id,name);
        this.discount = discount;
        this.category = category;
        this.width = width;
        this.highth = highth;
        this.lenght = lenght;
        this.productionCost = productionCost;
        this.sellingPrice = sellingPrice;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHighth() {
        return highth;
    }

    public void setHighth(BigDecimal highth) {
        this.highth = highth;
    }

    public BigDecimal getLenght() {
        return lenght;
    }

    public void setLenght(BigDecimal lenght) {
        this.lenght = lenght;
    }

    public BigDecimal getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(BigDecimal productionCost) {
        this.productionCost = productionCost;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + getId() +
                "discount=" + discount +
                "name=" + getName() +
                ", category=" + category +
                ", width=" + width +
                ", highth=" + highth +
                ", lenght=" + lenght +
                ", productionCost=" + productionCost +
                ", sellingPrice=" + sellingPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return Objects.equals(discount, item.discount) && Objects.equals(category, item.category) && Objects.equals(width, item.width) && Objects.equals(highth, item.highth) && Objects.equals(lenght, item.lenght) && Objects.equals(productionCost, item.productionCost) && Objects.equals(sellingPrice, item.sellingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, category, width, highth, lenght, productionCost, sellingPrice);
    }
}
