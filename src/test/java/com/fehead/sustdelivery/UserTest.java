package com.fehead.sustdelivery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: sustdelivery
 * @date 2019-08-24 17:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    WebApplicationContext applicationContext;

    MockMvc mockMvc;

    @Before
    public void setup(){

        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    /**
     * 测试查询所有订单
     */
    @Test
    public void whenGetAllOrderSuccess() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1.0/SUSTDelivery/data/lists")
                        .param("page","2")
                        .param("pagesize","3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);

    }

    /**
     * 测试通过Id查找用户
     */
    @Test
    public void whenGetUserById() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1.0/SUSTDelivery/data/user/41"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 测试通过订单Id查找订单
     */
    @Test
    public void whenGetOrderById() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1.0/SUSTDelivery/data/order/36"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 测试查找所有可接订单
     */
    @Test
    public void whenGetAcceptableOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1.0/SUSTDelivery/data/order/lists/status")
                        .param("page","2")
                        .param("pagesize","3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 测试通过用户Id查找已发订单
     */
    @Test
    public void whenGetPublisherOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1.0/SUSTDelivery/data/order/publisher/41")
        .param("page","2")
        .param("pagesize","3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 测试通过用户Id查找已接订单
     */
    @Test
    public void whenGetReceiverOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1.0/SUSTDelivery/data/order/receiver/23")
                        .param("page","2")
                        .param("pagesize","3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }
    /**
     * 测试通过快递点id查找快递点详细信息
     */
    @Test
    public void whenGetDeliveryPointByIdSuccess() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1.0/SUSTDelivery/data/order/lists/delivery/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 测试发布订单
     */
    @Test
    public void whenCommitOrderSuccess() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1.0/SUSTDelivery/data/order"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);

    }
    /**
     * 测试修改订单
     */
    @Test
    public void whenUpdateOrderSuccess() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1.0/SUSTDelivery/data/order"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);

    }


}
