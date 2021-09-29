package by.it.academy.example.tomcat;

import java.io.*;

public class Count {

    public synchronized void AddCount() {
        if(ReadCountServlet1()<0){
            WriteCountServlet1(0);
        }WriteCountServlet1(ReadCountServlet1()+1);
    }

    private synchronized void WriteCountServlet1(int number) {
        try (FileOutputStream writer = new FileOutputStream("count-file/counter-servlet-1.txt")) {
            byte[] buffer = String.valueOf(number).getBytes();
            writer.write(buffer,0,buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized int ReadCountServlet1() {
        int readerInt;
        StringBuilder stringBuffer = new StringBuilder();
        try (FileInputStream reader = new FileInputStream("count-file/counter-servlet-1.txt")) {
            while ((readerInt = reader.read()) != -1) {
                stringBuffer.append((char) readerInt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(String.valueOf(stringBuffer));
    }

    private synchronized int ReadCountServlet2() {
        int readerInt;
        StringBuilder stringBuffer = new StringBuilder();
        try (FileInputStream reader = new FileInputStream("count-file/counter-servlet-2.txt")) {
            while ((readerInt = reader.read()) != -1) {
                stringBuffer.append((char) readerInt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(String.valueOf(stringBuffer));
    }

    public synchronized int SumCountServlet1AndServlet2(){
        return ReadCountServlet1()+ReadCountServlet2();
    }

}



