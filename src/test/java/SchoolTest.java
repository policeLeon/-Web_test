import com.sun.org.apache.xml.internal.security.utils.resolver.ResourceResolverSpi;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.c_course;
import pojo.s_school;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

public class SchoolTest {
    @Test
    public void schoolFindBySidTest(){
        String resourses = "mybatis-config.xml";
        Reader reader = null ;
        try{
            reader = Resources.getResourceAsReader(resourses) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader) ;
        SqlSession session = sqlMapper.openSession() ;
        s_school school = session.selectOne("findBySchool_name","计算机学院") ;
        List<c_course> list = session.selectList("findAllBySid", school.getId());
        for(c_course course : list){
            System.out.println(course.toString());
        }
//        System.out.println(list);
        session.close();
    }
    @Test
    public void findAllCourseBySchoolId(){
        String resourses = "mybatis-config.xml";
        Reader reader = null ;
        try{
            reader = Resources.getResourceAsReader(resourses) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader) ;
        SqlSession session = sqlMapper.openSession() ;
        //先查出所有学院信息再根据学院id查出所有课程信息
        List<s_school> list1 = session.selectList("findAlls");
        for(s_school school : list1){
            List<c_course> list2 = session.selectList("findAllBySid",school.getId());
            for(c_course course :list2)
            {
                System.out.println(course.toString());
            }
        }
    }
}
