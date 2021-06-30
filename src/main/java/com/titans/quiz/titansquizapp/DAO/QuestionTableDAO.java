package com.titans.quiz.titansquizapp.DAO;

import com.titans.quiz.titansquizapp.TableClass.QuestionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class QuestionTableDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<QuestionTable> getList() {
        String sql = "SELECT * FROM QUESTIONDETAILS";
        List<QuestionTable> tableList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(QuestionTable.class));
        return tableList;
    }

    public void save(QuestionTable questionTable) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("QUESTIONDETAILS");
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(questionTable);
        jdbcInsert.execute(parameterSource);
    }

    public void update(QuestionTable questionTable) {
        String sql = "UPDATE QUESTION_DETAILS SET ANSWER = '" + questionTable.getAnswer() + "', CATEGORY = '" + questionTable.getCategory() + "', CHOICE = '" + questionTable.getChoice() + "', DIFFICULTY_LEVEL = '" + questionTable.getDifficultyLevel() + "', QUESTION = '" + questionTable.getQuestion() + "', QUESTION_TYPE = '" + questionTable.getQuestionType() + "', USER_ID = " + questionTable.getUserId() + " WHERE QUESTION_ID = " + questionTable.getQuestionId();
        System.out.println(sql);
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(questionTable);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, parameterSource);
    }
}
