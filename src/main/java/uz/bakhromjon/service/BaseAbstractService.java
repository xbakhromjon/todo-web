package uz.bakhromjon.service;

/**
 * @author Bakhromjon Fri, 9:21 PM 2/18/2022
 */

public abstract class BaseAbstractService<R, M> implements BaseService {
    protected final R repository;
    protected final M mapper;

    public BaseAbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
