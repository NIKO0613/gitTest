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
		System.out.println("������"+Sta_name+"\t"+"ְλ��Ա��"+"\t"+"���ʣ�"+Sta_salary);
	}
	public void birthday(int time) {
		if(time==(int)Sta_birthday) 
			System.out.println("ף��"+Sta_name+"���տ��֣�����");
		}
}

