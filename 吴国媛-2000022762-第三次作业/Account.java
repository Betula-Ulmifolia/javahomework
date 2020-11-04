import java.util.Date;
class Account {
    private int id=0;  //����˽�б���id�Դ��濪���˺ţ�����Ϊint
    private double balance=0.0;  //����˽�б���balance�Դ�������ʼֵΪ0��������Ϊdouble
    private static double annualInterestRate=0.0;  //���徲̬˽�б���annualInterestRate����ʼֵΪ0��������Ϊdouble��
    private Date dateCreated; //����˽�б���dateCreated����ΪData�����
    
    //Ĭ�Ϲ��캯��
    public Account() {
    	dateCreated=new Date();
    };
    
    //���캯������id��balanceΪ����
    public Account(int id,double balance) {
    	this.id=id;
    	this.balance=balance;
    	dateCreated=new Date();
    }
    
    //����id
    public int getId() {
    	return this.id;
    }
    
    //�޸�id
    public void modifyId(int id) {
    	this.id=id;
    }
    
    //�������balance
    public double getBalance() {
    	return this.balance;
    }
    
    //�޸�balance
    public void modifyBalance(double balance) {
    	this.balance=balance;
    }
    
    //����������annualInterestRate
    public double getAnnualInterestRate() {
    	return annualInterestRate;
    }
    
    //�޸�annualInterestRate
    public void modifyAnnualInterestRate(double r) {
    	annualInterestRate=r;
    }
    
    //����dateCreated
    public Date getDateCreated() {
    	return this.dateCreated;
    }
    
    //���ݵ�ǰ�����ʷ��������ʵ�ֵ
    public double getMonthlyInterestRate() {
    	return annualInterestRate/12;
    }
    
    //���ݵ�ǰ�������ʺ�����������Ϣ������
    public double getMonthlyInterest() {
    	return this.getMonthlyInterestRate()*this.balance/100;
    }
    
    //ȡ�����������ȥ����һ����
    public double withDraw(double withdraw) {
    	balance-=withdraw;
    	return balance;
    }
    
    //�����������������
    public double deposit(double deposit) {
    	balance+=deposit;
    	return balance;
    }
    
    //���в���
    public static void main(String[] args) {
		Account account=new Account(123456,0);
		account.deposit(1000);
		account.withDraw(200);
		account.modifyAnnualInterestRate(3.0);
		System.out.println("�˻�IDΪ��"+account.getId());
		System.out.println("�˻���ǰ���Ϊ��"+account.getBalance()+"Ԫ");
		System.out.println("��ǰ������Ϊ��"+account.getMonthlyInterestRate()+"%,���˻�ÿ����ϢΪ��"+account.getMonthlyInterest()+"Ԫ");
	}
}
