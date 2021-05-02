package pe.edu.upc.moderneducation.service;

import java.util.List;

import pe.edu.upc.moderneducation.models.entities.Chapter;

public interface IChapterService {
public void insert(Chapter chap);
List<Chapter> list();
public void delete(int chapter_id);
}
