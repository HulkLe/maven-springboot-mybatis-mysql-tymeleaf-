package mapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import entity.*;
@Repository
public interface PersonMapper {

	
	public List<Person> getPerson();
	
	public Person getPersonByUsername(String username);
	
	public void updatePerson(Person person);
	
	public void addPerson(Person person);
	
	public void deletePerson(String username);
}
