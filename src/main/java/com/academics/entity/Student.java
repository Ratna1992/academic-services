package com.academics.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private String mname;
    @Column
    private String phone;
    @Column
    private String mobile;
    @Column
    private String status;
    @Column(name = "last_login_ip")
    private String lastLoginIp;
    @Column
    private Date dob;
    @Column
    private Date doj;
    @Column(name = "last_login_date")
    private Date lastLoginDate;
}
