package com.feeler.universe.rest;

import com.feeler.universe.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: wanglei1
 * @Date: 2018/09/15 0:20
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRestTest {

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getAll() {
        List<UserEntity> list = restTemplate.getForObject("http://localhost/getAll", List.class);
        System.out.println(list.toString());
    }
}
