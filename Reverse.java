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
    	System.out.println("请输入一个整数：");
    	Scanner input=new Scanner(System.in);
    	int number=input.nextInt();
    	System.out.println("该整数反序显示如下：");
    	reverse(number);
    }
}
