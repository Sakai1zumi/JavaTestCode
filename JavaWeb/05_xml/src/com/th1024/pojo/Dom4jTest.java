package com.th1024.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author TuHong
 * @create 2021-03-20 21:42
 */
public class Dom4jTest {

    @Test
    public void test1() throws DocumentException {
        //创建一个SAXReader输入流，读取xml配置文件，生成Document对象
        SAXReader reader = new SAXReader();
        //使用reader读取xml文件，返回一个Document对象
        Document document = reader.read("src/books.xml");
        //打印到控制台，是否创建成功
        System.out.println(document);
    }

    //读取xml文件的内容
    @Test
    public void test2() throws DocumentException {
        //1. 创建SAXReader对象，读取xml文件，获取Document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        //2. 通过Document对象，获取xml的根元素对象
        Element rootElement = document.getRootElement();//Element.asXML() 它将当前元素转换成为String
        //3. 通过根元素对象，获取所有的标签对象
        //Element.elements(标签名)：获取当前元素下的指定的子元素的集合
        List<Element> books = rootElement.elements("book");
        //4. 遍历每个book标签对象，获取book标签对象中的每个元素
        for(Element book : books){
            //获取book标签中的name元素对象
            Element name = book.element("name");
            //获取book标签中的author元素对象
            Element author = book.element("author");
            //获取book标签中的price元素对象
            Element price = book.element("price");
            //通过getText()方法获取起始标签和结束标签中的文本内容
            System.out.println("书名：" + name.getText() + "\n" + "作者：" + author.getText() + "\n" + "价格：" + price.getText());
        }

    }
}
