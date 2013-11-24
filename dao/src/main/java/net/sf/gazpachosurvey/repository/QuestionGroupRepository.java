package net.sf.gazpachosurvey.repository;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface QuestionGroupRepository extends
		GenericRepository<QuestionGroup> {
	@Query("select qg from Survey s join s.questionGroups qg where s.id = :survey order by index(qg)")
	List<QuestionGroup> findBySurveyId(@Param("survey") Integer surveyId);
}