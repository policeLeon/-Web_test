package controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping(value = "/file")
public class UploadController {
    @RequestMapping(value = "/deleteCourse")
    public String deleteCourse(){
        return "deleteCourse";
    }


    @RequestMapping(value = "/mvc/upload")
    public String upload(HttpServletRequest request, MultipartFile upload) throws Exception {
        //先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("C:/Users/LJC/Desktop/cover");

        //获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        //获取文件后缀
        String extName = StringUtils.getFilenameExtension(filename);

        //随机给上传的文件取名字
        String newFileName = UUID.randomUUID().toString();

        //上传文件
        upload.transferTo(new File(path, newFileName+"."+extName));

        return "deleteCourse";
    }
}