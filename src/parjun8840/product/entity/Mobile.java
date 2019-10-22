package parjun8840.product.entity;

public class Mobile extends Product {
	private String connectivity;

	public Mobile() {
	}

	public Mobile(int id, String name, double price, String connectivity) {
		super(id, name, price);// As the members of Product class are private we can't initialize them from here.
		this.connectivity = connectivity;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	@Override
	public boolean isExpensive() {
		if ("3g".equals(connectivity) && getPrice() > 5000) { // literal.euals(variable) is best practice.
       	 return true;// If we haven't set connectivity, then by default it is null. Else we have to define condition.
        }
        else if("4g".equals(connectivity) && getPrice() > 15000) {
       	 return true;
        }
        return false;
	}

}
/*
class Product{
public String getName() {
		return A;
	}
}

class Mobile extends Product{
public String getName() { // Method Over riding. Dynamic binding happens only in case of over riding.
		return M;
	}
}


Product p = new Mobile(); // upcasting, referring mobile as a product. You won't get features of the sub class.
p.getName(); // Dynamic binding RHS decides which code gets executed. The value is "M".
*/