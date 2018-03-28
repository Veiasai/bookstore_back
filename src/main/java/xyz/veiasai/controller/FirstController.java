package xyz.veiasai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/222")
public class FirstController {
    @RequestMapping(value = "/first")
    @ResponseBody
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "index";
    }

}
