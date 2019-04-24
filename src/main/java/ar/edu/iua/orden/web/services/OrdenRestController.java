package ar.edu.iua.orden.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.orden.business.BusinessException;
import ar.edu.iua.orden.business.IOrdenBusiness;
import ar.edu.iua.orden.model.Orden;
import ar.edu.iua.orden.model.exeptions.NotFoundException;

@RestController
@RequestMapping(Constants.URL_ORDEN)
public class OrdenRestController {

	@Autowired
	private IOrdenBusiness ordenBusiness;

	// Save a order
	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Orden> add(@RequestBody Orden orden) {
		try {
			Orden ord = ordenBusiness.add(orden);
			//logger.debug("A task has been saved");
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", "/orden/" + orden.getIdOrden());
			return new ResponseEntity<Orden>(ord, responseHeaders, HttpStatus.CREATED);
		} catch (NotFoundException nfe) {
			//logger.error("Http status:" + HttpStatus.NOT_FOUND + " in add()");
			//logger.error(nfe);
			return new ResponseEntity<Orden>(HttpStatus.NOT_FOUND);
		} catch (BusinessException e) {
			//logger.error("Http status:" + HttpStatus.INTERNAL_SERVER_ERROR + " in add()");
			//logger.error(e);
			return new ResponseEntity<Orden>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
