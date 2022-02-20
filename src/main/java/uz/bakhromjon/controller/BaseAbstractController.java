package uz.bakhromjon.controller;

import uz.bakhromjon.service.BaseService;

/**
 * @author Bakhromjon Sat, 9:40 AM 2/19/2022
 */
public abstract class BaseAbstractController<S extends BaseService> {
    protected final S service;

    public BaseAbstractController(S service) {
        this.service = service;
    }
}
