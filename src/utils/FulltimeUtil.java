package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import entity.EmployFulltime;
import entity.EmployParttime;

public class FulltimeUtil {
	
	private Scanner scanner = new Scanner(System.in);

	private List<EmployFulltime> listFulltime = new ArrayList<>();;
	
	public FulltimeUtil() {
	}
	
	private void addEmployParttime(EmployFulltime employFulltime) {
		listFulltime.add(employFulltime);
	}
	
	public void addListFulltime(int numberStaff) {
		System.out.println("-----------FULLTIME STAFF--------");
		int nextId = listFulltime.size();
		boolean isValidate=true;
		for(int i=0; i < numberStaff; i++) {
			nextId += 1;
			EmployFulltime staff = new EmployFulltime();
			staff.setId(nextId);
			
			while(isValidate) {
				System.out.println("--Staff "+nextId);
				System.out.println("Nhap ten           :");
				staff.setName(scanner.nextLine());
				System.out.println("Nhap so dien thoai :");
				staff.setNumberPhone(scanner.nextLine());
				System.out.println("Nhap dia chi       :");
				staff.setAddress(scanner.nextLine());
				System.out.println("Nhap so ngay lam    :");
				staff.setNumberWorkDay(Integer.parseInt(scanner.nextLine()));
				
				isValidate = checkValidate(staff);
			}
			staff.setSalary();
			isValidate = true;
			addEmployParttime(staff);
			
		}
	}
	
	private boolean checkValidate(EmployFulltime staff) {
		if (staff.getName().isEmpty() || staff.getName().isBlank()) {
			System.out.println("** Ten khong hop le !");
			return true;
		}else if(staff.getPhone().isBlank()) {
			System.out.println("** So dien thoai khong hop le !");
			return true;
		}else if (staff.getAddress().isBlank()) {
			System.out.println("** Dia chi khong hop le !");
			return true;
		}else if (staff.getNumberWorkDay() < 0) {
			System.out.println("** So ngay khong hop le !");
			return true;
		}else {
			System.out.println("** Success **");
			return false;
		}
	}
	
	public void printListFulltime() {
		for (int i = 0; i < listFulltime.size(); i++) {
			printEmploy(i);
		}
	}
	
	private void printEmploy(int i) {
		System.out.println("----ID : "+listFulltime.get(i).getId() +" ---");
		System.out.println(" Name: "+ listFulltime.get(i).getName());
		System.out.println(" Phone: "+ listFulltime.get(i).getPhone());
		System.out.println(" Address: "+ listFulltime.get(i).getAddress());
		System.out.println(" Number work days: "+ listFulltime.get(i).getNumberWorkDay() +" days");
		System.out.println(" Salary: "+ listFulltime.get(i).getSalary() +"vnd");
	}
	
	public void searchFulltime(int id, String name) {
		boolean isSuccess = false;
		for(int i = 0; i < listFulltime.size(); i++ ) {
			if ((listFulltime.get(i).getId() == id) || listFulltime.get(i).getName().toLowerCase().equals(name)) {
				System.out.println("Result staff id :"+i);
				printEmploy(i);
				isSuccess = true;
				if(id == i) { break; }
			}
		}
		if(!isSuccess) {
			System.out.println("Khong tim thay trong danh sach fulltime !");
		}
	}
	
	public void sortAlphabetFulltime() {
		if (listFulltime.size() > 0) {
			Collections.sort(listFulltime, new Comparator<EmployFulltime>() {
				@Override
				public int compare(final EmployFulltime staff1, final EmployFulltime staff2) {
					return staff1.getName().compareTo(staff2.getName());
				}
			});
		}
	}
	
	public List<EmployFulltime> getListFulltime(){
		return listFulltime;
	}
}
