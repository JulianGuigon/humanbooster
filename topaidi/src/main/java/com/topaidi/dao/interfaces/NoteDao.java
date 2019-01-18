package com.topaidi.dao.interfaces;

import java.util.List;

import com.topaidi.model.Note;

public interface NoteDao extends GenericDao<Note,Integer>{
	List<Note> findAllTopByIdea(int idIdea);
	List<Note> findAllFlopByIdea(int idIdea);
}
