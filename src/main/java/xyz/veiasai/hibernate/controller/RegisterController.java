package xyz.veiasai.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.pojo.User;
import xyz.veiasai.hibernate.result.Result;
import xyz.veiasai.hibernate.result.UserResult;
import xyz.veiasai.hibernate.service.UserService;

import javax.validation.Valid;


@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    @ResponseBody
    public Result register(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception {
        UserResult UserResult = new UserResult();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                UserResult.addMessage(fieldError.getDefaultMessage());
            }
            UserResult.setCode(400);
            return UserResult;
        }

        user.setLevel(0);
        user.setValid(true);
        if (userService.add(user)) {
            UserResult.setUser(user);
            UserResult.setCode(200);
        } else {
            UserResult.addMessage("this email has existed");
            UserResult.setCode(403);
        }
        return UserResult;
    }
}
