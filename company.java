package company_test;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.*;

public class company {
	public static double Com_sum;
	public static double Com_sum_profit;
	//定义员工，经理，股东三个数据列表用于存放成员基本信息
	public static ArrayList<staff>staff_list=new ArrayList<staff>();
	public static ArrayList<manager>manager_list=new ArrayList<manager>();
	public static ArrayList<shareholder>shareholder_list=new ArrayList<shareholder>();
	company(){
		Com_sum=1000000.0;
		//初始化成员基本信息
		 staff_list.add(new staff("张三",4000,10.12));
		 staff_list.add(new staff("李四",4500,3.24));
		 staff_list.add(new staff("王五",4500,4.16));
		 staff_list.add(new staff("赵六",5000,2.17));
		 staff_list.add(new staff("孙七",5000,6.23));
		 staff_list.add(new staff("黑土",6000,5.28));
		 manager_list.add(new manager("田学志",10000,10.24,1000));
		 manager_list.add(new manager("袁孟",10000,7.16,2000));
		 shareholder_list.add(new shareholder("鸣人",0.4));
		 shareholder_list.add(new shareholder("佐助",0.4));
		
	}
	public static void main(String args[])throws IOException {
		//定义一个公司类型用于company构造函数的实现
		company A=new company();
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		int month=Time()+1;//从电脑上获取当月月份
		System.out.println("————————欢迎使用分发工资系统————————");
		System.out.println("请输入你的姓名：");
		String name=keyin.readLine();//获取成员姓名
		System.out.println("请输入选择你的职位：");
		System.out.println("1.股东"+"\n"+"2.经理"+"\n"+"3.员工");
		int job=System.in.read()-48;//获取公司员工职位
		if(job==1) {
			for(int i=0;i<2;i++) {		
				//if条件里判断字符串相等用equals函数来实现
				if(month==12&&shareholder_list.get(i).Sha_name.equals(name)) {					
					shareholder a = new shareholder(shareholder_list.get(i).Sha_name,shareholder_list.get(i).Sha_stock);;
					a.getsum_profit(Com_sum-SumPayOff());
					a.payoff();
				}
			}			
		}
		else if(job==2) {
			for(int i=0;i<2;i++) {
				if(manager_list.get(i).Man_name.equals(name)) {
					manager a=new manager(manager_list.get(i).Man_name,manager_list.get(i).Man_salary,manager_list.get(i).Man_birthday,manager_list.get(i).premium);				
					a.payoff();
					a.self_birthday(month);					
				}
			}
		}
		else if(job==3){
			for(int i=0;i<6;i++)
			{
				if(staff_list.get(i).Sta_name.equals(name)) { 
					staff a=new staff(staff_list.get(i).Sta_name,staff_list.get(i).Sta_salary,staff_list.get(i).Sta_birthday);
					a.payoff();
					a.birthday(month);
				}
			}
		}
		else {
			//输入错误时做出错误提示
			System.out.println("输入的名字或者选择的身份错误！！！！！");
		}
		//定义txt参数用于将信息写入文本文件，\r\n换行，\r\t相隔一个table键
		StringBuffer txt=new StringBuffer();
		txt.append("股东：\r\n");
		for(int i=0;i<2;i++) {
			txt.append("姓名："+shareholder_list.get(i).Sha_name+"\t"+"职位：股东"+"\t"+"股份："+shareholder_list.get(i).Sha_stock+"\r\n");
		}
		txt.append("\r\n经理：\r\n");
		for(int i=0;i<2;i++) {
			txt.append("姓名："+manager_list.get(i).Man_name+"\t"+"生日："+manager_list.get(i).Man_birthday+"\t"+"职位：经理"+"\t"+"工资："+manager_list.get(i).Man_salary+"\t"+"奖金："+manager_list.get(i).premium+"\r\n");
		}
		txt.append("\r\n员工：\r\n");
		for(int i=0;i<6;i++) {
			txt.append("姓名："+staff_list.get(i).Sta_name+"\t"+"生日："+staff_list.get(i).Sta_birthday+"\t"+"职位：员工"+"\t"+"工资："+staff_list.get(i).Sta_salary+"\r\n");
		}
		try {
			//将数据存放在e盘的test.txt文件中
			FileWriter fw=new FileWriter("e:/test.txt");
			fw.write(txt.toString());
			//关闭文件写入功能
			fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}

		
	}		
//获取电脑本地时间中的月份
	public static int Time() {
		Calendar c=Calendar.getInstance();
		int month=c.get(Calendar.MONTH);
		return month;
	}
//获取公司总员工工资支出费用
	public static double SumPayOff() {
		double StaffSumPayOff=0;
		double ManagerSumPayOff=0;
		for(int i=0;i<6;i++) {			
			StaffSumPayOff+=staff_list.get(i).Sta_salary;
		}
		for(int i=0;i<2;i++) {
			ManagerSumPayOff+=manager_list.get(i).Man_salary;
		}
		return StaffSumPayOff+ManagerSumPayOff;
	}
}

