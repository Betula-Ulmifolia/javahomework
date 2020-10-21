import java.util.Scanner;

public class SumMajorDiagonal {
    public static double sumMajorDiagonal(double[][] m) {
    	double sum=0;
    	for(int i=0;i<4;i++) {
    		sum+=m[i][i];
    	}
    	return sum;
    }
    public static void main(String[] args) {
    	double[][] m=new double[4][4];
    	System.out.println("请输入一个4*4的矩阵：");
    	Scanner input=new Scanner(System.in);
    	for(int row=0;row<4;row++) {
    		for(int column=0;column<4;column++) {
    			m[row][column]=input.nextDouble();
    		}
    	}
    	double sum=sumMajorDiagonal(m);
    	System.out.println("该矩阵主对角线上所有元素的和为："+sum);
    }
}
