package com.kevin.test;

import com.kevin.MailApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MailApplication.class})    // 可以设置多个启动器，逗号分隔
public class MailApplicationTest {

}
