package com.sunpeifu.geektime.file;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/13
 * 描述:  文件读取测试
 */
public class FileTest {

    public FileTest() {

    }

    public static void main(String[] args) throws Exception {
        //readInputStream();
        //fileReader();
        //readAndWriteByLine();
        readAndWriteBybytes();
    }



    /***
     * 字节方式读取和写入通过读一行,注意不同的系统中的换行
     */
    public static void readAndWriteByLine() throws IOException {
        ClassPathResource resource = new ClassPathResource("我是纯文本.txt");
        File sourceFile = resource.getFile();
        FileReader fileReader = new FileReader(sourceFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        File outFile = new ClassPathResource("写入文档txt").getFile();
        outFile.createNewFile();
        String content = null;
        FileWriter fileWriter = new FileWriter(outFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while ((content = bufferedReader.readLine()) != null) {
            System.out.println("进入了循环");
            // mac中 \n是换行 win是\r\n是换行  linux中\r是换行
            bufferedWriter.write(content+"\n");
        }
        bufferedWriter.close();
    }
    /***
     * 字节方式读取和写入
     */
    public static void readAndWriteBybytes() throws IOException {
        ClassPathResource resource = new ClassPathResource("我是纯文本.txt");
        File file = resource.getFile();
        byte[] bytes = new byte[1024];
        int len;
        // 使用try resource的方式,自动释放资源,无需再finally中close
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            // 创建输出流
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            File outFile = new File("newFile.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        }


    }

    /***
     * 使用字节的方式读取
     */
    public static void readInputStream() throws IOException {
        ClassPathResource resource = new ClassPathResource("我是纯文本.txt");
        File file = resource.getFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024];
        int len;
        String content;
        while ((len = fileInputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            sb.append(s);
        }
        System.out.println(sb.toString());
    }


    /***
     * 使用字符读取
     */
    public static void fileReader() throws IOException {
        ClassPathResource resource = new ClassPathResource("我是纯文本.txt");
        File file = resource.getFile();
        // FileReader 是以字符的方式进行读取   如果之前的编码是GBK  我们这里是UTF8 则会出现乱码
        FileReader fileReader = new FileReader(file);
        char[] chars = new char[1024];
        StringBuilder sb = new StringBuilder();
        String content = "";
        int len;
        while ((len = fileReader.read(chars)) != -1) {
            String s = new String(chars, 0, len);
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}