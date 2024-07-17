package com.learning.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="users")
public class User {

	@Id
    private String id;
    private String uuid;
    private String username;
    private String password;
    private String displayName;
    private String thumbnail;
    private Boolean isDeleted;
    private LocalDate createdAt;
    
    @ManyToOne
    @JsonBackReference
    private Permission permission;
}
