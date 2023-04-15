package training.dao.Impl;

import org.hibernate.Session;
import training.dao.CandidateDao;
import training.entities.Candidate;
import training.entities.EntryTest;
import training.util.XmlConnectionConfig;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CandidateDaoImpl implements CandidateDao {
    // Start Record = 1, Page Size = 10 => Page Index = 1 (Page Index - 1) x 10
    @Override
    public List<Candidate> findBySkillAndLevel(String skill, Integer level) {
        try (Session session = XmlConnectionConfig.getSession()) {
            return session
                    .createQuery("FROM Candidate c WHERE skill = :skill AND level = :level", Candidate.class)
                    .setParameter("skill", skill)
                    .setParameter("level", level).getResultList();
        }
    }

    @Override
    public List<Candidate> findByLanguageAndSkill(String foreignLanguage, String skill) {
        try (Session session = XmlConnectionConfig.getSession()) {
            return session
                    .createQuery("select c FROM Candidate c WHERE c.foreignLanguage = :language AND c.skill = :skill", Candidate.class)
                    .setParameter("language", foreignLanguage)
                    .setParameter("skill", skill).list();
        }
    }

    @Override
    public List<Candidate> findBySkillAndEntryTestResult(String skill, LocalDate date) {
        try (Session session = XmlConnectionConfig.getSession()) {
            return session
                    .createQuery("FROM Candidate c JOIN EntryTest e ON c.id = e.id WHERE e.entryTestSkill = :skill AND e.date = :date AND e.result = 'Pass'", Candidate.class)
                    .setParameter("skill", skill)
                    .setParameter("date", date).getResultList();
        }
    }
    @Override
    public List<Candidate> getAll() {
        try (Session session = XmlConnectionConfig.getSession()) {
            return session.createQuery("SELECT c FROM Candidate c",
                            Candidate.class)
                    .getResultList();

        }
    }

    @Override
    public List<Candidate> findByInterviewDate(LocalDate date) {
        return null;
    }
}
