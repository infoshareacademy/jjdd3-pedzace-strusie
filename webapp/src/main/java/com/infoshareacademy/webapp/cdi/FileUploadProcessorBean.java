package com.infoshareacademy.webapp.cdi;

import com.infoshareacademy.webapp.exceptions.UserFileNotFound;
import com.infoshareacademy.webapp.exceptions.UserImageNotFound;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

@RequestScoped
public class FileUploadProcessorBean implements FileUploadProcessor {

    private static final String SETTINGS_FILE = "config.properties";

    @Override
    public File uploadFinanceSourceFile(Part filePart) throws IOException, UserFileNotFound {

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if (fileName == null || fileName.isEmpty()) {
            throw new UserFileNotFound("No user finance data file has been uploaded");
        }

        File file = new File(getUploadFinanceFilesPath() + fileName);

        InputStream fileContent = filePart.getInputStream();
        OutputStream os = new FileOutputStream(file);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileContent.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        fileContent.close();
        os.flush();
        os.close();

        return file;
    }

    @Override
    public String getUploadFinanceFilesPath() throws IOException {
        Properties settings = new Properties();
        settings.load(Thread.currentThread()
                .getContextClassLoader().getResource(SETTINGS_FILE).openStream());
        return settings.getProperty("Upload.Path.Images");
    }
}
