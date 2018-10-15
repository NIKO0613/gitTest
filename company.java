package company_test;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.*;

public class company {
	public static double Com_sum;
	public static double Com_sum_profit;
	//����Ա���������ɶ����������б����ڴ�ų�Ա������Ϣ
	public static ArrayList<staff>staff_list=new ArrayList<staff>();
	public static ArrayList<manager>manager_list=new ArrayList<manager>();
	public static ArrayList<shareholder>shareholder_list=new ArrayList<shareholder>();
	company(){
		Com_sum=1000000.0;
		//��ʼ����Ա������Ϣ
		 staff_list.add(new staff("����",4000,10.12));
		 staff_list.add(new staff("����",4500,3.24));
		 staff_list.add(new staff("����",4500,4.16));
		 staff_list.add(new staff("����",5000,2.17));
		 staff_list.add(new staff("����",5000,6.23));
		 staff_list.add(new staff("����",6000,5.28));
		 manager_list.add(new manager("��ѧ־",10000,10.24,1000));
		 manager_list.add(new manager("Ԭ��",10000,7.16,2000));
		 shareholder_list.add(new shareholder("����",0.4));
		 shareholder_list.add(new shareholder("����",0.4));
		
	}
	public static void main(String args[])throws IOException {
		//����һ����˾��������company���캯����ʵ��
		company A=new company();
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		int month=Time()+1;//�ӵ����ϻ�ȡ�����·�
		System.out.println("������������������ӭʹ�÷ַ�����ϵͳ����������������");
		System.out.println("���������������");
		String name=keyin.readLine();//��ȡ��Ա����
		System.out.println("������ѡ�����ְλ��");
		System.out.println("1.�ɶ�"+"\n"+"2.����"+"\n"+"3.Ա��");
		int job=System.in.read()-48;//��ȡ��˾Ա��ְλ
		if(job==1) {
			for(int i=0;i<2;i++) {		
				//if�������ж��ַ��������equals������ʵ��
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
			//�������ʱ����������ʾ
			System.out.println("��������ֻ���ѡ�����ݴ��󣡣�������");
		}
		//����txt�������ڽ���Ϣд���ı��ļ���\r\n���У�\r\t���һ��table��
		StringBuffer txt=new StringBuffer();
		txt.append("�ɶ���\r\n");
		for(int i=0;i<2;i++) {
			txt.append("������"+shareholder_list.get(i).Sha_name+"\t"+"ְλ���ɶ�"+"\t"+"�ɷݣ�"+shareholder_list.get(i).Sha_stock+"\r\n");
		}
		txt.append("\r\n����\r\n");
		for(int i=0;i<2;i++) {
			txt.append("������"+manager_list.get(i).Man_name+"\t"+"���գ�"+manager_list.get(i).Man_birthday+"\t"+"ְλ������"+"\t"+"���ʣ�"+manager_list.get(i).Man_salary+"\t"+"����"+manager_list.get(i).premium+"\r\n");
		}
		txt.append("\r\nԱ����\r\n");
		for(int i=0;i<6;i++) {
			txt.append("������"+staff_list.get(i).Sta_name+"\t"+"���գ�"+staff_list.get(i).Sta_birthday+"\t"+"ְλ��Ա��"+"\t"+"���ʣ�"+staff_list.get(i).Sta_salary+"\r\n");
		}
		try {
			//�����ݴ����e�̵�test.txt�ļ���
			FileWriter fw=new FileWriter("e:/test.txt");
			fw.write(txt.toString());
			//�ر��ļ�д�빦��
			fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}

		
	}		
//��ȡ���Ա���ʱ���е��·�
	public static int Time() {
		Calendar c=Calendar.getInstance();
		int month=c.get(Calendar.MONTH);
		return month;
	}
//��ȡ��˾��Ա������֧������
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

