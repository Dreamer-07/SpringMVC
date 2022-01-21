package pers.prover07.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @author by Prover07
 * @classname FileController
 * @description TODO
 * @date 2022/1/19 21:26
 */
@Controller
public class FileController {

    @GetMapping("/fileDown")
    public ResponseEntity<byte[]> fileDown(HttpSession session) throws IOException {
        // 获取文件所在路径
        String filePath = session.getServletContext().getRealPath("/static/images/travel.png");
        // 创建输入流
        FileInputStream fis = new FileInputStream(filePath);
        // 创建字节数组，大小为文件大小
        byte[] bytes = new byte[fis.available()];
        // 将流数据读取到数组中
        fis.read(bytes);

        // 创建 HttpHeaders 设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        // 设置下载文件的方式和名字
        headers.add("Content-Disposition", "attachment;filename=travel.png");
        //创建 ResponseEntity 对象
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    @PostMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(MultipartFile photo, HttpSession session) throws IOException {
        // 获取源文件名
        String originalFilename = photo.getOriginalFilename();
        // 获取保存图片文件夹路径
        String photoPath = session.getServletContext().getRealPath("photo");
        // 判断文件夹是否存在，如果不存在就创建对应的目录
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        // 获取文件后缀并使用 UUID 随机生成一个文件名保证文件名不重复
        String filename = UUID.randomUUID().toString().replaceAll("-","") + originalFilename.substring(originalFilename.lastIndexOf("."));
        // 设置图片路径
        String finalPath = photoPath + File.separator + filename;
        // 保存图片
        photo.transferTo(new File(finalPath));
        return "success";
    }

}
