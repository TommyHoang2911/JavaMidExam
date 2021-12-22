package utils;

import java.util.List;

import entity.EmployFulltime;
import entity.EmployParttime;

public class CompanyUtil {
	
	private ParttimeUtil parttimeUtil;
	private FulltimeUtil fulltimeUtil;
	
	public CompanyUtil(ParttimeUtil parttimeUtil, FulltimeUtil fulltimeUtil) {
		this.fulltimeUtil = fulltimeUtil;
		this.parttimeUtil = parttimeUtil;
	}
	
	public void caculateSalaryAllStaff() {
		double salary = 0;
		List<EmployFulltime> listFulltime = fulltimeUtil.getListFulltime();
		List<EmployParttime> listParttime = parttimeUtil.getListParttime();
		for (int i = 0; i < listFulltime.size(); i++) {
			salary += listFulltime.get(i).getSalary();
		}
		for (int i = 0; i < listParttime.size(); i++) {
			salary += listParttime.get(i).getSalary();
		}
		System.out.println("Tong so tien cong ty tra luong cho nhan vien : "+salary+"vnd");
	}
	
	public void searchStaff(FilterSearch filterSearch,String name,int id) {
		switch (filterSearch) {
		case FULLTIME: {
			fulltimeUtil.searchFulltime(id, name);
			break;
		}
		case PARTTIME: {
			parttimeUtil.searchParttime(id, name);
			break;
		}
		default:
			fulltimeUtil.searchFulltime(id, name);
			parttimeUtil.searchParttime(id, name);
		}
	}
}
