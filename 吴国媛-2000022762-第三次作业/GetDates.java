import java.util.Date;
public class GetDates {
    public static void main(String[] args) {
    	Date date=new Date(0);  //����Date����date
    	long time=10000;  //����long���ͱ���time�Դ��治ͬ������ʱ��
    	for(int i=0;i<8;i++) {  //������Ŀ��������ʱ���Ϊ10�ı��������ʹ��ѭ���������
    		date.setTime(time);  //����Date���setTime���������ݵ�ǰtime��ֵ�õ���ǰ����
    		System.out.println(time+":"+date.toString());  //��time�Լ���Ӧ�������������Ļ��
    		time*=10;  //������һ������ʱ��
    	}
    }
}
