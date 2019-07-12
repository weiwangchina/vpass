package com.isstech.vpass.tools;

import java.io.*;

public class RequestXML {
    public static String getXMLRequest(String fileName) {
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "requestFile" + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileRead = null;
        BufferedReader bufferReader = null;
        StringBuilder contextBuffer = new StringBuilder();
        try {
            fileRead = new FileReader(file);
            bufferReader = new BufferedReader(fileRead);
            String context = "";
            while (null != (context = bufferReader.readLine())) {
                contextBuffer.append(context).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contextBuffer.toString();
    }
}
