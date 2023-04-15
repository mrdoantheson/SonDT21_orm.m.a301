package training.dao;

import training.entities.Candidate;

import java.time.LocalDate;
import java.util.List;

public interface CandidateDao {
    List<Candidate> findBySkillAndLevel(String skill, Integer level);

    /**
     * Finds candidates by language and skill.
     *
     * @param language the language to search for
     * @param skill    the skill to search for
     * @return a list of candidates with the given language and skill
     */
    List<Candidate> findByLanguageAndSkill(String language, String skill);

    List<Candidate> findBySkillAndEntryTestResult(String skill, LocalDate date);

    public List<Candidate> getAll();

    /**
     * Returns a list of candidates who have an interview scheduled on the specified date.
     *
     * @param date the date of the interview
     * @return a list of candidates who have an interview scheduled on the specified date
     */
    List<Candidate> findByInterviewDate(LocalDate date);
}
