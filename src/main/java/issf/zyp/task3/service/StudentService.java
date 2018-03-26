package issf.zyp.task3.service;


import com.alibaba.fastjson.JSON;
import issf.zyp.task3.dao.StudentDao;
import issf.zyp.task3.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZYP
 */
@Service("StudentService")
public class StudentService {
  @Autowired
  private StudentDao stuDao;

  public List<Student> findAllStudent() {
    return stuDao.findAllStudent();
  }

  public Student selectStudentById(int id) {
    return stuDao.selectStudentById(id);
  }

  public int updateStudent(String studentJson) {
    Student student = JSON.parseObject(studentJson,Student.class);
    return stuDao.updateStudent(student);
  }

  public int insertStudent(String studentJson) {
    Student student = JSON.parseObject(studentJson, Student.class);
    return stuDao.insertStudent(student);
  }

  public int deleteStudent(int id) {
    return stuDao.deleteStudent(id);
  }
}
