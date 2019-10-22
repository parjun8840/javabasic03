package parjun8840.product.entity;

public class Tv extends Product {
	private String screen;

	public Tv() {
	}

	public Tv(int id, String name, double price, String screen) {
		super(id, name, price);
		this.screen = screen;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	@Override
	public boolean isExpensive() {
		if ("CRT".equals(screen) && getPrice() > 5000 ) {
			return true;
		}

		else if("LED".equals(screen) && getPrice() > 15000 ) {
			return true;
		}
		return false;
	}
	
	

}
