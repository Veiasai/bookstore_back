package xyz.veiasai.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.pojo.LoginUser;
import xyz.veiasai.hibernate.pojo.User;
import xyz.veiasai.hibernate.result.Result;
import xyz.veiasai.hibernate.result.UserResult;
import xyz.veiasai.hibernate.service.UserService;
import xyz.veiasai.util.MyValidator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Result Login(@RequestBody @Valid LoginUser loginUser, BindingResult bindingResult, HttpSession httpSession) throws Exception {
        UserResult userResult = new UserResult();
        Integer id = (Integer) httpSession.getAttribute("userID");
        if (id != null) //has logged in
        {
            userResult.setCode(200);
            userResult.setUser(userService.findById(id));
            return userResult;
        } else if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, userResult);
        }

        User user = userService.login(loginUser.getEmail(), loginUser.getPassword());
        if (user != null) {
            httpSession.setAttribute("userID", user.getId());
            userResult.setUser(user);
            userResult.setCode(200);
        } else {
            userResult.addMessage("incorrect email or password");
            userResult.setCode(403);
        }
        return userResult;
    }


    @RequestMapping(value = "/logout")
    @ResponseBody
    public Result Logout(HttpSession httpSession) throws Exception {
        Result userResult = new UserResult();
        Integer id = (Integer) httpSession.getAttribute("userID");
        if (id != null) //has logged in
        {
            httpSession.invalidate();
            userResult.setCode(200);
            userResult.addMessage("log out success");
            return userResult;
        }
        userResult.setCode(403);
        userResult.addMessage("No session");
        return userResult;
    }
}