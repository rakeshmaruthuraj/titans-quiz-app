package com.titans.quiz.titansquizapp.DAO;

import com.titans.quiz.titansquizapp.TableClass.QuestionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface QuestionTableRepository extends JpaRepository<QuestionTable, Long> {

}
