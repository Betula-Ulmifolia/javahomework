import java.util.Scanner;
public class IndexOfSmallestElement {
    public static int indexOfSmallestElement(double[] array) {
    	int index=0;
    	for(int i=1;i<10;i++) {
    		if(array[i]<array[index]) {
    			index=i;
    		}
    	}
    	return index;
    }
    public static void main(String[] args) {
    	System.out.println("������10�����֣�");
    	double[] array=new double[10];
    	Scanner input=new Scanner(System.in);
    	for(int i=0;i<10;i++) {
    		array[i]=input.nextDouble();
    	}
    	int index=indexOfSmallestElement(array);
    	System.out.println("��"+(index+1)+"��Ԫ����С�����±�ֵΪ"+index);
    }
}
