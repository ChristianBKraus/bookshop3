package agreement.service;

import utility.service.ValidationException;
import agreement.model.*;

public interface ServiceInterface {
	public void initialize();
	public void validateServiceAgreement(ServiceAgreement agreement) throws ValidationException;
	public void validateServiceReceiver(ServiceReceiver receiver) throws ValidationException;
	public void validatePlannedCost(PlannedCost cost) throws ValidationException;
	public void validateAll() throws ValidationException;
}