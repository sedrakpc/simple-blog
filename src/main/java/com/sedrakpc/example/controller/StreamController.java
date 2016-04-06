package com.sedrakpc.example.controller;

import com.sedrakpc.example.common.FileStorageService;
import com.sedrakpc.example.dao.DataStoreDao;
import com.sedrakpc.example.domain.DataStore;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/6/16
 * Time: 6:41 PM
 */
@Controller
public class StreamController {

    @Autowired
    DataStoreDao dataStoreDao;

    @Autowired
    FileStorageService fileStorageService;

    @RequestMapping(value = "/getFile", method = RequestMethod.GET)
    public void getDocument(HttpServletRequest request, HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String fileId = request.getParameter("id");
            DataStore dataStore = dataStoreDao.findById(fileId);
            if(dataStore != null) {
                response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "filename*=UTF-8''" + URLEncoder.encode(dataStore.getName(), "UTF-8"));
                response.setHeader("X-FRAME-OPTIONS", "SAMEORIGIN");
                response.setHeader(HttpHeaders.CACHE_CONTROL, "max-age=31556926");
                response.setContentType(dataStore.getContentType());
                byte[] file = fileStorageService.getFile(dataStore.getUrl());
                if (file != null) {
                    inputStream = new ByteArrayInputStream(file);
                    outputStream = response.getOutputStream();
                    IOUtils.copy(inputStream, outputStream);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }
    }
}
