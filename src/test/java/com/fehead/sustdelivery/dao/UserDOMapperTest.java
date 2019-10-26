package com.fehead.sustdelivery.dao;

import com.fehead.sustdelivery.App;
import com.fehead.sustdelivery.dataobject.OrderDO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * 写代码 敲快乐
 * だからよ...止まるんじゃねぇぞ
 * ▏n
 * █▏　､⺍
 * █▏ ⺰ʷʷｨ
 * █◣▄██◣
 * ◥██████▋
 * 　◥████ █▎
 * 　　███▉ █▎
 * 　◢████◣⌠ₘ℩
 * 　　██◥█◣\≫
 * 　　██　◥█◣
 * 　　█▉　　█▊
 * 　　█▊　　█▊
 * 　　█▊　　█▋
 * 　　 █▏　　█▙
 * 　　 █
 *
 * @author Nightnessss 2019/10/26 11:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserDOMapperTest {
    @Autowired
    WebApplicationContext applicationContext;

    MockMvc mockMvc;

    @Before
    public void setup(){

        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }
    @Autowired
    private UserDOMapper userDOMapper;
    @Test
    public void whenSelectAcceptableOrderByDestinationSuccess() {

        final List<OrderDO> list = userDOMapper.selectAcceptableOrderByDestination("D");

        list.forEach(value-> System.out.println(value));
    }

    @Test
    public void whenSelectAcceptableOrderByPointSuccess() {

        final List<OrderDO> list = userDOMapper.selectAcceptableOrderByPoint(1);

        list.forEach(value-> System.out.println(value));
    }
}
