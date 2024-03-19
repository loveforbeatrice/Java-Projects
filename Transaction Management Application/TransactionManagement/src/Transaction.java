
public class Transaction {
	
	private int id;
	public Product[] products;
	private double totalPrice;
	private double transactionFee;
	
	Transaction(int id,Product[] products, double totalPrice, double transactionFee){
		this.id = id;
		this.products =  products;
		this.totalPrice = totalPrice;

		this.transactionFee = transactionFee;
		}
	
	

	public String toString(){
			
	        return "\n    Transaction id: "+id +"   total price: "+String.format("%.2f",totalPrice)+"   transaction fee: "+String.format("%.2f", transactionFee)+"\n"+ "    *product1: "+products[0].toString()+"\n"+ "    *product2: "+products[1].toString()+"\n"+"    *product3: "+products[0].toString();
	  }
	public boolean equals(Transaction other) {
		return toString().equals(other.toString());
	  }
	
	public double getTotalPrice() {
		  return totalPrice;
	  }
	  
	  public void setTotalPrice(double totalPrice) {
		  this.totalPrice= totalPrice;
	  }
	  
	  public double getTransactionFee() {
		  return transactionFee;
	  }
	  
	  public void setTransactionFee(double transactionFee) {
		  this.transactionFee= transactionFee;
	  }
	}


