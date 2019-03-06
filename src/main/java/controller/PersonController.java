package controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entity.Person;
import mapper.PersonMapper;


@Controller
public class PersonController {
	
    @Autowired
    private PersonMapper personMapper;
	
	//显示用户
	@RequestMapping("/")
	public String index(Model model){
        System.out.println("index");
        //model.addAttribute("name","yuanfei");
        return "login";
    }

	@RequestMapping("/login")
	public String login(@ModelAttribute("person") Person person,Model model,HttpServletRequest request){
        System.out.println("login:"+person.getUsername());
        model.addAttribute("person",person);
        request.getSession().setAttribute("person", person);
        return "mypage";
    }
	
	@RequestMapping(value="/sign",method=RequestMethod.GET)
	public String signget(Model model)
	{
		System.out.println("signget");
		return "sign";
	}
	
	@RequestMapping(value="/sign",method=RequestMethod.POST)
	
	public String signpost(@ModelAttribute("person")Person person)
	{
		System.out.println("signpost"+person.getUsername());
		
		personMapper.addPerson(person);
		//personService.addPerson(person);
		System.out.println("signpost2"+person.getUsername());
		return "mypage";
	}
	
	
    @RequestMapping("/list")
    public List<Person> index() throws Exception {
        return personMapper.getPerson();
    }
	
    //删除用户
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable String username) throws Exception {
    	personMapper.deletePerson(username);
        return "你已经删掉了"+username+"用户";
    }

}
