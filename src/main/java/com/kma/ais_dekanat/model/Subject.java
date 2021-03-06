package com.kma.ais_dekanat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by denysburlakov on 07.02.16.
 */
@Entity
public class Subject {
    private Integer subjectId;
    private String name;
    private FinalType finalType;
    private Set<Syllabus> syllabuses;
    private Set<FinalTest> finalTests;

    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "final_type")
    @Enumerated(EnumType.ORDINAL)
    public FinalType getFinalType() {
        return finalType;
    }

    public void setFinalType(FinalType finalType) {
        this.finalType = finalType;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "group")
    public Set<Syllabus> getSyllabuses() {
        return syllabuses;
    }

    public void setSyllabuses(Set<Syllabus> syllabuses) {
        this.syllabuses = syllabuses;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    public Set<FinalTest> getFinalTests() {
        return finalTests;
    }

    public void setFinalTests(Set<FinalTest> finalTests) {
        this.finalTests = finalTests;
    }
}
