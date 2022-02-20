package uz.bakhromjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.entity.task.SubTask;
import uz.bakhromjon.entity.task.Task;

import java.util.Date;
import java.util.Optional;

/**
 * @author Bakhromjon Fri, 9:44 PM 2/18/2022
 */
@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {

    @Query(value = "delete from task where id = ?1;", nativeQuery = true)
    void delete(Long id);

    @Query(value = "update task set title = ?1, deadline = ?2, description = ?3, completed = ?4, updated_at = current_timestamp", nativeQuery = true)
    void update(String title, Date deadline, String description, boolean completed);
}
