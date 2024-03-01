
public class Query {
	ShopAssistant[] shopAssistant;
	Transaction[][]	transaction;
	Query(ShopAssistant[] shopAssistant,Transaction[][] transaction){
		this.shopAssistant=shopAssistant;
		this.transaction=transaction;
		mostExpensiveProductInTheLowestPriceTransaction();
		highestTotalPrice();
		lowestTransactionFee();
		highestSalaryShopAssistant();
		totalRevenue();
		totalProfit();
	}
	public void displayer() {
		 System.out.println("1) The highest total price transaction is: "+highestTotalPrice()+"\n");
		 System.out.println("2) The most expensive product in the lowest price transaction is: "+mostExpensiveProductInTheLowestPriceTransaction()+"\n");
		
		 System.out.println("3) The lowest transaction fee is: "+String.format("%.2f",lowestTransactionFee())+"\n");
		 System.out.println(highestSalaryShopAssistant()+"\n");
		 System.out.println(totalRevenue()+"\n");
		 System.out.println(totalProfit());
	}
	public String mostExpensiveProductInTheLowestPriceTransaction(){
		int firstIndex=0;
		int secondIndex=0;
	
		int indexOfTheMostExpensiveProduct = 0;
		double min = transaction[0][0].getTotalPrice();
        for (int i=0 ;i<shopAssistant.length;i++) {
	    	for (int z=0;z<transaction[1].length;z++) {
	    		 
	    	if (transaction[i][z].getTotalPrice() < min) {
	    	    firstIndex = i;
	    	    firstIndex = z;
	    	    
	        }else {}
	             
	    }

	} double max = transaction[firstIndex][secondIndex].products[0].getPrice() ;
			 for (int f=1; f<transaction[firstIndex][secondIndex].products.length; f++) {
				if (transaction[firstIndex][secondIndex].products[f].getPrice() > max) {
					
					max = transaction[firstIndex][secondIndex].products[f].getPrice(); 
					indexOfTheMostExpensiveProduct = f;
						
				}
				else {}
			 }
	  return transaction[firstIndex][secondIndex].products[indexOfTheMostExpensiveProduct].getProductName();	
}

	public String highestTotalPrice(){
       double max = transaction[0][0].getTotalPrice();
       String trs="";
       	for (int i=0 ;i<shopAssistant.length;i++) {
	    	for (int z=0;z<transaction[1].length;z++) {
	    		
	    	if (transaction[i][z].getTotalPrice() > max) {
	    	        max = transaction[i][z].getTotalPrice();
	    	        trs=transaction[i][z].toString();
	    	} 
	    	else{}
	    
	    }
	}return trs.toString();}
	    	
		
	public double lowestTransactionFee(){
		double lowestFee=transaction[0][0].getTransactionFee();
		for(int i =0;i<shopAssistant.length;i++) {
			for(int j =0;j<transaction[1].length;j++) {
				if(lowestFee>transaction[i][j].getTransactionFee()) {
					lowestFee=transaction[i][j].getTransactionFee();
					
				}else {}
				}
		}
		return lowestFee;
	}
	public String highestSalaryShopAssistant(){
		double maxSalary=shopAssistant[0].getTotalSalary();
		int asistantId=0;
		for(int j=0 ;j <shopAssistant.length;j++){
			if(maxSalary<shopAssistant[j].getTotalSalary()) {
				asistantId=j;
				
			}
			else {}
			}
			return "4) " + shopAssistant[asistantId].toString() + " Weekly Salary is : " + shopAssistant[asistantId].weeklySalary();            
			
			
		}
	
	public double totalRevenueValue(){
		double totalRevenueValue = 0;
	
		for (int i=0;i<shopAssistant.length;i++) {
			for (int j=0;j<transaction[1].length;j++) {
				totalRevenueValue+= (transaction[i][j].getTotalPrice()+transaction[i][j].getTransactionFee());
			}
		}
		
	return totalRevenueValue;
	}
	
	public String totalRevenue(){
		double totalRevenueValue = 0;
	
		for (int i=0;i<shopAssistant.length;i++) {
			for (int j=0;j<transaction[1].length;j++) {
				totalRevenueValue+= (transaction[i][j].getTotalPrice()+transaction[i][j].getTransactionFee());
			}
		}
		
	return "5) The total revenue that is earned from 1500 transactions: "+ String.format("%.2f",totalRevenueValue)   ;
	}
	
	public String totalProfit(){
		 double realTotalSalary = 0;
		for(int i =0;i<shopAssistant.length;i++) {
			realTotalSalary += shopAssistant[i].getTotalSalary();
			
			
		}
		double totalProfit = totalRevenueValue()-realTotalSalary;
		
	return 		"6) The total profit that is earned after paying the shop assistant salaries is "+String.format("%.2f", totalProfit);
	}
}
