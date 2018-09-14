package agreement;

import org.junit.*; 
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import agreement.service.*;
import agreement.model.*;
import utility.service.*;

public class TestService {
	ServiceInterface service;
	
	@Before
	public void setup() {
		service = Service.getInstance();
	}
	@After 
	public void teardown() {
		service = null;
	}
	
	@Test
	public void Success() throws ValidationException {
		
		ServiceAgreement agreement = new ServiceAgreement("ID","Type");
		service.initialize();
		service.validateServiceAgreement(agreement);
		
	}
	@Test
	public void InitialID() throws ValidationException {
		try {
		  ServiceAgreement agreement = new ServiceAgreement("","Type");
		  service.initialize();
		  service.validateServiceAgreement(agreement);
		} catch (ValidationException ex) {
			org.junit.Assert.assertEquals( ex.getMessage() , "ID must not be initial" );
		}
	}
	
	
}