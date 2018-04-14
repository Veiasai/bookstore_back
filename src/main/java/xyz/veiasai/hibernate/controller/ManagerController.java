package xyz.veiasai.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.pojo.User;
import xyz.veiasai.hibernate.result.Result;
import xyz.veiasai.hibernate.result.UserResult;
import xyz.veiasai.hibernate.service.UserService;
import xyz.veiasai.util.MyValidator;
import xyz.veiasai.util.groups.update;

@Controller
@RequestMapping(value="/manager")
public class ManagerController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/postuser")
    @ResponseBody
    public Result updateUser(@RequestBody @Validated({update.class}) User user, BindingResult bindingResult) throws Exception {
        UserResult userResult = new UserResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, userResult);
        }
        if (userService.update(user)) {
            userResult.setUser(user);
            userResult.setCode(200);
        } else {
            userResult.addMessage("this email doesn't exist");
            userResult.setCode(400);
        }
        return userResult;
    }

    @RequestMapping(value = "/deleteuser")
    @ResponseBody
    public Result deleteUser(@RequestBody @Validated User user, BindingResult bindingResult) throws Exception {
        UserResult userResult = new UserResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, userResult);
        }

        if (userService.delete(user)) {
            userResult.setUser(user);
            userResult.setCode(200);
        } else {
            userResult.addMessage("this email doesn't exist");
            userResult.setCode(400);
        }
        return userResult;
    }

    @RequestMapping(value = "/getuser")
    @ResponseBody
    public Result getUser() throws Exception {
        UserResult userResult = new UserResult();
        userResult.setUsers(userService.findAll());
        userResult.setCode(200);
        return userResult;
    }
}
