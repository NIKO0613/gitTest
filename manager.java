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
		premium=pre;//����
	}
	public void payoff() {
		double salary=Man_salary+premium;
		System.out.println("������"+Man_name+"\t"+"ְλ������"+"\t"+"���ʣ�"+Man_salary+"\t"+"����"+premium+"\t"+"���ʺϼƣ�"+salary);
	}
	public void self_birthday(int time) {
		//if������棨Man_birthday+0.5���Ƕ�Man_birthdayȡ��
		if(time==(int)Man_birthday){
			System.out.println("ף��"+Man_name+"���տ��֣�");
		}
		
	}

}
