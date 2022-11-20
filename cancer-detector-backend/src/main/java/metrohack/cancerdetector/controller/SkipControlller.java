package metrohack.cancerdetector.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("skip")
public class SkipControlller {
    public String index(){
        return "index";
    }
}
