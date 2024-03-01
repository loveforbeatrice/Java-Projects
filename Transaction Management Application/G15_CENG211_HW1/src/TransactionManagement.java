import java.util.Random;

public class TransactionManagement {
	private ShopAssistant[] shopAssistantArray;
	private Product[] productArray;
	private int [] idNumber;
	private Transaction[][] transaction;
	public TransactionManagement(int[] idNumber,Product[] productArray,ShopAssistant[]shopassistant ){
	
		this.idNumber=idNumber;
			this.productArray=productArray;
			this.shopAssistantArray=shopassistant;
			
		}
		
		
		public Transaction[][] randomProductAssigner(int productNumber,int transactionNumber) {
			transaction= new Transaction[shopAssistantArray.length][transactionNumber];
			
			int transactionId=0;
			 
			for(int i=0 ;i<shopAssistantArray.length;i++) {
				 for(int z=0;z<transactionNumber;z++) {
					 Product[] selectedProduct=new Product[productNumber];
					 
					 int k =0;
					 	while(selectedProduct[productNumber-1]==null) {
					  Random random = new Random();
					 int randomIndex = random.nextInt(idNumber.length);
					 			for(int j=0; j<productArray.length;j++) {
					 				if(randomIndex==productArray[j].id) {
					 					selectedProduct[k]=productArray[j];
					 					k++;
					 					transactionId++;
					 				}else {}
					 				
					 				
					 		
				
				
				 }   	
					  }double totalPrice=0;
					 	for(int j =0; j<productNumber;j++) {
					 		totalPrice+=selectedProduct[j].getPrice()*selectedProduct[j].getQuantity() ;
							
					 		}
					  double fee;
					  if(totalPrice<=499) {
						  fee=totalPrice*0.01;
					  }else if(totalPrice<=799) {
						  fee=totalPrice*0.03;
					  }else if(totalPrice<=999) {
						  fee=totalPrice*0.05;
					  }else {fee=totalPrice*0.09;}
							  Transaction transactionInTwoDimantionalArray = new Transaction(transactionId,selectedProduct,totalPrice,fee);
					 				transaction[i][z]= transactionInTwoDimantionalArray;
					 		
				 }
				 
			}SalaryManagement a =new SalaryManagement(	shopAssistantArray,transaction);
			a.totalSalaryForAssistants(	shopAssistantArray,transaction);


		
		       
		return transaction;}
	
			 

		
}
		
		
		

