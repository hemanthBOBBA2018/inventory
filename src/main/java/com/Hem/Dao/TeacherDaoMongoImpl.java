package com.hemanth.Dao;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.hemanth.Model.Teacher;
import com.hemanth.search.Criterion;
import com.hemanth.search.SearchCritera;

@Component
public class TeacherDaoMongoImpl implements TeacherDao{
	
	@Autowired
	private MongoDao<Teacher> teacherDoa;
	

	@Override
	public
	void saveTeacherData(Teacher t)
	{
		teacherDoa.save(t);
	}


	@Override
	public Teacher GetTeacher(String id) {
		return null;
	}


	@Override
	public List<Teacher> findAllTeachers() {
		return teacherDoa.findAll(Teacher.class);
	}


	@Override
	public void updateTeacher(Teacher teacher) {
		//TODO 
		teacherDoa.save(teacher);
	}


	@Override
	public void deleteTeacher(String id) {
		// TODO
		teacherDoa.delete(id);
		
	}


	@Override
	public List<Teacher> getTeachers(SearchCritera searchCriteria) {
		List<Criteria> mongoCriteria = searchCriteria
				.getCriterias()
				.stream()
				.map(this::convert)
				.collect(Collectors.toList());
		
		return teacherDoa.getAll(mongoCriteria, Teacher.class);
	
	}

	private Criteria convert(Criterion criterion) {
		if(criterion.getOp() == Criterion.Opertation.EQ) {
			return Criteria.where(criterion.getKey()).is(criterion.getValue());
		} else if(criterion.getOp() == Criterion.Opertation.NEQ){
			return  Criteria.where(criterion.getKey()).ne(criterion.getValue());
		}
			else if(criterion.getOp() == Criterion.Opertation.GT) {
				return Criteria.where(criterion.getKey()).gt(criterion.getValue());
			}
			else if(criterion.getOp() == Criterion.Opertation.LT) {
				return Criteria.where(criterion.getKey()).lt(criterion.getValue());
			}
		
		return new Criteria();
	}
	
	
}
