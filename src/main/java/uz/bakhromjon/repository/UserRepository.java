package uz.bakhromjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.entity.user.AuthUser;

import java.util.List;

/**
 * @author Bakhromjon Fri, 5:36 PM 2/18/2022
 */
@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findAuthUserByUsername(String username);

    @Query(value = "update auth_user set deleted = 1, deleted_at = current_timestamp where id = ?1", nativeQuery = true)
    boolean delete(Long id);

    @Query(value = "update auth_user set username = ?2, email = ?3, avatar = ?4, updated_at = current_timestamp where id = ?1", nativeQuery = true)
    void update(Long id, String username, String email, String avatar);


    @Query(value = "select * from auth_user where deleted <> 1", nativeQuery = true)
    List<AuthUser> findAllByDeleted();

}
