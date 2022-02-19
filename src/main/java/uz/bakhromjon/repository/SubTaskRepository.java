package uz.bakhromjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bakhromjon.entity.task.SubTask;

/**
 * @author Bakhromjon Fri, 9:44 PM 2/18/2022
 */
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
