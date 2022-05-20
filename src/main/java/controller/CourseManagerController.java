package controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.c_course;

import java.io.Reader;

@Controller
public class CourseManagerController {
    @RequestMapping("/courseList")
    public String addCourseView() {
        return "courseList";
    }

    @RequestMapping("/manageCourse")
public String manageCourse(){
        return "manageCourse" ;
}

    @RequestMapping("/addCourse")
    public String addCourse(c_course course){
//        创建SQL语句与数据库交互对象sqlSeesion
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try{
            reader = Resources.getResourceAsReader(resources);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
//        从表单获取的course对象属性直接插入数据库

        session.insert("insert", course);
        session.commit();
        System.out.println("插入成功！");
//        调用SQL语句插入操作
        return "courseList" ;
    }
    @RequestMapping("/updateCourse")
    public String updateCourse(c_course course){
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try{
            reader = Resources.getResourceAsReader(resources);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
        session.update("updateById", course);
        session.commit();
        System.out.println("修改成功!");
        return "courseList";
    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(c_course course){
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try{
            reader = Resources.getResourceAsReader(resources);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
        session.delete("deleteById",course.getId());
        session.commit();
        System.out.println("删除成功!");
        return "courseList";
    }
}
