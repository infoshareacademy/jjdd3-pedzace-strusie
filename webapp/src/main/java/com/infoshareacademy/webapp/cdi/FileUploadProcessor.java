package com.infoshareacademy.webapp.cdi;


import com.infoshareacademy.webapp.exceptions.UserImageNotFound;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public interface FileUploadProcessor {
    File uploadImageFile(Part file) throws IOException, UserImageNotFound;

    String getUploadImageFilesPath() throws IOException;
}
