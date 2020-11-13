import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class GetHash {
	//���㵥���ļ��Ĺ�ϣֵ
	public static void SHA1Checksum(InputStream is,MessageDigest complete) throws Exception{
		//���ڼ���hashֵ���ļ�������
		byte[] buffer=new byte[1024];
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
	}
	
	//���ָ��·�����ļ��л��ļ��Ĺ�ϣֵ
	public static void getHash(String path, MessageDigest complete) throws Exception {
		//���ݸ���·������File����
		File dir=new File(path);
		//���ݸ�File���󴴽�����
		File[] fs=dir.listFiles();
		//�������������ʹ��Arrays�е�Ĭ�Ϸ�����������
		Arrays.sort(fs);
		FileInputStream is;
		//��File�����е��ļ����б���
		for(int i=0;i<fs.length;i++) {
			//�����File�������һ���ļ������ȡ���ļ��������µ����ս����
		    if(fs[i].isFile()) {
		        System.out.println("file:"+fs[i].getName());
		    	is=new FileInputStream(fs[i]);
		        SHA1Checksum(is,complete);
		    }
		    //�����File�������һ��Ŀ¼���򽫸�Ŀ¼��·������getHash�������еݹ飬�Ը��µ�ǰ���
		    if(fs[i].isDirectory()) {
		    	System.out.println("directory:"+fs[i].getName());
		    	getHash(fs[i].getPath(),complete);
		    }
		}
	}
	
	public static void main(String[] args) {
		try {
			String path;
			System.out.println("������������ļ����ļ��е�·����");
			Scanner input=new Scanner(System.in);
			path=input.nextLine();
			//����MessageDigest����complete�Ա����ļ����ļ��й�ϣֵ
			MessageDigest complete=MessageDigest.getInstance("SHA-1");
			getHash(path,complete);
			byte[] sha1=complete.digest();
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
