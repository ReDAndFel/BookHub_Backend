package app.services.implementations;

import app.services.interfaces.FileInterface;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.cloudinary.Cloudinary;
@Service
public class FileImpl implements FileInterface {
    private final Cloudinary cloudinary;

    public FileImpl() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dxmalxjle");
        config.put("api_key", "344671726779568");
        config.put("api_secret", "7uEjxJ8qBO39GMGtBaFYodAYCZU");
        cloudinary = new Cloudinary(config);
    }

    @Override
    public Map uploadFile(File file, String directory) throws Exception {
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", directory));
    }

    @Override
    public Map deleteFile(String idImage) throws Exception {
        return cloudinary.uploader().destroy(idImage, ObjectUtils.emptyMap());
    }

    @Override
    public File convert(MultipartFile image) throws IOException {
        File file = File.createTempFile(image.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(image.getBytes());
        fos.close();
        return file;
    }
}
