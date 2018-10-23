package vehicle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
abstract public class Tools {
	public String transname;
	public static double reachTime;//在出发地的时间
	public static double returnTime;//到达目的地的时间
	public static double reachDistance;//存放出发地到零点O的距离
	public static double returnDistance;//存放目的地到零点O的距离
	public static double getTicketsTime;//取票时间
	public static double securitycheckTime;//安检时间
	public static double waitCarTime;//候车时间
	public static double speed;//交通工具的速度
	public static double price;//交通工具价格
	//public double sumTime;
	public static double sumPrice;
	abstract public void toTimeandmoney();
	Tools(){
		Random rantime=new Random();
		waitCarTime=rantime.nextInt(10)+5;
		securitycheckTime=rantime.nextDouble()+1;
		getTicketsTime=rantime.nextDouble()+3;
	}
//	Tools(double reachtime,double sumprice,double returntime){
//		reachTime=reachtime;
//		sumPrice=sumprice;
//		returnTime=returntime;
//	}
	public static class car extends Tools{
		Tools cartool;
		car(double reachtime,double reachdistance,double returndistance){
			cartool.speed=30;
			cartool.price=0.32;;
			cartool.reachTime=reachtime;
			cartool.reachDistance=reachdistance;
			cartool.returnDistance=returndistance;			
		}
		@Override
		public void toTimeandmoney() {
			// TODO Auto-generated method stub
			double distance=cartool.returnDistance-cartool.reachDistance;
			cartool.returnTime=cartool.reachTime+cartool.waitCarTime+distance/cartool.speed;
			cartool.sumPrice=distance*price;
		}
		public void print() {
			toTimeandmoney();
			int hour=(int)cartool.reachTime;
			int minute=(int)((cartool.reachTime-hour)*60);
			int hour2=(int)cartool.returnTime;
			int minute2=(int)((cartool.returnTime-hour2)*60);
			System.out.printf("出发时间：%d:%d\t价格：%.2f\t到站时间：%d:%d", hour,minute,Math.abs(cartool.sumPrice),hour2,minute2);
		};		
	}
	public static class highspeed extends Tools{
		Tools hstool;
		highspeed(double reachtime,double reachdistance,double returndistance){
			hstool.speed=60;
			hstool.price=0.45;;
			hstool.reachTime=reachtime;
			hstool.reachDistance=reachdistance;
			hstool.returnDistance=returndistance;
		}
		@Override
		public void toTimeandmoney() {
			// TODO Auto-generated method stub
			double distance=hstool.returnDistance-hstool.reachDistance;
			hstool.returnTime=hstool.reachTime+hstool.securitycheckTime+hstool.getTicketsTime+hstool.waitCarTime+distance/hstool.speed;
			hstool.sumPrice=distance*price;
		}
		public void print() {
			toTimeandmoney();
			int hour=(int)hstool.reachTime;
			int minute=(int)((hstool.reachTime-hour)*60);
			int hour2=(int)hstool.returnTime;
			int minute2=(int)((hstool.returnTime-hour2)*60);
			System.out.printf("出发时间：%d:%d\t价格：%.2f\t到站时间：%d:%d", hour,minute,Math.abs(hstool.sumPrice),hour2,minute2);
		};	
		
	}
	public static class plane extends Tools{
		Tools pltool;
		plane(double reachtime,double reachdistance,double returndistance){
			pltool.speed=60;
			pltool.price=0.45;;
			pltool.reachTime=reachtime;
			pltool.reachDistance=reachdistance;
			pltool.returnDistance=returndistance;
		}
		@Override
		public void toTimeandmoney() {
			// TODO Auto-generated method stub
			double distance=pltool.returnDistance-pltool.reachDistance;
			pltool.returnTime=pltool.reachTime+pltool.securitycheckTime+pltool.getTicketsTime+pltool.waitCarTime+distance/pltool.speed;
			pltool.sumPrice=distance*price;
		}
		public void print() {
			toTimeandmoney();
			int hour=(int)pltool.reachTime;
			int minute=(int)((pltool.reachTime-hour)*60);
			int hour2=(int)pltool.returnTime;
			int minute2=(int)((pltool.returnTime-hour2)*60);
			System.out.printf("出发时间：%d:%d\t价格：%.2f\t到站时间：%d:%d", hour,minute,Math.abs(pltool.sumPrice),hour2,minute2);
		};	
		
	}
	public static class distance{
		public String routeName;
		public double routeDistance;
		public ArrayList<distance>route=new ArrayList<>();
		distance(){
			route.add(new distance("湖北",3.4));
			route.add(new distance("杭州",6.5));
		}
		distance(String name,double distance){
			routeName=name;
			routeDistance=distance;
		}

	}
	public static void main(String args[]) {
		distance menu =new distance();
		Scanner num=new Scanner(System.in);
		System.out.println("请选择交通工具："+"\n"+"1.汽车"+"\t"+"2.高铁"+"\t"+"3.飞机");
		int tools=num.nextInt();
		//int tools=1;
		if(tools!=1&&tools!=2&&tools!=3) {
			System.out.println("选择出行方式错误!!!");
			return;
		}
		System.out.println("请输入出发时间：");
		double reachtime=num.nextDouble(); 
		Scanner name=new Scanner(System.in);
		System.out.println("请输入出发地：");
		String reachname=name.nextLine();
		//String reachname="湖北";
		System.out.println("请输入目的地：");
		String returnname=name.nextLine();
		//String returnname="杭州";
		double reachdistance=0,returndistance = 0;
		for(int i=0;i<2;i++) {
			if(menu.route.get(i).routeName.equals(reachname)) {
				reachdistance=menu.route.get(i).routeDistance;
			}
		}
		for(int i=0;i<2;i++) {
			if(menu.route.get(i).routeName.equals(returnname)) {
				returndistance=menu.route.get(i).routeDistance;
			}
		}
		if(reachdistance==0||returndistance == 0) {
			System.out.println("输入出发地或者目的地错误！！！");
			return;
		}
		if(tools==1) {
			car ccar=new car(reachtime,reachdistance,returndistance);
			ccar.print();
		}
		else if(tools==2) {
			highspeed speed=new highspeed(reachtime,reachdistance,returndistance);
			speed.print();
		}
		else if(tools==3) {
			plane pltool=new plane(reachtime,reachdistance,returndistance);
			pltool.print();	
		}
}
}
