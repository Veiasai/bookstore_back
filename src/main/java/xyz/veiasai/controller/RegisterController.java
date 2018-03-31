package xyz.veiasai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.pojo.User;
import xyz.veiasai.server.RegisterResult;
import xyz.veiasai.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    @ResponseBody
    public RegisterResult register(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception {
        RegisterResult registerResult = new RegisterResult();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                registerResult.addMessage(fieldError.getDefaultMessage());
            }
            registerResult.setCode(400);
            return registerResult;
        }

        user.setLevel(0);
        user.setValid(true);
        if (userService.add(user)) {
            registerResult.setUser(user);
            registerResult.setCode(200);
        } else {
            registerResult.addMessage("this email has existed");
            registerResult.setCode(403);
        }
        return registerResult;
    }
}
