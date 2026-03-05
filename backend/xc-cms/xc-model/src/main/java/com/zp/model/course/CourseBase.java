package com.zp.model.course;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author : zhengpanone
 * Date : 2024/4/29 15:37
 * Version : v1.0.0
 * Description: TODO
 */
@Data
@Entity
@Table(name = "course_base")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class CourseBase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    private String name;
    private String users;
    private String mt;
    private String st;
    private String grade;
    @Column(name = "study_model")
    private String studyModel;
    @Column(name = "teach_mode")
    private String teachMode;
    private String description;
    private String status;
    @Column(name = "company_id")
    private String companyId;
    @Column(name = "user_id")
    private String userId;
}
