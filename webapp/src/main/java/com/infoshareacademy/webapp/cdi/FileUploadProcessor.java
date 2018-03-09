package com.infoshareacademy.webapp.cdi;


import com.infoshareacademy.webapp.exceptions.UserFileNotFound;
import com.infoshareacademy.webapp.exceptions.UserImageNotFound;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public interface FileUploadProcessor {
    File uploadFinanceSourceFile(Part file) throws IOException, UserFileNotFound;

    String getUploadFinanceFilesPath() throws IOException;
}
