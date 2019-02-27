package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BuddyController {

    @Autowired
    BuddyInfoRepository brepo;

    @Autowired
    AddressBookRepository arepo;

    @GetMapping("/addressbook")
    public String addBuddy(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("addressbook", new AddressBook());
        //List<BuddyInfo> buddies = brepo.findAll();
        //model.addAttribute("buddies", buddies);
        return "addressbook";
    }

    @GetMapping("/")
    public String greetingForm(@ModelAttribute BuddyInfo buddyInfo, @ModelAttribute AddressBook addressBook) {
        brepo.save(buddyInfo);
        arepo.save(addressBook);
        return "addressBook";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("name") String name, Model model){
        BuddyInfo b = brepo.findByName(name).get(0);
        brepo.delete(b);
        //model.addAttribute("buddy", new BuddyInfo());
        List<BuddyInfo> buddies = brepo.findAll();
        model.addAttribute("buddies", buddies);
        return "addressbook";
    }

}
