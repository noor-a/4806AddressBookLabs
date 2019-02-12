package application;/*package application;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class BuddyService {

    BuddyInfoRepository repo;

    public String greet(){
        return "Hello";
    }

    public @ResponseBody
    String buddyName(){
        List<BuddyInfo> buddies = repo.findAll();
        String str = "";
        if(buddies.isEmpty()){
            str = "Hello World";
        }else{
            while(buddies.iterator().hasNext()){
                str += ""+buddies.iterator().next().getName();
            }
        }
        return str;
    }
}*/