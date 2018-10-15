package company_test;

public class staff {
	String Sta_name;
	double Sta_salary;
	double Sta_birthday;
	staff(String name,double salary,double birthday){
		Sta_name=name;
		Sta_salary=salary;
		Sta_birthday=birthday;
	}
	public void payoff() {
		System.out.println("姓名："+Sta_name+"\t"+"职位：员工"+"\t"+"工资："+Sta_salary);
	}
	public void birthday(int time) {
		if(time==(int)Sta_birthday) 
			System.out.println("祝贺"+Sta_name+"生日快乐！！！");
		}
}

