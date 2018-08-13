package com.warrior.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.warrior.entity.Student;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lqh
 * @since 2018-05-05
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

  List<Student> selectStudentByStuName(RowBounds pagination, @Param("stuName") String stuName);

}