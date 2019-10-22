package parjun8840.product.ui;

import java.lang.reflect.Method;

import parjun8840.product.entity.Mobile;
import parjun8840.product.entity.Product;
import parjun8840.product.entity.Tv;

/*
 Reflection is an API which is used to examine or modify the behavior of methods, classes, interfaces at runtime.
The required classes for reflection are provided under java.lang.reflect package.
Reflection gives us information about the class to which an object belongs and also the methods of that class which can be executed by using the object.
Through reflection we can invoke methods at runtime irrespective of the access specifier used with them.
Reflection can be used to get information about –

- Class The getClass() method is used to get the name of the class to which an object belongs.
- Constructors The getConstructors() method is used to get the public constructors of the class to which an object belongs.
- Methods The getMethods() method is used to get the public methods of the class to which an objects belongs.
 */
public class ProductClient {

	public static void main(String[] args) {
	
		Product[] products = new Product[5]; // Array of 5 Pointers
        products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED");// upcasting
        products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
        products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
        products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
        products[4] = new Mobile(844, "Oppo", 9999.00, "4G");
        // We can keep on adding the new products. Open For Change.
        //print(products);
        printOCP(products);// Common among all the get method is "get".
        //checkExpensive(products);
	}
//Normally we execute method like t.getId() t - is a context or object"."method name which is known in advance.
//In this case we don't have method names in advance. Here we have array of methods (Methods[]).
private static void printOCP(Product[] products) {
	for (Product p : products) {// p is a pointer pointing to mobile, tv, washing machine etc.
		System.out.println("*********");
		Method[] methods = p.getClass().getMethods();// p.class gives Mobile if the products is of type Mobile.
		for (Method m : methods) {// "m" is a pointer to array of methods. Method[] is from reflection api.
			if (m.getName().startsWith("get")) {
				try {
					Object ret = m.invoke(p);
					System.out.println("invoke: " +ret);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
		// This is also invoke Object.getClass() method
	/*
*********
invoke: LED
invoke: Sony Bravia
invoke: 133
invoke: 135000.0
invoke: class parjun8840.product.entity.Tv
*********
invoke: 4G
invoke: MotoG
invoke: 453
invoke: 12999.0
invoke: class parjun8840.product.entity.Mobile
*********
	 */
	
	}

//Organize import- command + shift + o. OCP- Open for Change Principle
//checkExpensive method is 100% OCP but we haven't implemented checkExpensive method so super class method is called.
//Bcz of upcasting we are able to achieve 100% OCP.
	private static void checkExpensive(Product[] products) {
		for (Product p :  products) {
			if(p.isExpensive()) {
				System.out.println(p.getName()+" is expensive!!");
			}
			else {
				System.out.println(p.getName()+ " is not expensive!!");
			}
		}
		
	}

	// The below function is not OCP, everytime a new Product comes we have to edit here as well.
	private static void print(Product[] products) {
     for(Product p : products) {
         System.out.println(p.getName() + ", " + p.getPrice());
          if(p instanceof Mobile) {
              Mobile m = (Mobile) p; // downcasting
              System.out.println(m.getConnectivity());
          } else if (p.getClass().equals(Tv.class)) {
              Tv t = (Tv) p;
              System.out.println(t.getScreen());
          }
     }
 }
	
	

}


//instance of is use to check family of.
//getClass is precise checking.