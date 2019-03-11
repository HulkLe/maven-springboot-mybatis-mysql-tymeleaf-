package controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class GetController {
	
	@Autowired
    private PersonMapper personMapper;
    @Autowired
    private DiaryMapper diarymapper;
    
	@RequestMapping("/")
	public String index(Model model){
	     return "login";
	}
	
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage()
	{
		 return "mypage";
	}
	
	@RequestMapping(value="/sign",method=RequestMethod.GET)
	public String getsign()
	{
		 return "sign";
	}
	
	@RequestMapping(value="/writeDiary",method=RequestMethod.GET)
	public String addDiary(Model model,HttpServletRequest request)
	{
		 Person person=(Person) request.getSession().getAttribute("person");
		 model.addAttribute("person",person);
		 return "writediary";
	}
	
	@RequestMapping(value="/writeSlogan",method=RequestMethod.GET)
	public String addSlogan(Model model,HttpServletRequest request)
	{
		 Person person=(Person) request.getSession().getAttribute("person");
		 model.addAttribute("person",person);
		 return "writeslogan";
	}
	
	@RequestMapping(value="/exit",method=RequestMethod.GET)
	public String exit(HttpServletRequest request) 
	{
		request.getSession().removeAttribute("person");
		request.getSession().removeAttribute("diarylist");
		return "login";
	}
	
	@RequestMapping(value="/getmainpage",method=RequestMethod.GET)
	public String getmainpage(Model model,HttpServletRequest request){//第一个model接受前页面,第二个传送后页面
		
		model.addAttribute("person",request.getSession().getAttribute("person"));
		List<Diary> diarylist=diarymapper.getAllDiary();
        model.addAttribute("diarylist",diarylist);
        return "mainpage";
	}
   
	@RequestMapping(value="/getmypage",method=RequestMethod.GET)
	public String getmypage(Model model,HttpServletRequest request){//第一个model接受前页面,第二个传送后页面
		
		Person person=(Person) request.getSession().getAttribute("person");
		List<Diary> diarylist=diarymapper.getDiary(person.getUsername());
        model.addAttribute("diarylist",diarylist);
        model.addAttribute("person",request.getSession().getAttribute("person"));
        return "mypage";
	}
	
}
