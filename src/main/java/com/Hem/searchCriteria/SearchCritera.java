package com.hemanth.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchCritera {

	private static final String delim = ";";
	

	private List<Criterion> criterias = new ArrayList<>();

	private SearchCritera() {
	}

	public static SearchCritera build(String search) throws SearchCriteraLangException{
		SearchCritera critera = new SearchCritera();
		String[] values = search.split(delim);
		
		//Decrative
		Arrays
		.stream(values)
		.forEach(value -> critera.criterias.add(Criterion.build(value)));
		
		/*
		 * //imarative for(int i = 0 ; i < values.length ; i++) { Criterion criterion =
		 * Criterion.build(values[i]); critera.criterias.add(criterion); }
		 */
		
		
		return critera;
	}

	public List<Criterion> getCriterias() {
		return criterias;
	}
	

	@Override
	public String toString() {
		return "SearchCritera [criterias=" + criterias + "]";
	}

	
}
