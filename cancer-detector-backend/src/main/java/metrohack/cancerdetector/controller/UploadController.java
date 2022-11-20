package metrohack.cancerdetector.controller;


import metrohack.cancerdetector.entity.Jsonfy;
import metrohack.cancerdetector.utils.UploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Controller
@RequestMapping("upload")
public class UploadController {


    @RequestMapping("image")
    @ResponseBody
    public Jsonfy uploadImage(@RequestParam(value="file") MultipartFile multipartFile){
        String imagePath= UploadUtils.upload(multipartFile);
        Jsonfy jsonfy = new Jsonfy();
        if(imagePath!=null){
            jsonfy.setCode(103);
            jsonfy.setMsg("Upload success");
            HashMap<String, String> stringHashMap = new HashMap<>();
            stringHashMap.put("src",imagePath);
            jsonfy.setData(stringHashMap);

        }else{
            jsonfy.setCode(104);
            jsonfy.setMsg("Upload fail");
        }
        return jsonfy;
    }
    @RequestMapping("detector")
    @ResponseBody
    public void uploadImage(String imagePath){

    };
}
