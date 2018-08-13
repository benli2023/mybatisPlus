package com.warrior.controler;

import com.baomidou.mybatisplus.plugins.Page;
import com.warrior.entity.Student;
import com.warrior.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lqh
 * @since 2018-05-05
 */
@Controller
@RequestMapping("/warrior/student")
public class StudentController {

  @Autowired
  IStudentService iStudentService;

  @RequestMapping("/hello")
  @ResponseBody
  public String hello() {
    //insert
    Student student = new Student().setStuName("zhangsan").setStuNumber("54").setAge(23);
    boolean res = iStudentService.insert(student);
    return res ? "success" : "fail";
  }

  @RequestMapping("/hello2")
  @ResponseBody
  public Page<Student> hello2() {
    return iStudentService.selectStudentByStuName("bb");
  }

  @RequestMapping("/hello3")
  @ResponseBody
  public Page<Student> hello3() {
    return iStudentService.selectStudentByStuName2("bb");
  }


  @RequestMapping("/page")
  @ResponseBody
  public Page<Student> page() {
    Page<Student> page = new Page<>(1, 10);
    final Page<Student> studentPage = iStudentService.selectPage(page);
    return studentPage;
  }
}
