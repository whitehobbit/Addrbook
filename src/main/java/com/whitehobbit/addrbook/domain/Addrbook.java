package com.whitehobbit.Addrbook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by whitehobbit on 2016. 8. 25..
 */
@Entity
@Table(name = "addrbook")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Addrbook {
    @Id
    @GeneratedValue
    private Integer ab_id;
    @Column(nullable = false)
    private String ab_name;
    @Column(nullable = false)
    private String ab_email;
    @Column(nullable = false)
    private String ab_tel;
    @Column(nullable = false)
    private String ab_birth;
    @Column(nullable = false)
    private String ab_comdept;
    @Column(nullable = false)
    private String ab_memo;
}
