package metrohack.cancerdetector.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {
    //upload to
    private static final String BASE_PATH="C:\\xampp\\tomcat\\webapps\\upload\\";

    //view the image throug
    private static final String SERVER_PATH="http://localhost:8080/upload/";
    public static  String upload(MultipartFile file){
        //getFilename
        String filename= file.getOriginalFilename();
        //give it a new name by UUID
        String uuid= UUID.randomUUID().toString().replace("-","");
        String newFilename=uuid+"-"+filename;
        File image=new File(BASE_PATH,newFilename);
        try {
            file.transferTo(image);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return SERVER_PATH+newFilename;
    }
}
