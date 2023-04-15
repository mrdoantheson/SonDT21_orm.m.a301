package training.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import training.enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Candidate")
@Setter
@Getter
@ToString
public class Candidate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Integer candidateId;
    @NotNull(message = "This field is required")
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @NotNull(message = "This field is required")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull(message = "This field is required")
    @Column(name = "graduation_year", nullable = false)
    private LocalDate graduationYear;
    @Column(nullable = false, unique = true)
    @Size(min = 10, max = 10)
    @Pattern(regexp = "(01|03|05|07|08|09)+([0-9]{8})\\b", message = "Phone number is not valid")
    @NotNull(message = "This field is required")
    private String phone;
    @Column(nullable = false, unique = true)
    @Email
    @NotNull(message = "This field is required")
    private String email;
    @Column(nullable = false)
    private String skill;
    @Column(name = "foreign_language", nullable = false)
    private String foreignLanguage;
    @Column(nullable = false, columnDefinition = "INT CHECK(level >= 1 AND level <= 7)")
    @Range(min = 1, max = 7)
    private Integer level;
    @Column(nullable = false)
    private String cv;
    @Column(name = "allocation_status", nullable = false)
    private Integer allocationStatus;
    @Column(length = 1000, nullable = false)
    private String remark;
    @OneToMany(mappedBy = "candidate")
    private Set<EntryTest> entryTests;
    @OneToMany(mappedBy = "candidate")
    private Set<Interview> interviews;
}
