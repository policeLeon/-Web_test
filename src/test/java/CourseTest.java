import com.sun.org.apache.xml.internal.security.utils.resolver.ResourceResolver;
import com.sun.org.apache.xml.internal.security.utils.resolver.ResourceResolverSpi;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.c_course;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CourseTest {
    @Test
    public void courseFindByIdTest(){
        String resourses = "mybatis-config.xml" ;
        Reader reader = null ;
        try{
           reader = Resources.getResourceAsReader(resourses);
        } catch(IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
//        1. 根据id查询操作
        c_course course = session.selectOne("findById2",2);
        System.out.println(course.toString());
    }
    @Test
    public void courseUpdateByIdTest(){
        String resourses = "mybatis-config.xml" ;
        Reader reader = null ;
        try{
            reader = Resources.getResourceAsReader(resourses) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader) ;
        SqlSession session = sqlMapper.openSession() ;


//        2. 根据id进行更新
//        c_course course = session.selectOne("findById2",4);
//        System.out.println("更新前：");
//        System.out.println(course.toString());
//        course.setHours(40);
//        session.update("updateById",course);
//        course = session.selectOne("findById2", 4);
//        System.out.println("更新后：");
//        System.out.println(course.toString());
//        //需要提交对数据库的修改才会生效
//        session.commit();

//         3. 插入操作
        System.out.println("插入前：");
        List<c_course> list = session.selectList("findAll");
        for(c_course course : list){
            System.out.println(course.toString());
        }
        c_course course = new c_course();
        course.setHours(32);
        course.setName("大数据存储");
        course.setSid(1);
        session.insert("insert",course);
        session.commit();
//        System.out.println(course.toString());
        System.out.println("插入后：");
        List<c_course> list2 = session.selectList("findAll");
        for(c_course course2 : list2){
            System.out.println(course2.toString());
        }
    }
    @Test
    public void deleteByS_nameTest(){
        String resourses = "mybatis-config.xml";
        Reader reader = null;
        try{
            reader = Resources.getResourceAsReader(resourses);
        }
        catch(IOException e){
            System.out.println(e);
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
//        4. 根据课程名进行删除操作
        System.out.println("删除前：");
        List<c_course> list1 = session.selectList("findAll");
        for(c_course course : list1){
            System.out.println(course.toString());
        }
        session.delete("deleteByS_name","大数据存储");
        session.commit();
        System.out.println("删除后：");
        List<c_course> list = session.selectList("findAll");
        for(c_course course2 : list){
            System.out.println(course2.toString());
        }
    }
}
