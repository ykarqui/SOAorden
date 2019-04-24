package ar.edu.iua.orden.business.impl;


import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.iua.gespro.model.persistence.SprintTaskRepository;
import ar.edu.iua.orden.business.BusinessException;
import ar.edu.iua.orden.business.IOrdenBusiness;
import ar.edu.iua.orden.model.Orden;
import ar.edu.iua.orden.model.exeptions.InvalidPriceException;
import ar.edu.iua.orden.model.exeptions.NotFoundException;
import ar.edu.iua.orden.persistence.OrdenRepository;

public class OrdenBusiness implements IOrdenBusiness{
	
	/*
	 * @Autowired
		private SprintTaskRepository taskDAO;
	 */
	@Autowired
	private OrdenRepository ordenDAO;
	
	// Save a order <Using JPA>
	@Override
	public Orden add(Orden orden) throws BusinessException, NotFoundException {
		try {
			if (orden.getPrecio() < 0)
				throw new InvalidPriceException();
			return ordenDAO.save(orden);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/*
	 * // Save a task in backlog list <Using JPA>
	@Override
	public Orden add(Orden sprintTask) throws BusinessException, NotFoundException, ListNotFoundException,
			TaskNameAlreadyExist, EmptyTaskException, InvalidInputException {
		try {
			SprintList sl = (SprintList) FactoryDAO.getInstance().getListDAO().getOne(initialList);
			if (sl != null) {
				List<Orden> oldTasks = getAll();
				for (Orden task : oldTasks) {
					if (task.getName().equalsIgnoreCase(sprintTask.getName())) {
						throw new TaskNameAlreadyExist();
					}
				}

				if (sprintTask.getName() == null || sprintTask.getPriority() == null) {
					throw new EmptyTaskException();
				}

				if (sprintTask.getPriority().equalsIgnoreCase("high")
						|| sprintTask.getPriority().equalsIgnoreCase("medium")
						|| sprintTask.getPriority().equalsIgnoreCase("low")) {
					sprintTask.setListName(sl);
					java.sql.Timestamp currentDate = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
					sprintTask.setCreated(currentDate);
					sprintTask.setModified(currentDate);
					logger.debug("The task " + sprintTask.getName() + " has been asigned to " + sl.getName() + " list");
					return taskDAO.save(sprintTask);
				} else {
					throw new InvalidInputException();
				}

			} else {
				throw new ListNotFoundException();
			}

		} catch (TaskNameAlreadyExist be) {
			logger.error("The task " + sprintTask.getName() + " already exists");
			logger.error(be);
			throw new TaskNameAlreadyExist(be);
		} catch (EmptyTaskException be) {
			logger.error("The task can't have NULL values");
			logger.error(be);
			throw new EmptyTaskException(be);
		} catch (InvalidInputException be) {
			logger.error("The task can't have NULL values");
			logger.error(be);
			throw new EmptyTaskException(be);
		} catch (BusinessException be) {
			logger.error("The task " + sprintTask.getName() + " can't been saved (B_Ex)");
			logger.error(be);
			throw new BusinessException(be);
		} catch (NotFoundException nfe) {
			logger.error("The task " + sprintTask.getName() + " can't been saved (NF_Ex)");
			logger.error(nfe);
			throw new NotFoundException(nfe);
		} catch (ListNotFoundException e) {
			logger.error("The task " + sprintTask.getName() + " can't been saved (LNF_Ex)");
			logger.error(e);
			throw new ListNotFoundException(e);
		} catch (Exception e) {
			logger.error("The task " + sprintTask.getName() + " can't been saved (B_Ex)");
			logger.error(e);
			throw new BusinessException(e);
		}
	}
	 */

}
