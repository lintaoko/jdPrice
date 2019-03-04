import info.xiantang.config.MysqlConfig;
import info.xiantang.dao.ProductIdMapper;
import info.xiantang.dao.UserMapper;
import info.xiantang.model.Product;
import info.xiantang.model.User;
import info.xiantang.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import info.xiantang.service.UserService;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;

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
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

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
        assertNotNull(productService);
    }

    @Test
    public void productIdSelect() {
        /**
         * 测试产品选择
         * @date 2019/1/2
         * @params []
         * @return void
         **/
        Product product = productIdMapper.selectByPrimaryKey("38554787911");
//        System.out.println(product.getProductType());
        assertSameModel(product);

    }

    public void assertSameModel(Product product) {
        Product testProduct = new Product();
        testProduct.setAssortment("创意家居");
        testProduct.setCreateTime("2019-01-02 05:55:43.799824");
        testProduct.setImgUrl("http://img11.360buyimg.com/n9/s40x40_jfs/t1/17261/40/248/252147/5c087e1eE8e470211/4de7a2281e08fa35.png");
        testProduct.setProductId("38554787911");
        testProduct.setProductType("");

//        assertEquals(testProduct.getCreateTime(), product.getCreateTime());
        assertEquals(testProduct.getAssortment(), product.getAssortment());
        assertEquals(testProduct.getProductType(), product.getProductType());
        assertEquals(testProduct.getImgUrl(), product.getImgUrl());
        assertEquals(testProduct.getProductId(), product.getProductId());

    }


    @Test
    public void productIdServiceCanSelectItem() {
        /**
         * 测试Service 层是否可以进行查询
         * @date 2019/1/2
         * @params []
         * @return void
         **/

        Product product = productService.selectByPrimaryKey("38554787911");
        assertSameModel(product);

    }


//    @Test
//    public void addUser(){
//        User user = new User("dd",
//                "123456zjd",
//                "zhujingdi1998@gmail.com");
//        userService.saveUser(user);
//    }

    @Test
    public void userServiceCanSelectItem() {
        User user = userService.selectById(1);
//        assertNotNull(user);
        System.out.println(user.getEmail());
    }

    @Test
    public void fetchUserId() {
        Map<String, String>
                urlVariables = new HashMap<>();
        urlVariables.put("id", "1");
        RestTemplate rest = new RestTemplate();
        User user = rest.getForObject("http://localhost:8080/jdProduct_war/user/1",
                User.class, urlVariables);
        assertEquals("986494553@qq.com",user.getEmail());
    }

    @Test
    public void postUserId() {
        RestTemplate rest = new RestTemplate();
        User user = new User("dd", "123456zjd", "9864945533@qq.com");
        rest.postForObject("http://localhost:8080/jdProduct_war/user", user, User.class);
        assertEquals(1,userMapper.deleteByEmail("9864945533@qq.com"));
    }




}
