package edu.miu.cs.cs425.studentmgmt.controller;


import edu.miu.cs.cs425.studentmgmt.model.ClassRoom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/secured/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
//    @GetMapping(value = "/list")
//    public ModelAndView listStudents(@RequestParam(defaultValue = "0") int pageNo){
//        var modelAndView = new ModelAndView();
//        var students = studentService.getAllStudentsPaged(pageNo);
//        modelAndView.addObject("students", students);
//        modelAndView.addObject("currentPageNO", pageNo);
//        modelAndView.setViewName("secured/student/list");
//        return modelAndView;
//    }

        @GetMapping(value = "/list")
    public ModelAndView listAllStudents() {
        var modelAndView = new ModelAndView();
        var students = studentService.getAllStudent();
        modelAndView.addObject("students", students);
        modelAndView.addObject("publishersCount", ((List)students).size());
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public ModelAndView displayNewStudentForm() {
        ModelAndView newModel = new ModelAndView();
        newModel.addObject("student", new Student());
        newModel.setViewName("secured/student/new");
        return newModel;
    }

    @PostMapping(value = "/new")
    public String registerNewStudent (@Valid @ModelAttribute("student") Student student,
                                      BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/new";
        }

        studentService.addNewStudent(student);
        return "redirect:/secured/student/list";
    }

    @GetMapping("/edit")
    public ModelAndView showUpdateForm(@RequestParam Long studentId) {
        ModelAndView mav = new ModelAndView();
        Student student = studentService.getStudentById(studentId).get();
        mav.addObject("student", student);
        mav.setViewName("/secured/student/new");
        return mav;
    }

    @GetMapping(value = {"/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        model.addAttribute("student", studentService.getStudentById(studentId));
        var student = studentService.getStudentById(studentId).get();
            return "secured/student/edit";

    }

    @PostMapping(value = {"/update"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/edit";
        }
        studentService.updateStudent(student);
        return "redirect:/secured/student/list";
    }

    @GetMapping(value = {"/delete"})
    public String deleteStudent(@RequestParam  Long studentId) {
        studentService.deleteStudentById(studentId);
        System.out.println("hello");
        return "redirect:/secured/student/list";
    }


}
