package pl.konmarek.firstspringexample.pizza;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.konmarek.firstspringexample.repository.PizzaRepo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private int size;
    private String name;
    private List<String> ingredients;

    public Pizza(int price, int size, String name, List<String> ingredients) {
        this.price = price;
        this.size = size;
        this.ingredients = ingredients;
        this.name = name;
    }

    @JsonIgnore
    public double getPrice() {
        return price;
    }

    @JsonIgnore
    public int getSize() {
        return size;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return price == pizza.price &&
                Objects.equals(size, pizza.size) &&
                Objects.equals(ingredients, pizza.ingredients) &&
                Objects.equals(name, pizza.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, size, ingredients, name);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "price=" + price +
                ", size='" + size + '\'' +
                ", ingredients=" + ingredients +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        List<Pizza> pizzas = getPizzas();

        pizzas.stream()
                .map(pizza -> pizza.getName())
                .collect(Collectors.toList())
                .forEach(s -> System.out.println("pizza name: " + s));

        List<String> uniqeIng = pizzas.stream()
                .map(pizza -> pizza.getIngredients())
                .flatMap(ingredientsList -> ingredientsList.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("ing: " + uniqeIng);


    }

    public static List<Pizza> getPizzas() {
        return PizzaRepo.pizzas;

    }
}

