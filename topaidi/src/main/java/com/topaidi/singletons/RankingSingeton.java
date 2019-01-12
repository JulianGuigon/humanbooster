package com.topaidi.singletons;

import java.util.List;

import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;

public class RankingSingeton {
	private static RankingSingeton singleton; //static important pour avoir une seule instance

	public static RankingSingeton getInstance() {
		if (singleton == null) {
			singleton = new RankingSingeton();
		}
		return singleton;
	}
	
	public List<User> getBrainRanking(){
		throw new UnsupportedOperationException();
	}
	
	public List<Idea> getBuzzRanking(){
		throw new UnsupportedOperationException();
	}
	
	public List<Idea> getTopRanking(){
		throw new UnsupportedOperationException();
	}
}
