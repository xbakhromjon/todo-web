package uz.bakhromjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.entity.task.Task;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Bakhromjon Fri, 9:18 PM 2/18/2022
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "delete from task where id = ?1;", nativeQuery = true)
    Optional<Task> delete(Long aLong);

    @Query(value = "update task set title = ?1, deadline = ?2, description = ?3, completed = ?4, updated_at = current_timestamp", nativeQuery = true)
    void update(String title, Date deadline, String description, boolean completed);
}
