package me.ellie.jwttutorial.repository;

import me.ellie.jwttutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// User 엔티티에 매핑되는 UserRepository
public interface UserRepository extends JpaRepository<User, Long> { // findAll, save등 메소드 사용 가능
    @EntityGraph(attributePaths = "authorities") // 쿼리 수행 시 Lazy 조회가 아닌 Eager조회로 authorities정보를 같이 가져오게 됨
    Optional<User> findOneWithAuthoritiesByUsername(String username); // username을 기준으로 User정보를 가져올 때 권한 정보도 같이 가져오는 메소드
}
