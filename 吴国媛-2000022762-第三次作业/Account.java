import java.util.Date;
class Account {
    private int id=0;  //定义私有变量id以储存开户账号，类型为int
    private double balance=0.0;  //定义私有变量balance以储存余额（初始值为0），类型为double
    private static double annualInterestRate=0.0;  //定义静态私有变量annualInterestRate（初始值为0），类型为double）
    private Date dateCreated; //定义私有变量dateCreated，其为Data类对象
    
    //默认构造函数
    public Account() {
    	dateCreated=new Date();
    };
    
    //构造函数，以id和balance为参数
    public Account(int id,double balance) {
    	this.id=id;
    	this.balance=balance;
    	dateCreated=new Date();
    }
    
    //访问id
    public int getId() {
    	return this.id;
    }
    
    //修改id
    public void modifyId(int id) {
    	this.id=id;
    }
    
    //访问余额balance
    public double getBalance() {
    	return this.balance;
    }
    
    //修改balance
    public void modifyBalance(double balance) {
    	this.balance=balance;
    }
    
    //访问年利率annualInterestRate
    public double getAnnualInterestRate() {
    	return annualInterestRate;
    }
    
    //修改annualInterestRate
    public void modifyAnnualInterestRate(double r) {
    	annualInterestRate=r;
    }
    
    //访问dateCreated
    public Date getDateCreated() {
    	return this.dateCreated;
    }
    
    //根据当前年利率返回月利率的值
    public double getMonthlyInterestRate() {
    	return annualInterestRate/12;
    }
    
    //根据当前的月利率和余额计算月利息并返回
    public double getMonthlyInterest() {
    	return this.getMonthlyInterestRate()*this.balance/100;
    }
    
    //取款操作，即减去余额的一部分
    public double withDraw(double withdraw) {
    	balance-=withdraw;
    	return balance;
    }
    
    //存款操作，即增加余额
    public double deposit(double deposit) {
    	balance+=deposit;
    	return balance;
    }
    
    //进行测试
    public static void main(String[] args) {
		Account account=new Account(123456,0);
		account.deposit(1000);
		account.withDraw(200);
		account.modifyAnnualInterestRate(3.0);
		System.out.println("账户ID为："+account.getId());
		System.out.println("账户当前余额为："+account.getBalance()+"元");
		System.out.println("当前月利率为："+account.getMonthlyInterestRate()+"%,该账户每月利息为："+account.getMonthlyInterest()+"元");
	}
}
