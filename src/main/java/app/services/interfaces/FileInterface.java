package app.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface FileInterface {
    Map uploadFile(File file, String directory) throws Exception;
    Map deleteFile(String idImage) throws Exception;
    File convert(MultipartFile image) throws IOException;
}
