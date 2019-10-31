package com.fehead.sustdelivery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
 * @date 2019-08-24 17:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
    @Autowired
    WebApplicationContext applicationContext;

    MockMvc mockMvc;

    @Before
    public void setup(){

        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    /**
     * 测试修改订单状态
     */
    @Test
    public void whenUpdateStatus() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1.0/SUSTDelivery/data/order/30/status/6"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);

    }

    @Test
    public void whenUpdateStatus2() throws Exception{
        String result = mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1.0/SUSTDelivery/data/user/41/order/36"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    public void whenGetAcceptableOrderByDestinationSuccess() throws Exception{
        String result = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1.0/SUSTDelivery/data/order/lists")
                .param("search", "d")
                .param("page", "1")
                .param("pagesize", "5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    public void whenGetAllDeliveryPointSuccess() throws Exception{
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1.0/SUSTDelivery/data/order/lists/delivery"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }
}
