package issf.zyp.task3.dao;

import issf.zyp.task3.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;
/**
 * @author ZYP
 */
@Repository("stuDao")
public interface StudentDao {
  /**
   * 查询所有学生信息
   * @return 学生信息列表
   */
  List<Student> findAllStudent();

  /**
   * 根据ID查询学生信息
   * @param id 学生ID
   * @return Student信息
   */
  Student selectStudentById(@Param("id") int id);

  /**
   * 根据学生信息修改学生信息
   * @param student 学生
   * @return
   */
  int updateStudent(Student student);

  /**
   * 根据学生ID删除学生信息
   * @param id 学生ID
   * @return
   */
  int deleteStudent(@Param("id") int id);

  /**
   * 根据学生信息插入学生信息
   * @param student
   * @return
   */
  int insertStudent(Student student);
}
