import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class SortNumbers{
	//����sort������ArrayList�е�Ԫ�ؽ������򣨴˴�Ϊ����
	public static void sort(ArrayList<Number> list) {
		Number temp;
		//ʹ��ð�����򷨶����ֽ�������
		for(int i=0;i<list.size()-1;i++) {
			for(int j=0;j<list.size()-1;j++) {
				if(list.get(j).doubleValue()>list.get(j+1).doubleValue()) {  //��list��ĳ��Ԫ�ص�ֵ���ں�һ��Ԫ�أ������߽���
					temp=list.get(j);
					list.set(j,list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
	}
	
	//����
	public static void main(String[] args) {
		Integer[] num= {2,4,6,1,9,5,3,8,7};  //����Integer����num�Դ������������
		ArrayList<Number> list=new ArrayList<Number>(Arrays.asList(num));  //��numΪArrayList����list��ֵ
		System.out.println("����ǰ��listΪ��"+list);
		sort(list);  //��������
		System.out.println("������listΪ��"+list);
	}
}