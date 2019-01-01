import config.DataConfig;
import config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= DataConfig.class)
public class DataConfigTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public  void  dataSourceShouldNotBeNull(){
        assertNotNull(dataSource);

    }
    @Test
    public  void  sqlSessionFactoryhouldNotBeNull(){
        assertNotNull(sqlSessionFactoryBean);

    }
}
