package cn.edu.fudan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataqualityApplicationTests {

	@Test
	public void contextLoads() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class c = Class.forName("org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties");
		Constructor constructor = c.getConstructor();
		Object o = constructor.newInstance();
		Method method = c.getMethod("isCache");

		System.out.println(method.invoke(o));
	}

}
