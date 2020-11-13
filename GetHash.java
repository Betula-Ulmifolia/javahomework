import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class GetHash {
	//计算单个文件的哈希值
	public static void SHA1Checksum(InputStream is,MessageDigest complete) throws Exception{
		//用于计算hash值的文件缓冲区
		byte[] buffer=new byte[1024];
		int numRead=0;
		do {
			//读出numRead字节到buffer中
			numRead=is.read(buffer);
			if(numRead>0) {
				//根据buffer[0:numRead]的内容更新hash值
				complete.update(buffer,0,numRead);
			}
			//文件已读完，退出循环
		}while(numRead!=-1);
		//关闭输入流
		is.close();
	}
	
	//获得指定路径下文件夹或文件的哈希值
	public static void getHash(String path, MessageDigest complete) throws Exception {
		//根据给定路径创建File对象
		File dir=new File(path);
		//根据该File对象创建数组
		File[] fs=dir.listFiles();
		//对数组进行排序（使用Arrays中的默认方法进行排序）
		Arrays.sort(fs);
		FileInputStream is;
		//对File数组中的文件进行遍历
		for(int i=0;i<fs.length;i++) {
			//如果该File对象代表一个文件，则读取该文件并并更新到最终结果中
		    if(fs[i].isFile()) {
		        System.out.println("file:"+fs[i].getName());
		    	is=new FileInputStream(fs[i]);
		        SHA1Checksum(is,complete);
		    }
		    //如果该File对象代表一个目录，则将该目录的路径传入getHash函数进行递归，以更新当前结果
		    if(fs[i].isDirectory()) {
		    	System.out.println("directory:"+fs[i].getName());
		    	getHash(fs[i].getPath(),complete);
		    }
		}
	}
	
	public static void main(String[] args) {
		try {
			String path;
			System.out.println("请输入待计算文件或文件夹的路径：");
			Scanner input=new Scanner(System.in);
			path=input.nextLine();
			//创建MessageDigest对象complete以保存文件或文件夹哈希值
			MessageDigest complete=MessageDigest.getInstance("SHA-1");
			getHash(path,complete);
			byte[] sha1=complete.digest();
		    String result="";
		    for(int i=0;i<sha1.length;i++) {
			    result+=Integer.toString(sha1[i]&0xFF,16);
		    }
		    input.close();
		    System.out.println("该文件或文件夹的哈希值为："+result);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}
