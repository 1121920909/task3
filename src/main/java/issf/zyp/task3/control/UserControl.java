package issf.zyp.task3.control;

import issf.zyp.task3.domain.Student;
import issf.zyp.task3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZYP
 */
@Controller

public class UserControl {
  @Autowired
  private StudentService service;

  @RequestMapping(value = "/student",method = RequestMethod.GET)
  public String test(ModelMap map) {
    List<Student> list = new ArrayList<>();
    Student s = new Student();
    s.setAge(11);
    s.setCollege("213");
    s.setHobby("0101");
    s.setId(123);
    s.setName("qe");
    s.setSex("123");
    list.add(s);
    map.addAttribute("studentList", list);
    //map.addAttribute("studentList", service.findAllStudent());
    //map.addAttribute("hobbyMap", service.getHobbyTable());
    return "student_infor_thymeleaf";
  }

  @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
  public String deleteStudent(@PathVariable int id, ModelMap map) {
    service.deleteStudent(id);
    return "redirect:/student";
  }

  @RequestMapping(value = "/student/update/{id}", method = RequestMethod.GET)
  public String update(@PathVariable int id, ModelMap map) {
    map.addAttribute("studnet", service.selectStudentById(id));
    return "student_update_thymeleaf";
  }

  @RequestMapping("/student/updateStudent")
  public String updateStudent(String studentJson) {
    service.updateStudent(studentJson);
    return "redirect:/student";
  }

  @RequestMapping("/student/add")
  public String addStudent(String studentJson) {
    service.insertStudent(studentJson);
    return "redirect:/student";
  }

}
