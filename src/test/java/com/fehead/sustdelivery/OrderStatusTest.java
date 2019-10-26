package com.fehead.sustdelivery;

import com.fehead.sustdelivery.dao.OrderDOMapper;
import com.fehead.sustdelivery.dataobject.OrderStatusDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-22 20:46
 */

/**
 * 测试数据库层SQL语句
 */
public class OrderStatusTest {
    /**
     * Rigorous Test :-)
     */
    private InputStream in;
    private SqlSession sqlSession;
    private OrderDOMapper orderDOMapper;

    @Before
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        orderDOMapper = sqlSession.getMapper(OrderDOMapper.class);
    }

    @After
    public void destroy() throws IOException {

        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    /**
     * 测试更新订单状态
     */
    @Test
    public void testUpdateStatus(){
        OrderStatusDO orderStatusDO = new OrderStatusDO();
        orderStatusDO.setStatus(2);
        orderStatusDO.setOrderId(20);
        orderStatusDO.setUpdateTime(new Date());
        orderDOMapper.updateStatus(orderStatusDO);
    }

    @Test
    public void testUpdateStatus2(){
        OrderStatusDO orderStatusDO = new OrderStatusDO();
        orderStatusDO.setStatus(2);
        orderStatusDO.setOrderId(25);
        orderStatusDO.setUpdateTime(new Date());
        orderStatusDO.setReceiverId(41);
        orderDOMapper.updateStatus2(orderStatusDO);
    }
}
