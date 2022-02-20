package uz.bakhromjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.entity.role.Role;

/**
 * @author Bakhromjon Sat, 8:02 PM 2/19/2022
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
