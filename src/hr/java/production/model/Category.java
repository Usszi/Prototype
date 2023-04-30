package hr.java.production.model;

import java.io.Serializable;
import java.util.Objects;

public class Category extends NamedEntity implements Serializable {
    private String description;

    public Category(Long id,String name, String description) {
        super(id,name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "description='"+getId()+getName() + description +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description);
    }


}
