package pe.edu.upc.moderneducation.service;

import pe.edu.upc.moderneducation.models.entities.Teacher;

public interface ITeacherService {
	public void insert(Teacher te);
	public Teacher findById(Integer id);
	public void update(Teacher te);
}
