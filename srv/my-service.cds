namespace agreement;
using agreement as sa from '../db/data-model';
 
service ServiceAgreementService {

	entity ServiceAgreement as projection on sa.ServiceAgreement;
	entity ServiceReceiver as projection on sa.ServiceReceiver; 
	entity PlannedCosts as projection on sa.PlannedCost;

	entity BusinessPartner as projection on sa.BusinessPartner;
	entity Company as projection on sa.Company;
	entity CostAllocationObject as projection on sa.CostAllocationObject;
	entity CostElement as projection on sa.CostElement;

	
}
