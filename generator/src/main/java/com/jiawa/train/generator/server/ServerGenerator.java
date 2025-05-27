package com.jiawa.train.generator.server;

import com.jiawa.train.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: 陈桂明
 * Date: 2025/5/27 15:36
 * Description: ServerGenerator
 */
public class ServerGenerator {
    static String toPath = "generator/src/main/java/com/jiawa/train/generator/test/";
    static String pomPath = "generator/pom.xml";

    static {
        new File(toPath).mkdirs();
    }

    public static void main(String[] args) throws IOException, TemplateException, DocumentException {
        SAXReader saxReader = new SAXReader();
        HashMap<String, String> map = new HashMap<>();
        map.put("pom", "http://maven.apache.org/POM/4.0.0");
        saxReader.getDocumentFactory().setXPathNamespaceURIs(map);
        Document document = saxReader.read(pomPath);
        Node node = document.selectSingleNode("//pom:configurationFile");
        System.out.println(node.getText());

        // FreemarkerUtil.initConfig("test.ftl");
        // Map<String, Object> param = new HashMap<>();
        // param.put("domain", "Test");
        // FreemarkerUtil.generator(toPath + "Test.java", param);
    }
}
