package entity;

public class EmployFulltime {
	
	private int    id;
	private String name;
	private String numberPhone;
	private String address;
	private double salary;
	private int    numberWorkDay;
	
    public EmployFulltime(){}
	
	public EmployFulltime(
			int id, 
			String name, 
			String numberPhone, 
			String address, int 
			numberWork){
		this.id = id;
		this.name = name;
		this.numberPhone = numberPhone;
		this.address = address;
		this.numberWorkDay = numberWork;
	}
	
	public void setId(int id) 				          { this.id = id; }
	public void setName(String name) 		          { this.name = name; }	
	public void setNumberPhone(String phone)          { this.numberPhone = phone; }	
	public void setAddress(String address) 	          { this.address = address; }
	public void setNumberWorkDay(int numberWorkDay)   { this.numberWorkDay = numberWorkDay; }
	public void setSalary(){ 
		this.salary = numberWorkDay * 1500000.0; 
	}
	
	public int    getId()            { return id; }
	public String getName()          { return name; }
	public String getPhone()         { return numberPhone; }
	public String getAddress()       { return address; }
	public int    getNumberWorkDay() { return numberWorkDay; }
	
	public double getSalary(){ 
		return salary; 
	}
}
