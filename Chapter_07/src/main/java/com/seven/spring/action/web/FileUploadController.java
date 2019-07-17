/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	FileUploadController.java
 * 模块说明：
 * 修改历史：
 * 2019/4/14 - seven - 创建。
 */
package com.seven.spring.action.web;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author seven
 */
@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

  @RequestMapping(method = RequestMethod.POST)
  public String processUpload(@RequestPart("file") MultipartFile file) throws IOException {
    System.out.println(file.getSize());
    //在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹
    //获取图片名称
    String fileName = file.getOriginalFilename();
    //获取图片扩展名
    String ext = FilenameUtils.getExtension(file.getOriginalFilename());
    String direct = "D:/spring/spring-action/Chapter_07/src/main/webapp/resources";
    file.transferTo(new File(direct + "/" + fileName + "." + ext));
    return "redirect:/";
  }
}
