package com.hackthefuture.PL;

import com.hackthefuture.DAL.models.Alert;
import com.hackthefuture.DAL.models.User;
import com.hackthefuture.DAL.repositories.AlertRepository;
import com.hackthefuture.DAL.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by kaisu on 30/11/2017.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AlertRepository alertRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public ModelAndView getUsers(Model model){
        model.addAttribute("users",userRepository.findAll());
        model.addAttribute("user",new User());
        return new ModelAndView("Users");
    }

    @GetMapping("/monitor")
    public ModelAndView monitor(){
        return new ModelAndView("Alert");
    }

    @GetMapping("/alerts")
    public List<Alert> getAlerts() {
        return alertRepository.findAll();
    }

    @GetMapping("/alerts/{id}")
    public Alert getAlert(@PathVariable("id") String id) {
        return alertRepository.getById(id);
    }

    /**
     * Post new user,encode password
     *
     * @param user
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/users")
    public ModelAndView updateUser(@ModelAttribute User user,
                                   final RedirectAttributes redirectAttributes) {
        if (!userRepository.findByUsername(user.username).isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "User already exits.");
            return new ModelAndView("redirect:/admin/users");
        }
            User prv_user = new User(); //prv_user: old version of uploaded user
            prv_user.copy(user);
            if (!user.getPassword().isEmpty())
                prv_user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(prv_user);
            redirectAttributes.addFlashAttribute("msg", "User created.");
            return new ModelAndView("redirect:/admin/users");
    }

    /**
     * Verander authentication details
     *
     * @param user
     * @param username
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/users/{username}")
    public ModelAndView updateUser(@ModelAttribute User user, @PathVariable("username")
            String username, RedirectAttributes redirectAttributes) {
        User prv_user = userRepository.findByUsername(username).get(0);
        if (prv_user == null) {
            redirectAttributes.addFlashAttribute("error", "User not found.");
            return new ModelAndView("redirect:/admin/users");
        } else {
            prv_user.copy(user);
            userRepository.save(prv_user);
            if (!user.getPassword().isEmpty()) {
                     prv_user.setPassword(passwordEncoder.encode(user.getPassword()));
                    userRepository.save(prv_user);
                }
            }
            return new ModelAndView("redirect:/admin/users");
    }

    /**
     * Verwijder user
     *
     * @param username
     * @param redirectAttributes
     * @return redirect:/admin/configuratie?tab=5
     */
    @RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
    public ModelAndView deleteUser(@PathVariable("username") String username,
                                   final RedirectAttributes redirectAttributes) {
        userRepository.deleteUsersByUsername(username);
        redirectAttributes.addFlashAttribute("User has been removed.");
        return new ModelAndView("redirect:/admin/users");
    }

}
