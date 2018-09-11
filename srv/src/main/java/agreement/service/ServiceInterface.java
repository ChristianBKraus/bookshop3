package agreement.service;

import agreement.model.*;

public interface ServiceInterface {
	public void initialize();
	public void validateServiceAgreement(ServiceAgreement agreement) throws ValidationException;
	public void validateServiceReceiver(ServiceReceiver request) throws ValidationException;
	public void validatePlannedCost(PlannedCost cost) throws ValidationException;
	public void validate() throws ValidationException;
}