package agreement.service;

public class ServiceFactory {
	public static ServiceInterface getInstance(String serviceName) {
		return new Service();
	}

}
