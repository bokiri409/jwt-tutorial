package me.ellie.jwttutorial.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity // db테이블과 1:1 매핑되는 객체
@Table(name = "user") // 테이블명은 user로 지정
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor // Getter~...Constructor 는 lombok어노테이션으로 Get, Set, Builder, Constructor(생성자) 관련 코드를 자동으로 생성해줌 (실무에서 사용 시 고려해야 할 점들이 있음)
public class User {
    @Id // pk
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}
