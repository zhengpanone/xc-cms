package com.zp.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Author : zhengpanone
 * Date : 2024/1/23 15:33
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootTest(classes = FreemarkerTest.class)
public class FreemarkerTest {


    @Test
    public void testGenerateHtml() throws IOException, TemplateException {
        // 定义配置类
        Configuration configuration = new Configuration(Configuration.getVersion());

        // 得到classpath的路径
        String path = Objects.requireNonNull(this.getClass().getResource("/")).getPath();
        // 定义模版路径
        configuration.setDirectoryForTemplateLoading(new File(path + "/template/"));
        // 获取模版文件
        Template template = configuration.getTemplate("test1.ftl");
        // 定义数据模型
        Map<String, Object> map = getMap();
        // 静态化
        String conent = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        InputStream inputStream = IOUtils.toInputStream(conent, "UTF-8");
        FileOutputStream outputStream = new FileOutputStream(new File(path + "/test1.html"));
        IOUtils.copy(inputStream, outputStream);
        inputStream.close();
        outputStream.close();


    }

    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("salary", 100000);
        map.put("age", "18");
        return map;
    }
}
