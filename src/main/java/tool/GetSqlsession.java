package tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlsession {
    /**
     * 获得sqlseeionFactor对象
     * @return
     * @throws IOException
     */
    public static SqlSessionFactory getFactor() throws IOException {

        String resource = "Mybatis.xml";//mybits.xml的“来自源根的路径”
        InputStream inputStream = null;
        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;

    }
}
