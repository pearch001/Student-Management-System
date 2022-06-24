package com.SMS.SMSapi.utils;

import com.SMS.SMSapi.model.entities.Student;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="confirmation_token")
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt, Student student) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.student = student;

    }
}
