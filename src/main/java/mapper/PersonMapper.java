package mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import entity.*;
@Repository
public interface PersonMapper {

	public List<Person> getPerson();
	
	public void addPerson(Person person);
	
	public void deletePerson(String username);
}
