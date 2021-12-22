package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entity.EmployParttime;

public class ParttimeUtil {
	
	private Scanner scanner = new Scanner(System.in);

	private List<EmployParttime> listParttime = new ArrayList<>();;
	
	public ParttimeUtil() {
	}
	
	private void addEmployParttime(EmployParttime employParttime) {
		listParttime.add(employParttime);
	}
	
	public void addListParttime(int numberStaff) {
		System.out.println("-----------PARTTIME STAFF--------");
		int nextId = listParttime.size();
		boolean isValidate=true;
		for(int i=0; i < numberStaff; i++) {
			nextId += 1;
			EmployParttime staff = new EmployParttime();
			staff.setId(nextId);
			
			while(isValidate) {
				System.out.println("--Staff "+nextId);
				System.out.println("Nhap ten           :");
				staff.setName(scanner.nextLine());
				System.out.println("Nhap so dien thoai :");
				staff.setNumberPhone(scanner.nextLine());
				System.out.println("Nhap dia chi       :");
				staff.setAddress(scanner.nextLine());
				System.out.println("Nhap so gio lam    :");
				staff.setTimeHours(Integer.parseInt(scanner.nextLine()));
				
				isValidate = checkValidate(staff);
			}
			staff.setSalary();
			isValidate = true;
			addEmployParttime(staff);
			
		}
	}
	
	private boolean checkValidate(EmployParttime staff) {
		if (staff.getName().isEmpty() || staff.getName().isBlank()) {
			System.out.println("** Ten khong hop le !");
			return true;
		}else if(staff.getPhone().isBlank()) {
			System.out.println("** So dien thoai khong hop le !");
			return true;
		}else if (staff.getAddress().isBlank()) {
			System.out.println("** Dia chi khong hop le !");
			return true;
		}else if (staff.getTimeHours() < 0) {
			System.out.println("** So gio lam khong hop le !");
			return true;
		}else {
			System.out.println("** Success **");
			return false;
		}
	}
	
	public void printListParttime() {
		for (int i = 0; i < listParttime.size(); i++) {
			printEmploy(i);
		}
	}

	private void printEmploy(int i) {
		System.out.println("----ID : "+listParttime.get(i).getId() +" ---");
		System.out.println(" Name: "+ listParttime.get(i).getName());
		System.out.println(" Phone: "+ listParttime.get(i).getPhone());
		System.out.println(" Address: "+ listParttime.get(i).getAddress());
		System.out.println(" Number work hours: "+ listParttime.get(i).getTimeHours() +" hours");
		System.out.println(" Salary: "+ listParttime.get(i).getSalary() +"vnd");
	}
	
	public void searchParttime(int id, String name) {
		boolean isSuccess = false;
		for(int i = 0; i < listParttime.size(); i++ ) {
			if ((listParttime.get(i).getId() == id) || listParttime.get(i).getName().toLowerCase().equals(name)) {
				System.out.println("Result staff id :"+i);
				printEmploy(i);
				isSuccess = true;
				if(id == i) { break; }
			}
		}
		if(!isSuccess) {
			System.out.println("Khong tim thay trong danh sach Part-time !");
		}
	}
	
	public void sortAlphabetPartime() {
		if (listParttime.size() > 0) {
			Collections.sort(listParttime, new Comparator<EmployParttime>() {
				@Override
				public int compare(final EmployParttime staff1, final EmployParttime staff2) {
					return staff1.getName().compareTo(staff2.getName());
				}
			});
		}
	}
	
	public List<EmployParttime> getListParttime(){
		return listParttime;
	}
}
