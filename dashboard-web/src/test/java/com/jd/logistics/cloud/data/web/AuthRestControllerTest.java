package com.jd.logistics.cloud.data.web;

import com.jd.logistics.cloud.data.domain.AuthToken;
import com.jd.logistics.cloud.data.domain.RequestError;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/17 10:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthRestControllerTest {
    private static final String authUrl = "auth/token";

    @Data
    private class TestUser {
        private String username;
        private String password;

        public TestUser(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void userNotExists() throws Exception {
        String url = "http://localhost:" + port + "/" + authUrl;
        TestUser user = new TestUser("test", "admin");
        ResponseEntity entity = restTemplate.postForEntity(url, user, Map.class);
        Map error = (Map) entity.getBody();
        assertThat(error.get("msg").equals("账户不存在，请重新输入！"));
    }

    @Test
    public void passwordNotCorrect() throws Exception {
        String url = "http://localhost:" + port + "/" + authUrl;
        TestUser user = new TestUser("admin", "admin1");
        ResponseEntity entity = restTemplate.postForEntity(url, user, Map.class);
        Map error = (Map) entity.getBody();
        assertThat(error.get("msg").equals("密码不正确！"));
    }

    @Test
    public void tokenReturns() throws Exception {
        String url = "http://localhost:" + port + "/" + authUrl;
        TestUser user = new TestUser("admin", "admin");
        AuthToken token = restTemplate.postForObject(url, user, AuthToken.class);
        assertThat(token.getToken().isEmpty());

    }
}
