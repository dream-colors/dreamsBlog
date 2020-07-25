package com.dream.blog.commom.utils.fileupload;

import com.dream.blog.commom.constant.Constant;
import com.dream.blog.commom.exception.CustomException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.Objects;

/**
 * =======================
 * 类名: FileService
 * 描述：
 * 作者：dream colors
 * 日期：2020/7/21 1:09
 * 版本：1.0
 * =======================
 **/
@Service
public class FileService {
    private final Path fileStorageLocation; // 文件在本地存储的地址

    public FileService() {
        Calendar instance = Calendar.getInstance();
        String prefix = "/" + instance.get(Calendar.YEAR) + "/" + (instance.get(Calendar.MONTH) + 1) + "/" + instance.get(Calendar.DAY_OF_MONTH);
        this.fileStorageLocation = Paths.get(Constant.FILE_UPLOAD_DIR + prefix).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new CustomException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    /**
     * 存储文件到系统
     *
     * @param file 文件
     * @return 文件名
     */
    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new CustomException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new CustomException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    /**
     * 加载文件
     * @param fileName 文件名
     * @return 文件
     */
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new CustomException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new CustomException("File not found " + fileName, ex);
        }
    }
}
