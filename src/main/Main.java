package main;

import java.util.Scanner;

import utils.CompanyUtil;
import utils.FilterSearch;
import utils.FulltimeUtil;
import utils.ParttimeUtil;

public class Main {
	
	private static ParttimeUtil parttimeUtil;
	private static FulltimeUtil fulltimeUtil;
	private static CompanyUtil  companyUtil;
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		parttimeUtil = new ParttimeUtil();
		fulltimeUtil = new FulltimeUtil();
		companyUtil  = new CompanyUtil(parttimeUtil, fulltimeUtil);
		
		System.out.println("Nhap so luong nhan vien part-time can nhap :");
		int numberInput = scanner.nextInt();
		
		parttimeUtil.addListParttime(numberInput);
		parttimeUtil.printListParttime();
		
		System.out.println("Nhap so luong nhan vien full-time can nhap :");
		numberInput = scanner.nextInt();
		
		fulltimeUtil.addListFulltime(numberInput);
		fulltimeUtil.printListFulltime();
		
		companyUtil.caculateSalaryAllStaff();
		
		searchStaff();
		sortAlphabet();
	}
	
	private static void searchStaff() {
		int id; 
		String name;
		System.out.println("-----Search-----");
		System.out.print("Nhap id can tim : ");
		id = scanner.nextInt();
		System.out.println("Nhap ten nhan vien can tim : ");
		name = scanner.next();
		companyUtil.searchStaff(FilterSearch.FULLTIME, name.toLowerCase(), id);
	}
	
	private static void sortAlphabet() {
		parttimeUtil.sortAlphabetPartime();
		fulltimeUtil.sortAlphabetFulltime();
	}
}
