package pe.edu.upc.moderneducation.dao;

import java.util.List;




import pe.edu.upc.moderneducation.models.entities.Chapter;
import pe.edu.upc.moderneducation.models.entities.Course;
import pe.edu.upc.moderneducation.models.entities.Teacher;

public interface IChapterDao {
	public void insert(Chapter chap);
	public List<Chapter>list();
	public void delete(int idChapter);
	public List<Chapter> findByCourse(Integer course);
}
