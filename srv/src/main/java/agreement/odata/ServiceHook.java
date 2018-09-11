package agreement.odata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.sap.cloud.sdk.service.prov.api.annotations.*;
import com.sap.cloud.sdk.service.prov.api.ExtensionHelper;
import com.sap.cloud.sdk.service.prov.api.request.*;
import agreement.service.*;

public class ServiceHook {
	public final static String serviceName = "ServiceAgreementService";
	
	private final Logger logger = LoggerFactory.getLogger(ServiceHook.class);
	private final ServiceInterface service = ServiceFactory.getInstance(serviceName);
	
	@InitTransaction( serviceNames = serviceName ) 
	public void startTrans(List<Request> requests, ExtensionHelper eh) {
		logger.info("Init Transaction");
		service.initialize();
	}
	
	@EndTransaction( serviceNames = serviceName )
	public void endTrans(List<Request> requests, ExtensionHelper eh) throws Exception {
	  logger.info("Validate " + serviceName);
	  service.validate();
	}
	
}
