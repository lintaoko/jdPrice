import config.MysqlConfig;
import dao.ProductIdMapper;
import model.ProductId;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.ProductIdService;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MysqlConfig.class)
public class MysqlConfigTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;

    @Autowired
    ProductIdMapper productIdMapper;

    @Autowired
    ProductIdService productIdService;

    @Test
    public void dataSourceShouldNotBeNull() {
        assertNotNull(dataSource);

    }

    @Test
    public void sqlSessionFactoryshouldNotBeNull() {
        assertNotNull(sqlSessionFactoryBean);

    }

    @Test
    public void productIdMappershouldNotBeNull() {
        assertNotNull(productIdMapper);
    }

    @Test
    public void productIdServiceShouldNotBeNull() {
        assertNotNull(productIdService);
    }

    @Test
    public void productIdSelect() {
        /**
         * 测试产品选择
         * @date 2019/1/2
         * @params []
         * @return void
         **/
        ProductId productId = productIdMapper.selectByPrimaryKey("38554787911");
//        System.out.println(productId.getProductType());
        assertSameModel(productId);

    }

    public void assertSameModel(ProductId productId) {
        ProductId testProductId = new ProductId();
        testProductId.setAssortment("创意家居");
        testProductId.setCreateTime("2019-01-02 05:55:43.799824");
        testProductId.setImgUrl("http://img11.360buyimg.com/n9/s40x40_jfs/t1/17261/40/248/252147/5c087e1eE8e470211/4de7a2281e08fa35.png");
        testProductId.setProductId("38554787911");
        testProductId.setProductType("");

        assertEquals(testProductId.getCreateTime(), productId.getCreateTime());
        assertEquals(testProductId.getAssortment(), productId.getAssortment());
        assertEquals(testProductId.getProductType(), productId.getProductType());
        assertEquals(testProductId.getImgUrl(), productId.getImgUrl());
        assertEquals(testProductId.getProductId(), productId.getProductId());

    }

    @Test
    public void productIdServiceCanSelectItem() {
        /**
         * 测试Service 层是否可以进行查询
         * @date 2019/1/2
         * @params []
         * @return void
         **/
        ProductId productId = productIdService.selectByPrimaryKey("38554787911");
        assertSameModel(productId);

    }




}
