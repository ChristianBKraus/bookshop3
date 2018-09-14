package agreement.odata;

import com.sap.cloud.sdk.service.prov.api.annotations.*;
import com.sap.cloud.sdk.service.prov.api.exits.*;
import com.sap.cloud.sdk.service.prov.api.request.*;
import com.sap.cloud.sdk.service.prov.api.ExtensionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import agreement.model.ServiceAgreement;
import agreement.service.*;
import utility.service.ValidationException;


public class ServiceAgreementHook  {
	public final static String entityName = "ServiceAgreement";

	private final Logger logger = LoggerFactory.getLogger(ServiceAgreementHook.class);
	private final ServiceInterface service = Service.getInstance();
    
    @BeforeCreate (entity = entityName, serviceName = ServiceHook.serviceName) 
    public BeforeCreateResponse beforecreate(CreateRequest cr, ExtensionHelper eh) throws ValidationException {
    	logger.info("Validate " + entityName);
    	
    	service.validateServiceAgreement(cr.getData().as(ServiceAgreement.class));

		return BeforeCreateResponse.setSuccess().response(); //use this API if the payload has not been modified.
    }

}
