
public class Product {
	
	 public int id;
	 private String productName;
	 private  double price;
	 private  int quantity;
	 //We used an additional attribute to our Product constructor so we could easily calculate total price in transaction management class
	 Product(int id, String productName, double price, int quantity){
		 this.id = id;
		 this.productName = productName;
		 this.price = price;
		 this.quantity=quantity;
		 
	 }
	 
	  public String toString(){
			
	        return "Product id is: " +id+" | Product name is: "+productName+" | Price is: "+price+ " | Quantity is: "+quantity;
	    }
	  public void add() {
		  
	  }
	  public double getPrice() {
		  return price;
	  }
	  
	  public void setPrice(double price) {
		  this.price= price;
	  }
	  
	  public double getQuantity() {
		  return quantity;
	  }
	  
	  
	  public String getProductName() {
		  return productName;
	  }
	  
	  public boolean equals(Product other) {
		  return toString().equals(other.toString());
	  }
	  
	
}
