package uz.bakhromjon.service;

import uz.bakhromjon.criteria.BaseCriteria;
import uz.bakhromjon.dto.BaseAbstractDto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Bakhromjon Fri, 9:30 PM 2/18/2022
 */
public interface BaseService<
        D extends BaseAbstractDto,
        C extends BaseCriteria,
        K extends Serializable> {
    List<D> list(C criteria);

    D get(K k);
}
