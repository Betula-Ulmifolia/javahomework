import java.util.Random;
import java.util.Scanner;
public class PrintMatrix {
    public static void printMatrix(int n) {
    	Random r=new Random();
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			System.out.print(r.nextInt(2)+" ");
    		}
    		System.out.println('\n');
    	}
    }
    public static void main(String[] args) {
    	System.out.println("ÇëÊäÈë¾ØÕóµÄ½×Êýn:");
    	Scanner input=new Scanner(System.in);
    	int n=input.nextInt();
    	printMatrix(n);   			
    }
}
