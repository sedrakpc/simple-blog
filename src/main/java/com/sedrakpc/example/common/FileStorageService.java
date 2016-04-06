package com.sedrakpc.example.common;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/6/16
 * Time: 6:35 PM
 */
public class FileStorageService {

    private static final String FOLDER_DATE_FORMAT = "yyyy/MM/dd";

    @Value("${file.storage.root.path}")
    private String fileStorageRootPath;

    public String saveFile(byte[] bytes, String fileId) {
        DateFormat df = new SimpleDateFormat(FOLDER_DATE_FORMAT);
        String filePath = fileStorageRootPath + df.format(new Date()) + "/" + fileId;
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            return null;
        }
        return filePath;
    }

    public byte[] getFile(String filePath) {
        try {
            return IOUtils.toByteArray(new FileInputStream(filePath));
        } catch (IOException e) {
            return null;
        }
    }
}
