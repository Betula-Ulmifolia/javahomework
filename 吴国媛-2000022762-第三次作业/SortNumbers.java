import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class SortNumbers{
	//定义sort函数对ArrayList中的元素进行排序（此处为升序）
	public static void sort(ArrayList<Number> list) {
		Number temp;
		//使用冒泡排序法对数字进行排序
		for(int i=0;i<list.size()-1;i++) {
			for(int j=0;j<list.size()-1;j++) {
				if(list.get(j).doubleValue()>list.get(j+1).doubleValue()) {  //若list中某个元素的值大于后一个元素，则将两者交换
					temp=list.get(j);
					list.set(j,list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
	}
	
	//测试
	public static void main(String[] args) {
		Integer[] num= {2,4,6,1,9,5,3,8,7};  //创建Integer数组num以储存待排序数字
		ArrayList<Number> list=new ArrayList<Number>(Arrays.asList(num));  //用num为ArrayList对象list赋值
		System.out.println("排序前的list为："+list);
		sort(list);  //进行排序
		System.out.println("排序后的list为："+list);
	}
}