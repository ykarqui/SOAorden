package ar.edu.iua.orden.business;

import ar.edu.iua.orden.model.Orden;
import ar.edu.iua.orden.model.exeptions.NotFoundException;

public interface IOrdenBusiness {
	
	public Orden add(Orden sprintTask) throws BusinessException, NotFoundException;

}
