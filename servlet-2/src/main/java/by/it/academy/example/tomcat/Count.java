package by.it.academy.example.tomcat;

import java.io.*;

public class Count{

    public synchronized void AddGetCount() {
        if(ReadGetCountServlet2()<0){
            WriteGetCountServlet2(0);
        }WriteGetCountServlet2(ReadGetCountServlet2()+1);
    }

    public synchronized void AddPostCount() {
        if(ReadPostCountServlet2()<0){
            WritePostCountServlet2(0);
        }WritePostCountServlet2(ReadPostCountServlet2()+1);
    }

    private synchronized void WriteGetCountServlet2(int number) {
        try (FileOutputStream writer = new FileOutputStream("count-file/counter-servlet-2-Get.txt")) {
            byte[] buffer = String.valueOf(number).getBytes();
            writer.write(buffer,0,buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void WritePostCountServlet2(int number) {
        try (FileOutputStream writer = new FileOutputStream("count-file/counter-servlet-2-Post.txt")) {
            byte[] buffer = String.valueOf(number).getBytes();
            writer.write(buffer,0,buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized int ReadGetCountServlet2() {
        int readerInt;
        StringBuilder stringBuffer = new StringBuilder();
        try (FileInputStream reader = new FileInputStream("count-file/counter-servlet-2-Get.txt")) {
            while ((readerInt = reader.read()) != -1) {
                stringBuffer.append((char) readerInt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(String.valueOf(stringBuffer));
    }

    public synchronized int ReadPostCountServlet2() {
        int readerInt;
        StringBuilder stringBuffer = new StringBuilder();
        try (FileInputStream reader = new FileInputStream("count-file/counter-servlet-2-Post.txt")) {
            while ((readerInt = reader.read()) != -1) {
                stringBuffer.append((char) readerInt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(String.valueOf(stringBuffer));
    }


}



