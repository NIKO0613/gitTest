import java.util.ArrayList;
import java.util.UUID;
public class ArrayList_test {
	public static void main(String args[])
	{
		int sum_time=0;
		int max=1000;
		
		ArrayList<String>List=new ArrayList<String>();
		for(int i=0;i<max;i++)
		{
			String s;
			s=UUID.randomUUID().toString();
			List.add(s);	
		}
		for(int i=0;i<max;i++)
		{
			String s;
			s=List.get(i);
			long begin_Time = System.nanoTime();
			long end_Time = System.nanoTime();
			long time=(end_Time-begin_Time);
			sum_time+=time;
		}
		long average_time=sum_time/max;
		System.out.println("数组搜寻平均时间："+average_time+"ns");
		
	}

}
