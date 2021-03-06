package com.driesen.ward.mimic.domain.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/***
 * Admission Model Object.
 *
 * Attributes to represent an admission.
 */
@Entity(name = "admissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_id")
    private int id;
    @Column(name = "subject_id")
    private int patientId;
    @Column(name = "admittime")
    private LocalDateTime admitTime;
    @Column(name = "dischtime")
    private LocalDateTime dischargeTime;
}
