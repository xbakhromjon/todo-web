package uz.bakhromjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.entity.task.Task;

/**
 * @author Bakhromjon Fri, 9:18 PM 2/18/2022
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
