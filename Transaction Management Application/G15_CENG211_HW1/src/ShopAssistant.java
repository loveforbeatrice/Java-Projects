import java.util.Random;
public class ShopAssistant {

 private int id;
 private String name;
 private String surname;
 private int phoneNumber;
 private double comission;
 private double totalSalary;

	ShopAssistant(int id, String name, String surname, int phoneNumber ){
		
		this.id = id;
		this.name = name; 
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		
		
		
	}
	

		
	
	public int seniority(){
		Random random = new Random();

        int seniority  = random.nextInt(16);
		
		return seniority;}  
	
	public double weeklySalary() {
		if(seniority()<=1) {
			return 1500;
		}
		else if(seniority()<=3) {
			return 2000;
		}
		else if(seniority()<=5) {
			return 2500;
		}else {return 3000;}
	}
	  public String toString(){
	
	        return "ShopAssistant id: " + id + ", name: "+ name + " " + surname + ", seniority: " + seniority() + ", commision: "+ String.format("%.2f",comission) + " ,total salary: "+ String.format("%.2f",totalSalary);
	  }
	  
	  public boolean equals(ShopAssistant other) {
		  return toString().equals(other.toString());
	  }
	  
	  public double getTotalSalary() {
		  return totalSalary;
	  }
	  
	  public void setTotalSalary(double totalSalarys) {
		  this.totalSalary= totalSalarys;
	  }
	  
	  public double getComission() {
		  return comission;
	  }
	  
	  public void setComission(double comission) {
		  this.comission= comission;
	  }
	  
	  public String getName() {
		  return name;
	  }
	  
	  
	  public int getId() {
		  return id;
	  }

	  public String getSurname() {
		  return name;
	  }	  
	  
}
