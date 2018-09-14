package agreement.odata;

import com.sap.cloud.sdk.service.prov.api.annotations.*;

import com.sap.cloud.sdk.service.prov.api.exits.*;
import com.sap.cloud.sdk.service.prov.api.request.*;
import com.sap.cloud.sdk.service.prov.api.ExtensionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utility.service.ValidationException;
import agreement.service.*;
import agreement.model.*;

public class PlannedCostHook  {
	public final static String entityName = "PlannedCost";

	private final Logger logger = LoggerFactory.getLogger(ServiceAgreementHook.class);
	private final ServiceInterface service = Service.getInstance();
    
    @BeforeCreate (entity = entityName, serviceName = ServiceHook.serviceName) 
    public BeforeCreateResponse beforecreate(CreateRequest cr, ExtensionHelper eh) throws ValidationException{
    	logger.info("Validate " + entityName);
    	
    	service.validatePlannedCost(cr.getData().as(PlannedCost.class));

		return BeforeCreateResponse.setSuccess().response(); //use this API if the payload has not been modified.
    }

}
