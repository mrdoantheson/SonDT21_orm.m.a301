package training.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "Interview")
@Entity
@Setter
@Getter
@ToString
public class Interview implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private Integer interviewId;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String interviewer;
    @Column(length = 2000, nullable = false)
    private String comment;
    @Column(name = "interviewer_result", nullable = false)
    private String interviewerResult;
    @Column(length = 1000, nullable = false)
    private String remark;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
