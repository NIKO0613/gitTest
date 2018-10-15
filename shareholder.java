package company_test;

public class shareholder {
	String Sha_name;
	double Sha_stock;
	double Sha_sum_profit;
	shareholder(String name,double stock){
		Sha_name=name;
		Sha_stock=stock;
	}
	public void getsum_profit(double profit) {
		Sha_sum_profit=profit; 
	}
	public void payoff() {
		System.out.println("姓名："+Sha_name+"\t"+"职位：股东"+"\t"+"工资："+Sha_sum_profit*Sha_stock);
	}
}
