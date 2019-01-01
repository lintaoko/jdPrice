import config.DataConfig;
import config.RootConfig;
import db.mapper.ProductIdMapper;
import db.po.ProductId;
import db.po.ProductIdExample;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= DataConfig.class)
public class DataConfigTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;

    @Autowired
    ProductIdMapper productIdMapper;





    @Test
    public  void  dataSourceShouldNotBeNull(){
        assertNotNull(dataSource);

    }
    @Test
    public  void  sqlSessionFactoryshouldNotBeNull(){
        assertNotNull(sqlSessionFactoryBean);

    }

    @Test
    public  void  productIdMappershouldNotBeNull(){
        assertNotNull(productIdMapper);
    }

    @Test
    public void  testSelectByPhone(){
        ProductId productId = productIdMapper.getProductById("38554787911");
        System.out.println(productId.getAssortment());
//        List<ProductId> productIdList = productIdMapper.getHundredProductByAssortment("CPU");
//        for (ProductId pId:productIdList
//             ) {
//            System.out.println(pId.getCreateTime());
//        }
    }
}
