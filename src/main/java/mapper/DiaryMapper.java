package mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import entity.Diary;


@Repository
public interface DiaryMapper{
	
	
	@Select("select * from diary where username=#{username} order by datetime desc")
    public List<Diary> getDiary(@Param("username")String username);
    
	@Select("select * from diary order by datetime desc")
    public List<Diary> getAllDiary();
	
    @Insert({"insert into diary(id,username,datetime,content)values(null,#{username},#{datetime},#{content})"})
    public void addDiary(Diary diary);
	
    @Delete("delete from diary where datetime=#{datetime}")
   	public void deleteDiary(@Param("datetime")String datetime);
}
