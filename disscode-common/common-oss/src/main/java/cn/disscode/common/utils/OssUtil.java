package cn.disscode.common.utils;

import cn.disscode.common.properties.OssProperties;
import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class OssUtil {

    @Autowired
    private OSSClient ossClient;

    @Autowired
    private OssProperties ossProperties;

    public String upload(MultipartFile file) throws IOException {
        String fileName = getFileName(file.getOriginalFilename());

        ossClient.putObject(ossProperties.getBucket(), ossProperties.getDir(), file.getInputStream());
        ossClient.shutdown();
        return fileName;
    }

    private String getFileName(String fileName) {
        if (fileName != null) {
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            return System.currentTimeMillis()+ "." + suffix;
        } else {
            return "";
        }
    }
}
