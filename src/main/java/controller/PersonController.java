package controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entity.Diary;
import entity.Person;
import mapper.DiaryMapper;
import mapper.PersonMapper;

@Controller
public class PersonController {
	
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private DiaryMapper diarymapper;
    

	@RequestMapping(value="/mypage",method=RequestMethod.POST)
	public String login(@ModelAttribute("person") Person person,Model model,HttpServletRequest request){//第一个model接受前页面,第二个传送后页面
		
		Person t=personMapper.getPersonByUsername(person.getUsername());
		
		if(t.getPassword().equals(person.getPassword())) {//登陆验证
       
			if(t.getSlogan()==null)
            t.setSlogan("无");
		   
            request.getSession().setAttribute("person",t);
            model.addAttribute("person",t);
            
            List<Diary> diarylist=diarymapper.getDiary(person.getUsername());
            model.addAttribute("diarylist",diarylist);
        
            return "mypage";
		}
        
        return "login";
    }
	
	
	@RequestMapping(value="/sign",method=RequestMethod.POST)
	public String sign(@ModelAttribute("person")Person person,Model model,HttpServletRequest request)
	{
		 person.setSlogan("无");
		 personMapper.addPerson(person);
		 request.getSession().setAttribute("person",person);
		 List<Diary> diarylist=diarymapper.getDiary(person.getUsername());
         model.addAttribute("diarylist",diarylist);
		 return "mypage";
	}
	
	@RequestMapping(value="/addDiary",method=RequestMethod.POST)
	public String sign(@ModelAttribute("diary")Diary diary,Model model,HttpServletRequest request) 
	{
		
		diary.setDatetime(DateTime.now().toString("yyyyMMddhhmmss"));
		Person person=(Person) request.getSession().getAttribute("person");
		diary.setUsername(person.getUsername());

		diarymapper.addDiary(diary);
		model.addAttribute("person",person);
		
		List<Diary> diarylist=diarymapper.getDiary(person.getUsername());
		model.addAttribute("diarylist",diarylist);
		
		return "mypage";
	}
	
	
	@RequestMapping(value="/addSlogan",method=RequestMethod.POST)
	public String addSlogan(@ModelAttribute("content")String content,Model model,HttpServletRequest request) 
	{
		
		Person person=(Person) request.getSession().getAttribute("person");
		person.setSlogan(content);
		request.getSession().setAttribute("person", person);
		personMapper.updatePerson(person);
		
		model.addAttribute("person",person);
		
		List<Diary> diarylist=diarymapper.getDiary(person.getUsername());
		model.addAttribute("diarylist",diarylist);
		
		return "mypage";
	}

}
