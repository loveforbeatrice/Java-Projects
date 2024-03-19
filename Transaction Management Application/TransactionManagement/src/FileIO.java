import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


class FileIO {
    
    public static Product[] readProductData(String filename) {
         Product [] products = new Product [fileLineCounter(filename)] ;
     
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int i =0;
            int[] idNumber= new int[fileLineCounter(filename)];
            while ((line = br.readLine()) != null) { 
            	Random random = new Random();
                String[] data = line.split(";");
                int ID = Integer.parseInt(data[0]);
                idNumber[i]=ID;
                String productName = data[1];
                data[2]=data[2].replace(",",".");
                double price = Double.parseDouble(data[2]);
                int quantity=random.nextInt(10) + 1;
                Product product = new Product(ID, productName, price,quantity);
           
                products[i]=product;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
    
		 
    public static int fileLineCounter(String fileName) {
        int lineCounter = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while (bufferedReader.readLine() != null) {
            	lineCounter++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineCounter;
    }
		  
	
    public static int[] IdCounter(String filename) {
             int[] idNumber= new int[fileLineCounter(filename)];
      
       try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
           String line;
           int i =0;
      
           while ((line = br.readLine()) != null) {
               String[] data = line.split(";");
               int ID = Integer.parseInt(data[0]);
               idNumber[i]=ID;
               
               i++;
           }
       } catch (IOException e) {
           e.printStackTrace();
       }

       return idNumber;
   }
   
    public static ShopAssistant[] readShopAssistantData(String filename) {
        ShopAssistant[] assistants=new ShopAssistant[fileLineCounter(filename)];
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int i =0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                int ID = Integer.parseInt(data[0]);
                
                String name = data[1];
                String surname = data[2];
                data[3]=data[3].replace("-","");
                int phoneNumber = Integer.parseInt(data[3]);
                ShopAssistant assistant = new ShopAssistant(ID, name, surname, phoneNumber);
             
                assistants[i]=assistant;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return assistants;
    }
    	
}

