package com.warrior.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.warrior.entity.Student;
import com.warrior.mapper.StudentMapper;
import com.warrior.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lqh
 * @since 2018-05-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

  @Autowired
  private StudentMapper studentMapper;

  @Override
  public Page<Student> selectStudentByStuName(String Student) {
    Page<Student> page = new Page<>(1, 10);
    Wrapper<Student> tWrapper = new EntityWrapper<>();
    tWrapper.eq("stu_name", Student);
    final List<com.warrior.entity.Student> students = this.baseMapper.selectPage(page, tWrapper);
    page.setRecords(students);
    return page;
  }

  @Override
  public Page<Student> selectStudentByStuName2(String student) {
    Page<Student> page = new Page<>(1, 10);
    final List<Student> students = studentMapper.selectStudentByStuName(page, student);
    page.setRecords(students);
    return page;
  }
}
