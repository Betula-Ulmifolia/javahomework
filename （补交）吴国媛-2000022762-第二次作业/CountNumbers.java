import java.lang.Math;
public class CountNumbers {
    public static int[] countNumbers(int[] numbers) {
    	int[] counts=new int[10];
    	for(int i=0;i<100;i++) {
    		switch(numbers[i]) {
    		case 0:counts[0]+=1;
    		       break;
    		case 1:counts[1]+=1;
		           break;
    		case 2:counts[2]+=1;
    		       break;
    		case 3:counts[3]+=1;
    		       break;
    		case 4:counts[4]+=1;
    		       break;
    		case 5:counts[5]+=1;
    		       break;
    		case 6:counts[6]+=1;
    		       break;
    		case 7:counts[7]+=1;
    		       break;
    		case 8:counts[8]+=1;
    		       break;
    		case 9:counts[9]+=1;
    		       break;
    		}
    	}
    	return counts;
    }
    public static void main(String[] args) {
    	int[] numbers=new int[100];
    	for(int i=0;i<100;i++) {
    		numbers[i]=(int)(Math.random()*10);
    	}
    	System.out.println("随机生成的100个整数如下：");
    	for(int j=0;j<100;j++) 
            System.out.print(numbers[j]+" ");
    	System.out.print('\n');
    	int[] counts=countNumbers(numbers);
    	System.out.println("数字0到9分别出现的次数为：");
    	for(int k=0;k<10;k++) {
    		System.out.print(counts[k]+" ");
    	}
    }
}
