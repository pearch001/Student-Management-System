package com.SMS.SMSapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="student")
public class Student implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Pattern(regexp= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message= "Kindly provide a valid email address")
    @Column(unique = true)
    private String email;
    private String phone;
    private String gender;
    private String password;
    private Boolean locked = false;
    private Boolean enabled = false;
    @Enumerated(EnumType.STRING)
    private AppUser appUser;
    @OneToMany
    @JoinColumn(name = "course_id")
    private Collection<Course> courses = new ArrayList<>();
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date dateModified;

    public Student(String firstName, String lastName,
                   String email, String phone,
                   String gender, String password,
                   AppUser appUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.appUser = appUser;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(appUser.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
