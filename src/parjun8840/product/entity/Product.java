package parjun8840.product.entity;
/*
 * This is abstract class and can't be instantiated and the purpose is for DRY principle.
 * We don't want client to create Object of Product class.
 * We can use Product to create Pointer.
 */
public abstract class Product {
private int id;
private String name;
private double price;
//Constructors are involved when objects are created. Compiler creates default constructor & it will have the same name
//as that of of class & doesn't return type. If we write our own constructor then compiler doesn't creates one for us.
//Always a constructor is require to create an object.
public Product() { // Right click -> source -> generate constructor using fields.
}
public Product(int id, String name, double price) {
	this.id = id;
	this.name = name;
	this.price = price;
}
//As this is an entity class, we would be having getter and setter.
//Right click -> source -> generate setters and getters.

public int getId() {
	return id;
}
public void setId(int id) {// In setters to avoid ambiguity between local and instance variables "this" is use.
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

// We aren't able to provide logic here. And if we don't define isExpensive then we can't achieve polymorphism.
//DRY principle can't be achieve as we have to define Mobile.isEpensive, Tv.isExpensive etc
public abstract boolean isExpensive();

}
