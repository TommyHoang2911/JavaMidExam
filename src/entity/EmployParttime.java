package entity;

public class EmployParttime {

	private int    id;
	private String name;
	private String numberPhone;
	private String address;
	private double salary;
	private int    timeHours;
	
	public EmployParttime(){}
	
	public EmployParttime(
			int id, 
			String name, 
			String numberPhone, 
			String address, int 
			timeHours){
		this.id = id;
		this.name = name;
		this.numberPhone = numberPhone;
		this.address = address;
		this.timeHours = timeHours;
	}
	
	public void setId(int id) 				  { this.id = id; }
	public void setName(String name) 		  { this.name = name; }	
	public void setNumberPhone(String phone)  { this.numberPhone = phone; }	
	public void setAddress(String address) 	  { this.address = address; }
	public void setTimeHours(int timeHours)   { this.timeHours = timeHours; }
	public void setSalary(){ 
		this.salary = timeHours * 120000.0; 
	}
	
	public int    getId()        { return id; }
	public String getName()      { return name; }
	public String getPhone()     { return numberPhone; }
	public String getAddress()   { return address; }
	public int    getTimeHours() { return timeHours; }
	
	public double getSalary(){ 
		return salary; 
	}	
}
