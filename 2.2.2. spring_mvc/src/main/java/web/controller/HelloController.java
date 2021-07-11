package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.DAO;
import web.dao.HibernateDAO;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    private DAO dao = new HibernateDAO();

    @Autowired
    public HelloController(DAO dao) {
        this.dao = dao;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }
    @GetMapping("/people")
	public String index(Model model){
    	model.addAttribute("people",dao.getAllUsers());
    	return "view/index";
	}
    @GetMapping("/people/new")
    private String newPerson (Model model){
    	model.addAttribute("newPerson",new User());
    	return "views/people/new";
	}
    @ModelAttribute("newUser") //на проверки
    public User getPerson(){
        return new User();
    }
    @PostMapping("/people")
    public String creat(@ModelAttribute("user") User user, Model model) {
    	dao.saveUser(user);
    	return "redirect:/people";
    }
    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable("id") int id){
        dao.removeUserById(id);
        return "redirect:/people";
    }
}