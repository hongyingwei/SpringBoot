package com.smart.module.car.util;

import antlr.StringUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CarRecognitionUtils {

//    python脚本的路径
    public static String pythonScriptPath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\smart\\module\\car\\util\\CarRecognition";
    public static String plate_model_path = "./dataAndModel/model/plate_recongnize/model.ckpt-510.meta";
    public static String char_model_path = "./dataAndModel/model/char_recongnize/model.ckpt-510.meta";
    /**
     * 执行python脚本，识别车牌
     * @param imagePath
     * @return
     */
    public String recogotion(String imagePath){
        String result = null;
        try {
            // 如果Python脚本需要参数，可以在这里添加
//            String[] commands = new String[]{"python", pythonScriptPath, imagePath};

            // 使用Runtime执行Python脚本
//            Process process = Runtime.getRuntime().exec(commands);
            ProcessBuilder processBuilder = new ProcessBuilder("python", "carPlateIdentity.py",
                    imagePath, plate_model_path, char_model_path);
            processBuilder.directory(new File(pythonScriptPath)); // 设置工作目录

            Process process = processBuilder.start();
            // 读取Python脚本的输出（如果有的话）
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            result = reader.readLine();
//            while ((result = reader.readLine()) != null) {
//                System.out.println(result);
//            }

            // 等待Python脚本执行完成
            process.waitFor();

            // 获取Python脚本的退出值
            int exitCode = process.exitValue();
            System.out.println("Python script exited with code: " + exitCode);
            System.out.println("Recongition Car Plates result: " + result);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        if(result != null && !result.equals("")){
            return result;
        }
        return null;
    }
}
