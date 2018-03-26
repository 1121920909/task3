
package issf.zyp.task3.dao;

import issf.zyp.task3.Application;
import issf.zyp.task3.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;






@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootConfiguration
public class StudentDaoTest {
  @Autowired
  private StudentDao dao;
  @Test
  @Rollback
  public void insertStudnetTest(){
    Student s = new Student();
    s.setId(0);
    s.setAge(20);
    s.setName("zzz");
    s.setSex("男");
    s.setHobby("XXX");
    s.setCollege("管理学院");
    s.setMajor("信息管理与信息系统专业");
    dao.insertStudent(s);
    System.out.println("insert success:" + s);
  }

  @Test
  @Rollback
  public void selectStudentByIdTest() {
    Student s = dao.selectStudentById(0);
    if (s != null) {
      System.out.println("select success" + s);
    }
  }

  @Test
  public void updateStudentTest() {
    Student s = dao.selectStudentById(0);
    System.out.println("修改前:" + s);
    s.setAge(22);
    dao.updateStudent(s);
    s = dao.selectStudentById(0);
    System.out.println("修改后:" + s);
  }

  @Test
  public void deleteStudentTest() {
    dao.deleteStudent(0);
  }
}

