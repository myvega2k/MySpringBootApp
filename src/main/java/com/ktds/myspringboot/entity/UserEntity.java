package com.ktds.myspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "users")
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Setter
@DynamicUpdate
public class UserEntity {

}
