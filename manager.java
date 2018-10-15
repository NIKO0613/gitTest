package company_test;
public class manager {
	String Man_name;
	double Man_salary;
	double Man_birthday;
	int premium;
	manager(String name,double salary,double birthday,int pre){
		Man_name=name;
		Man_salary=salary;
		Man_birthday=birthday;
		premium=pre;//奖金
	}
	public void payoff() {
		double salary=Man_salary+premium;
		System.out.println("姓名："+Man_name+"\t"+"职位：经理"+"\t"+"工资："+Man_salary+"\t"+"奖金："+premium+"\t"+"工资合计："+salary);
	}
	public void self_birthday(int time) {
		//if语句里面（Man_birthday+0.5）是对Man_birthday取整
		if(time==(int)Man_birthday){
			System.out.println("祝贺"+Man_name+"生日快乐！");
		}
		
	}

}
