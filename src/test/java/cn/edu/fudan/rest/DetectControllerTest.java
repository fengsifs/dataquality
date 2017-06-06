package cn.edu.fudan.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by FengSi on 2017/06/06 at 16:10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DetectControllerTest {
    @Test
    public void detect() {
        DetectController detectController = new DetectController();
        detectController.detect("测试表名","规则类型","左侧属性","右侧属性");
    }
}
