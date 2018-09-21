package com.feeler.universe.restclient;

import com.feeler.universe.entity.UserEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wanglei1
 * @Date: 2018/09/16 1:13
 * @Description:
 */
@RestController
public class UserRestClient {

    RestTemplate restTemplate = new RestTemplate();

    /**
     * GET method, no param, return pojo
     * @return
     */
    @RequestMapping("getAll2")
    public List<UserEntity> getAll() {
        List<UserEntity> list = restTemplate.getForObject("http://localhost/getAll", List.class);
        System.out.println(list.toString());
        return list;
    }


    /**
     * GET method, no param, return ResponseEntity
     * @return
     */
    @RequestMapping("getForEntity")
    public List<UserEntity> getAll2() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost/getAll", List.class);
        HttpHeaders headers = responseEntity.getHeaders();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int code = statusCode.value();
        List<UserEntity> list = responseEntity.getBody();
        System.out.println(list.toString());
        return list;

    }

    /**
     * GET method, have param id, return pojo
     * @return
     */
    @RequestMapping("get2/{id}")
    public UserEntity getById(@PathVariable(name = "id") String id) {
        UserEntity userEntity = restTemplate.getForObject("http://localhost/get/{id}", UserEntity.class, id);
        return userEntity;
    }

    /**
     * GET method, have param id with map, return pojo
     * @return
     */
    @RequestMapping("get3/{id}")
    public UserEntity getById3(@PathVariable(name = "id") String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        UserEntity userEntity = restTemplate.getForObject("http://localhost/get/{id}", UserEntity.class, map);
        return userEntity;
    }

    /**
     * POST method, have param UserEntity, return ResponseEntity
     * @return
     * request example: http://localhost/saveUser?id=133&username=itguang&password=123456&age=20&email=123@123.com
     */
    @RequestMapping("saveUser")
    public String save(UserEntity userEntity) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/save", userEntity, String.class);
        String body = responseEntity.getBody();
        return body;
    }

    /**
     * POST method, have param UserEntity, return ResponseEntity
     * @return
     */
    @RequestMapping("saveUserByType/{type}")
    public String save2(UserEntity userEntity,@PathVariable("type")String type) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", userEntity, String.class, type);
        String body = responseEntity.getBody();
        return body;

    }

    /**
     * POST method, have param UserEntity, return ResponseEntity
     * @return
     */
    @RequestMapping("saveUserByType2/{type}")
    public String save3(UserEntity userEntity, @PathVariable("type")String type) {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", type);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", userEntity, String.class, map);
        String body = responseEntity.getBody();
        return body;

    }
}
