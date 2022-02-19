package uz.bakhromjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.entity.user.AuthUser;

/**
 * @author Bakhromjon Fri, 5:36 PM 2/18/2022
 */
@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByUsername(String username);
}
