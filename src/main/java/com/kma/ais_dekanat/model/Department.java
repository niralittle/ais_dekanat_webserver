package com.kma.ais_dekanat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by denysburlakov on 07.02.16.
 */

@Entity
public class Department {

    private Integer departmentId;
    private String name;
    private String mainInfo;
    private Set<UniversityGroup> groups;
    private Set<Cathedra> cathedras;

    @Id
    @GeneratedValue
    @Column(name = "department_id")
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer id) {
        this.departmentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "main_info", columnDefinition = "TEXT")
    public String getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "department",fetch = FetchType.EAGER)
    public Set<UniversityGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<UniversityGroup> groups) {
        this.groups = groups;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    public Set<Cathedra> getCathedras() {
        return cathedras;
    }

    public void setCathedras(Set<Cathedra> cathedras) {
        this.cathedras = cathedras;
    }

}
