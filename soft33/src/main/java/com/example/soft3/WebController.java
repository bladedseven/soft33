package com.example.soft3;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.UUID;
import org.springframework.http.HttpHeaders; //导入方法依赖的package包/类

import static org.springframework.util.StringUtils.getFilename;

@Controller
public class WebController {
    @GetMapping("/toupload")
    public String toupload() {
        return  "upload";
    }
    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model){
        model.addAttribute("uploadStatus", "上传成功");
        for (MultipartFile file:fileUpload) {
            String fileName = file.getOriginalFilename();
            fileName = UUID.randomUUID() + "_" + fileName;
            String dirPath = "D:/javaProjects/";
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("", "上传失败: " + e.getMessage());
            }
        }
        return  "upload";
    }
//    @GetMapping("/todownload")
//    public String todownload() {
//        return "download";
//    }
//    @GetMapping("/download")
//    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String filename) throws Exception {
//        String dirPath = "D:/javaProject/";
//        File file = new File(dirPath + File.separator + filename);
//        HttpHeaders headers = new HttpHeaders();
//        filename = getFilename(request, filename);
//        headers.setContentDispositionFormData("attachment", filename);
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        try{
//            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
//        }
//    }
//
//    private String getFilename(HttpServletRequest request, String filename) throws Exception{
//    //    IE不同版本User-Agent中出现的关键字
//        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
////        获取请求头的代理信息
//        String userAgent = request.getHeader("User-Agent");
//        for (String keyWord : IEBrowserKeyWords){
//            if (userAgent.contains(keyWord)){
////                IE内核浏览器，统一为UTF-8编码显示
//                return URLEncoder.encode(filename, "UTF-8").replace("+", "");
//            }
//        }
////        火狐等其它浏览器统一为ISO-8859-1编码显示
//        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
//    }
}
