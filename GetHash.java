import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class GetHash {
	//���㵥���ļ��Ĺ�ϣֵ
	public static byte[] SHA1Checksum(InputStream is) throws Exception{
		//���ڼ���hashֵ���ļ�������
		byte[] buffer=new byte[1024];
		//ʹ��SHA1��ϣ/ժҪ�㷨
		MessageDigest complete=MessageDigest.getInstance("SHA-1");
		int numRead=0;
		do {
			//����numRead�ֽڵ�buffer��
			numRead=is.read(buffer);
			if(numRead>0) {
				//����buffer[0:numRead]�����ݸ���hashֵ
				complete.update(buffer,0,numRead);
			}
			//�ļ��Ѷ��꣬�˳�ѭ��
		}while(numRead!=-1);
		//�ر�������
		is.close();
		//����SHA1��ϣֵ
		return complete.digest();
	}
	
	//���ָ��·�����ļ��л��ļ��Ĺ�ϣֵ
	public static byte[] getHash(String path) throws Exception {
		//���ݸ���·������File����
		File dir=new File(path);
		//���ݸ�File���󴴽�����
		File[] fs=dir.listFiles();
		//�������������ʹ��Arrays�е�Ĭ�Ϸ�����������
		Arrays.sort(fs);
		FileInputStream is;
		byte[] SHA1OfFile;
		//����MessageDigest����complete�Ա������ս����ʹ��SHA1��ϣ�㷨��
		MessageDigest complete=MessageDigest.getInstance("SHA-1");
		//��File�����е��ļ����б���
		for(int i=0;i<fs.length;i++) {
			//�����File�������һ���ļ����������ļ��Ĺ�ϣֵ�����µ����ս����
		    if(fs[i].isFile()) {
		        System.out.println("file:"+fs[i].getName());
		    	is=new FileInputStream(fs[i]);
		        SHA1OfFile=SHA1Checksum(is);
		    	complete.update(SHA1OfFile);
		    }
		    //�����File�������һ��Ŀ¼���򽫸�Ŀ¼��·������getHash�������еݹ飬�õ�Ŀ¼�Ĺ�ϣֵ����µ����ս����
		    if(fs[i].isDirectory()) {
		    	System.out.println("directory:"+fs[i].getName());
		    	SHA1OfFile=getHash(fs[i].getPath());
		    	complete.update(SHA1OfFile);
		    }
		}
		//����SHA1��ϣֵ
		return complete.digest();
	}
	
	public static void main(String[] args) {
		try {
			String path;
			System.out.println("������������ļ����ļ��е�·����");
			Scanner input=new Scanner(System.in);
			path=input.nextLine();
			
			byte[] sha1=getHash(path);
		    String result="";
		    for(int i=0;i<sha1.length;i++) {
			    result+=Integer.toString(sha1[i]&0xFF,16);
		    }
		    input.close();
		    System.out.println("���ļ����ļ��еĹ�ϣֵΪ��"+result);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}
