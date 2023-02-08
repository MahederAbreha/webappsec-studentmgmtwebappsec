package edu.miu.cs.cs425.studentmgmt.controller;


import ch.qos.logback.core.model.Model;
import edu.miu.cs.cs425.studentmgmt.model.User;
import edu.miu.cs.cs425.studentmgmt.service.RoleService;
import edu.miu.cs.cs425.studentmgmt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/secured/student")
public class UserMgmtController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserMgmtController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/list")
    public ModelAndView displayUsersList() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("users", userService.getAllUsers());
//        mav.addObject("users", new ArrayList<User>()); // to test empty list
        mav.setViewName("secured/student/list");
        return mav;
    }

    @GetMapping(value ="/new")
    public ModelAndView displayNewUserForm() {
        ModelAndView mav = new ModelAndView();
        User user = new User();
        mav.addObject("user", user);
        mav.addObject("roles", roleService.getAllRoles());
        mav.setViewName("secured/student/new");
        return mav;
    }


}
