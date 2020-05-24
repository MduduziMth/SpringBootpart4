package controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springbootpart3.User;
import springbootpart3.UserService;

import javax.lang.model.element.Name;

@RequestMapping("/api/")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/Repos")
    public ResponseEntity<String> listRepos()
    {
        RestTemplate restTemplate = new RestTemplate();
        String userResourceUrl = "https://api.github.com/users/MduduziMth/repos";
        ResponseEntity<String> response = restTemplate.getForEntity(userResourceUrl,String.class);
        System.out.println(response);
        return response;
    }

    @GetMapping("/Repos/Commits")
    public ResponseEntity<String> Commits()
    {
        RestTemplate restTemplate = new RestTemplate();
        String userResourceUrl = "https://api.github.com/repos/MduduziMth/SpringBootpart3/commits";
        ResponseEntity<String> response = restTemplate.getForEntity(userResourceUrl,String.class);
        System.out.println(response);
        return response;
    }



    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/id")
    public String removeUser(@PathVariable long id){
        return userService.removeUser(id);
    }


    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user.getId(),user.getName(),user.getSurname());
    }


}
