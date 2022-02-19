package uz.bakhromjon.service;

/**
 * @author Bakhromjon Fri, 9:21 PM 2/18/2022
 */

public abstract class BaseAbstractService<R, M> {
    public final R repository;
    public final M mapper;

    public BaseAbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
