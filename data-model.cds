namespace agreement;
using base as base from '../db/base-model';

type ServiceType : String enum { overheadCost; ITCost; };
type BillingMethodType : String enum { plannedCostPlusFixedMargin; };
type BillingFrequencyType : String enum { monthlyWithQuaterlyAdjustment; };
type AllocationMethodType : String enum { byPlannedEmployeeNumber; };
type ExchangeRateType : String enum { monthlyAverage; };
type PaymentMethodType : String enum { nettingByInhouseBank; };
type CostAllocationObjectType : String enum { Project; };
 
entity ServiceAgreement : base.managed {
  key ID : String;
  // Base
  serviceType : ServiceType;
  description : String;
  longDescription: String;
  validFrom : Date;
  validTo : Date;
  // Workflow
  responsiblePerson : base.User;
  approvalPerson : base.User;
  // Cost Recovery Model
  billingMethod : BillingMethodType;
  billingFrequency : BillingFrequencyType;
  costAllocationMethod : AllocationMethodType;
  currency : String(3);
  plannedExchangeRate: ExchangeRateType;
  paymentMethod : PaymentMethodType;
  // Service Provider
  businessPartner : Association to BusinessPartner;
  costAllocationObject : Association to CostAllocationObject;
  // Service Receiver 
  serviceReceiver : Association to many ServiceReceiver on serviceReceiver.serviceAgreement = $self;
};

entity ServiceReceiver {
  key ID : String;
  serviceAgreement : Association to ServiceAgreement;

  businessPartner : Association to BusinessPartner;
  company : Association to Company;  
  costAllocationObject : Association to CostAllocationObject;
}

entity PlannedCost {
  key ID : String;
  serviceAgreement : Association to ServiceAgreement;
  validFrom : Date;
  validTo : Date;
  costElement: Association to CostElement;
  amount : base.Amount;
};

// ------------------- Other Entities

entity BusinessPartner {
  key ID : String;
  description : String;
};

entity Company {
  key ID : String;
  code : String;
  description : String;
}

entity CostAllocationObject {
  key ID : String;
  costAllocationObjectType : CostAllocationObjectType;
  description : String;
};

entity CostElement {
  key ID : String;
  description : String;
};



