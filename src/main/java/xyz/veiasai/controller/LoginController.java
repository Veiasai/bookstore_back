package xyz.veiasai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.pojo.LoginUser;
import xyz.veiasai.pojo.User;
import xyz.veiasai.server.LoginResult;
import xyz.veiasai.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public LoginResult Login(@RequestBody @Valid LoginUser loginUser, BindingResult bindingResult, HttpSession httpSession) throws Exception {
        LoginResult loginResult = new LoginResult();
        String email = (String) httpSession.getAttribute("userEmail");
        if (email != null) //has logged in
        {
            loginResult.setCode(200);
            loginResult.setUser(userService.findByEmail(email));
            return loginResult;
        }
        else if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                loginResult.addMessage(fieldError.getDefaultMessage());
            }
            loginResult.setCode(400);
            return loginResult;
        }

        User user = userService.login(loginUser.getEmail(), loginUser.getPassword());
        if (user != null) {
            httpSession.setAttribute("userEmail", user.getEmail());
            loginResult.setUser(user);
            loginResult.setCode(200);
        } else {
            loginResult.addMessage("incorrect email or password");
            loginResult.setCode(400);
        }
        return loginResult;
    }
}