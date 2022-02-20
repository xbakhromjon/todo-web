package uz.bakhromjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.entity.task.SubTask;

import java.util.Date;

/**
 * @author Bakhromjon Fri, 9:44 PM 2/18/2022
 */
@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {

    @Query(value = "delete from task where id = ?1;", nativeQuery = true)
    void delete(Long id);

    @Query(value = "update task set title = ?2, deadline = ?3, description = ?4, completed = ?5, updated_at = current_timestamp where id = ?1", nativeQuery = true)
    void update(Long id, String title, Date deadline, String description, boolean completed);
}
