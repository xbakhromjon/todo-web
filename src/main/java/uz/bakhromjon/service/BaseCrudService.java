package uz.bakhromjon.service;

import org.hibernate.sql.Update;
import uz.bakhromjon.dto.BaseAbstractDto;
import uz.bakhromjon.dto.BaseDto;
import uz.bakhromjon.dto.user.UserCreateDto;
import uz.bakhromjon.dto.user.UserUpdateDto;

import java.io.Serializable;

/**
 * @author Bakhromjon Fri, 9:25 PM 2/18/2022
 */
public interface BaseCrudService<
        CD extends BaseDto,
        UD extends BaseAbstractDto,
        K extends Serializable>{
    K create(CD cd);

    Void delete(K k);

    Void update(UD ud);
}
