package com.topaidi.service.interfaces;

import java.util.List;

import com.topaidi.model.Note;

public interface NoteService extends GenericService<Note,Integer> {
	List<Note> findAllTopByIdea(int idIdea);
	List<Note> findAllFlopByIdea(int idIdea);
}
