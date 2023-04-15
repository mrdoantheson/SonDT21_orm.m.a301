package training.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import training.enums.Result;

import java.time.LocalDate;

@Entity
@Table(name = "EntryTest")
@Setter
@Getter
@ToString
public class EntryTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_test_id")
    private Integer entryTestId;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private LocalDate date;
    @Column(name = "language_valuator", nullable = false)
    private String languageValuator;
    @Column(name = "language_result", columnDefinition = "DECIMAL(4,2) CHECK(language_result >= 1 AND language_result <= 10)", nullable = false)
    @Min(1)
    @Max(7)
    private Double languageResult;
    @Column(name = "technical_valuator", nullable = false)
    private String technicalValuator;
    @Column(name = "technical_result", columnDefinition = "DECIMAL(4,2) CHECK(technical_result >= 1 AND technical_result <= 10)", nullable = false)
    @Min(1)
    @Max(10)
    private Double technicalResult;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Result result;
    @Column(length = 1000, nullable = false)
    private String remark;
    @Column(name = "entry_test_skill",nullable = false)
    private String entryTestSkill;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}