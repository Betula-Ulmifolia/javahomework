import java.util.Scanner;
public class Reverse {
    public static void reverse(int number) {
    	String str=number+"";
    	char[] ch=str.toCharArray();
    	for(int i=0;i<ch.length;i++) {
    		System.out.print(ch[ch.length-1-i]);
    	}
    }
    public static void main(String[] args) {
    	System.out.println("������һ��������");
    	Scanner input=new Scanner(System.in);
    	int number=input.nextInt();
    	System.out.println("������������ʾ���£�");
    	reverse(number);
    }
}
