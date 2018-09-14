package agreement.model;

public class ServiceAgreement {
	private String id;
	private String serviceType;
	
	public ServiceAgreement(String id, String serviceType) {
		this.id = id;
		this.serviceType = serviceType;
	}
	
	@Override 
	public String toString() {
		return "ServiceAgreement: " + id + " (" + serviceType + ")";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
}
