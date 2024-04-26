package com.jsu.greet.controller;

import org.apache.commons.text.StringEscapeUtils;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Controller
public class UploadController {
//    private final Logger logger = Logger.getLogger("MyLog");
    private final Logger logger = Logger.getLogger("MyLog");

    // Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "/Users/jiang/t/";

    @GetMapping("/go_upload")
    public String upload() {
        return "upload";
    }

    //@RequestMapping(value = "/upload", method = RequestMethod.POST)
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("title", "upload status");
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:msg";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String filename2 = StringEscapeUtils.unescapeHtml3(file.getOriginalFilename());

            Path path = Paths.get(UPLOADED_FOLDER + filename2);
            // StandardMultipartHttpServletRequest$StandardMultipartFile
//            debug(req);
//            logger.info("file.cls: " + file.getClass().getName());
            logger.info("file.getOriginalFilename: " + file.getOriginalFilename());
            logger.info("save path: " + path);
            logger.info("logger: " + logger);

            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:msg";
    }

    @GetMapping("/msg")
    public String msg() {
        return "msg";
    }
}