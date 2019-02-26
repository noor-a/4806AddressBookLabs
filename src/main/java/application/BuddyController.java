package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BuddyController {

    @Autowired
    BuddyInfoRepository repo;

    @PostMapping("/addressbook")
    public String addBuddy(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        System.out.println("Buddy Info: " + buddyInfo.getName() + " " + buddyInfo.getAddress() + " " + buddyInfo.getPhoneNumber());
        model.addAttribute("buddy", new BuddyInfo());
        repo.save(buddyInfo);
        List<BuddyInfo> buddies = repo.findAll();
        model.addAttribute("buddies", buddies);
        return "addressbook";
    }

    @GetMapping("/addressbook")
    public String findAllBuddy(Model model){
        model.addAttribute("buddy", new BuddyInfo());
        List<BuddyInfo> buddies = repo.findAll();
        System.out.println("Size of Buddy = " + buddies.size());
        model.addAttribute("buddies", buddies);
        return "addressbook";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("name") String name, Model model){
        BuddyInfo b = repo.findByName(name).get(0);
        repo.delete(b);
        model.addAttribute("buddy", new BuddyInfo());
        List<BuddyInfo> buddies = repo.findAll();
        model.addAttribute("buddies", buddies);
        return "addressbook";
    }

}
