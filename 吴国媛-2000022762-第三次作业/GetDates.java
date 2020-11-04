import java.util.Date;
public class GetDates {
    public static void main(String[] args) {
    	Date date=new Date(0);  //创建Date对象date
    	long time=10000;  //定义long类型变量time以储存不同的流逝时间
    	for(int i=0;i<8;i++) {  //由于题目所给流逝时间均为10的倍数，因此使用循环依次输出
    		date.setTime(time);  //调用Date类的setTime函数，根据当前time的值得到当前日期
    		System.out.println(time+":"+date.toString());  //将time以及对应的日期输出到屏幕上
    		time*=10;  //计算下一个流逝时间
    	}
    }
}
