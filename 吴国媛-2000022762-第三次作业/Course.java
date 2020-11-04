
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
    
    //定义clone方法，其作用是拷贝
    public void clone(Course course){
    	this.courseName=course.getCourseName();
    	this.students=course.getStudents();
    	this.numberOfStudents=course.getNumberOfStudents();
    }
    
    //测试
    public static void main(String[] args) {
    	Course c1,c2;
    	c1=new Course("数学");
    	c2=new Course();
    	c1.addStudent("小红");
    	c1.addStudent("小明");
    	c1.addStudent("小丽");
    	c2.clone(c1);
    	System.out.println("c1的课程名为："+c1.getCourseName()+",学生有"+c1.getNumberOfStudents()+"名，学生分别为：");
    	for(int i=0; i<c1.getNumberOfStudents();i++)
    		System.out.println(c1.getStudents()[i]);
    	System.out.println("c2的课程名为："+c2.getCourseName()+",学生有"+c2.getNumberOfStudents()+"名,学生分别为：");
    	for(int i=0; i<c2.getNumberOfStudents();i++)
    		System.out.println(c2.getStudents()[i]);
    }
}
