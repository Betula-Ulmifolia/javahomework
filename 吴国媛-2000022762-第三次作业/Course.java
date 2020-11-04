
public class Course {
    private String courseName;
    private String[] students=new String[100];
    private int numberOfStudents;
    public Course() {}
    public Course(String courseName) {
    	this.courseName=courseName;
    }
    public void addStudent(String student) {
    	students[numberOfStudents]=student;
    	numberOfStudents++;
    }
    public String[] getStudents() {
    	return students;
    }
    public int getNumberOfStudents() {
    	return numberOfStudents;
    }
    public String getCourseName() {
    	return courseName;
    }
    
    //����clone�������������ǿ���
    public void clone(Course course){
    	this.courseName=course.getCourseName();
    	this.students=course.getStudents();
    	this.numberOfStudents=course.getNumberOfStudents();
    }
    
    //����
    public static void main(String[] args) {
    	Course c1,c2;
    	c1=new Course("��ѧ");
    	c2=new Course();
    	c1.addStudent("С��");
    	c1.addStudent("С��");
    	c1.addStudent("С��");
    	c2.clone(c1);
    	System.out.println("c1�Ŀγ���Ϊ��"+c1.getCourseName()+",ѧ����"+c1.getNumberOfStudents()+"����ѧ���ֱ�Ϊ��");
    	for(int i=0; i<c1.getNumberOfStudents();i++)
    		System.out.println(c1.getStudents()[i]);
    	System.out.println("c2�Ŀγ���Ϊ��"+c2.getCourseName()+",ѧ����"+c2.getNumberOfStudents()+"��,ѧ���ֱ�Ϊ��");
    	for(int i=0; i<c2.getNumberOfStudents();i++)
    		System.out.println(c2.getStudents()[i]);
    }
}
