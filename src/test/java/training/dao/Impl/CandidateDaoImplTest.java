package training.dao.Impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import training.dao.CandidateDao;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CandidateDaoImplTest {
    static CandidateDao candidateDao;

    @BeforeAll
    static void beforeAll() {
        candidateDao = new CandidateDaoImpl();
    }

    @Test
    void findBySkillAndLevel_EmpRequire_Info_Success() {
        assertDoesNotThrow(() -> candidateDao.findBySkillAndLevel("Angular", 2).forEach(System.out::println));
    }

    @Test
    void findByLanguageAndSkill() {
        assertDoesNotThrow(() -> candidateDao.findByLanguageAndSkill("English", "Angular").forEach(System.out::println));
    }

    @Test
    void findBySkillAndEntryTestResult() {
        assertDoesNotThrow(() -> candidateDao.findBySkillAndEntryTestResult("Java", LocalDate.of(2020, 10, 1)).forEach(System.out::println));
    }

    @Test
    void getAllCandidate() {
        assertDoesNotThrow(() -> candidateDao.getAll().forEach(System.out::println));
    }
}