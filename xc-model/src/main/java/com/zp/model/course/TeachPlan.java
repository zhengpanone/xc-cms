package com.zp.model.course;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author : zhengpanone
 * Date : 2024/4/29 16:29
 * Version : v1.0.0
 * Description: TODO
 */
@Data
@Entity
@Table(name = "teach_plan")
@GenericGenerator(name = "jpa‐uuid", strategy = "uuid")
public class TeachPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "jpa‐uuid")
    @Column(length = 32)
    private String id;
    private String pName;
    private String parentId;
    private String grade;
    private String pType;
    private String description;
    private String courseId;
    private String status;
    private Integer orderBy;
    private Double timeLength;
    private String tryLearn;
}
