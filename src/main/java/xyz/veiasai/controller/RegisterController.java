package xyz.veiasai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.pojo.User;
import xyz.veiasai.server.Mask;
import xyz.veiasai.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public Mask register(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception {
        Mask mask = new Mask();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                mask.addMessage(fieldError.getDefaultMessage());
            }
            mask.setUser(null);
            mask.setCode(400);
            return mask;
        }

        user.setLevel(0);
        user.setValid(true);
        userService.add(user);
        mask.setUser(user);
        mask.setCode(200);
        return mask;
    }
}
