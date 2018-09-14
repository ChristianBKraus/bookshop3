package agreement.service;

import static utility.service.Validator.check;

import java.util.*;

import agreement.model.*;
import utility.service.ValidationException;

public class Service implements ServiceInterface {
	
	static ServiceInterface instance; 
	
	List<ServiceAgreement> serviceAgreement = new ArrayList<ServiceAgreement>();
	List<ServiceReceiver> serviceReceiver = new ArrayList<ServiceReceiver>();
	List<PlannedCost> plannedCost = new ArrayList<PlannedCost>();
	
	public static ServiceInterface getInstance() {
		if (instance == null)
			instance = new Service();
		return instance;
	}

	@Override
	public void initialize() {
		serviceAgreement.clear();
		serviceReceiver.clear();
		plannedCost.clear();
	}

	@Override	
	public void validateServiceAgreement(ServiceAgreement agreement) throws ValidationException {
		serviceAgreement.add(agreement);
		
		check(agreement.getId() != "","ID must not be initial");
		check(agreement.getServiceType() != "","Service Type must be specified");
	}
	
	@Override	
	public void validateServiceReceiver(ServiceReceiver receiver) throws ValidationException {
		serviceReceiver.add(receiver);
	}

	@Override	
	public void validatePlannedCost(PlannedCost cost) throws ValidationException {
		plannedCost.add(cost);
	}

	@Override
	public void validateAll() throws ValidationException {
		
	}

}
