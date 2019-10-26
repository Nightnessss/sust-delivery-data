package com.fehead.sustdelivery;

import static org.junit.Assert.assertTrue;

import com.fehead.sustdelivery.dao.UserDOMapper;
import com.fehead.sustdelivery.dataobject.DeliveryPointDO;
import com.fehead.sustdelivery.dataobject.OrderDO;
import com.fehead.sustdelivery.dataobject.OrderStatusDO;
import com.fehead.sustdelivery.dataobject.UserDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */

/**
 * 测试数据库层SQL语句
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    private InputStream in;
    private SqlSession sqlSession;
    private UserDOMapper userDOMapper;

    @Before
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDOMapper = sqlSession.getMapper(UserDOMapper.class);
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
     * 测试查询功能
     */
    @Test
    public void testSelectOrder(){
//        PageHelper.startPage(1,1);
        List<OrderDO>  orders = userDOMapper.selectOrder();
        for(OrderDO order: orders){
            System.out.println(order);
        }
    }

    @Test
    public void testSelectStatus(){
        List<OrderStatusDO>  orders = userDOMapper.selectStatus();
        for(OrderStatusDO orderStatus: orders){
            System.out.println(orderStatus);
        }

    }

    @Test
    public void testSelectUser(){
        List<UserDO>  userDOList = userDOMapper.selectUser();
        for(UserDO user: userDOList){
            System.out.println(user);
        }

    }

    @Test
    public void testSelectDeliveryPoint(){
        List<DeliveryPointDO>  deliveryPointDOList = userDOMapper.selectDeliveryPoint();
        for(DeliveryPointDO deliveryPointDO: deliveryPointDOList){
            System.out.println(deliveryPointDO);
        }

    }

    @Test
    public void testSelectReceiverOrder(){
        List<OrderDO> orderDOList = userDOMapper.selectReceiverOrder(41);
        for(OrderDO orderDO:orderDOList){
            System.out.println(orderDO);
        }
    }

    @Test
    public void testSelectOrderById(){
        OrderDO orderDO = userDOMapper.selectOrderById(39);
        System.out.println(orderDO);
    }

    @Test
    public void testSelectAcceptableOrder(){
        List<OrderDO> orderDOList = userDOMapper.selectAcceptableOrder();
        for(OrderDO orderDO:orderDOList){
            System.out.println(orderDO);
        }
    }
    /**
     * 测试插入功能
     */
    @Test
    public void testCommitOrder() throws ParseException {
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        OrderDO order = new OrderDO();
        order.setUpdateTime(new Date());
        order.setDeadline(sdf.parse("2019-08-23 09:00:00"));
        order.setDestination("实验楼");
        order.setDeliveryPointId(1);
        order.setType(1);
        order.setFee("3");
        order.setRemark("尽快送达");
        order.setPickCode("0118");
        order.setPickName("Maria");
        order.setTailNumber("15829419595");
        System.out.println("执行之前:"+order);
        userDOMapper.commitOrder(order);
        System.out.println("执行之后："+order);

        OrderStatusDO orderStatusDO = new OrderStatusDO();
        orderStatusDO.setOrderId(order.getId());
        orderStatusDO.setStatus(1);
        orderStatusDO.setPublisherId(22);
        orderStatusDO.setUpdateTime(new Date());
        userDOMapper.insertOrderStatus(orderStatusDO);

    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdateOrder() throws ParseException {
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        OrderDO order = new OrderDO();
        order.setUpdateTime(new Date());
        order.setId(11);
        order.setDeadline(sdf.parse("2019-08-23 09:00:00"));
        order.setDestination("实验楼");
        order.setDeliveryPointId(1);
        order.setType(1);
        order.setFee("4");
        order.setRemark("尽快送达");
        order.setPickCode("0118");
        order.setPickName("Maria");
        order.setTailNumber("15829419595");
        System.out.println("执行之前:"+order);
        userDOMapper.updateOrder(order);
        System.out.println("执行之后："+order);

    }


}
