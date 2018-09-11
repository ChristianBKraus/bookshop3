const cds = require('@sap/cds').connect()
cds.run (()=>{"serialized"

  let { ServiceAgreement, ServiceReceiver, PlannedCost,
        BusinessPartner, Company, CostAllocationObject, CostElement } = cds.model.exports

  // ServiceAgreement
  console.log("Insert ServiceAgreement");
  INSERT.into (ServiceAgreement) .columns (
    'status', 'createdAt', 'createdBy', 'changedAt', 'changedBy', 
    'ID', 'serviceType', 'description', 'longDescription', 
    'validFrom', 'validTo',
    'responsiblePerson', 'approvalPerson',
    'billingMethod', 'billingFrequency', 'costAllocationMethod',
    'currency', 'plannedExchangeRate', 'paymentMethod',
    'businessPartner_ID', 'costAllocationObject_ID'
  ) .rows (
    [ 
        'created', 1, 'User', 1, 'User', 
        'SA1',  'overheadCost', '1st Service', '1st Service', 
        1, 1,
        'User1', 'User2',
        'plannedCostPlusFixedMargin', 'monthlyWithQuaterlyAdjustment', 'byPlannedEmployeeNumber',
        'EUR', 'monthlyAverage', 'nettingByInhouseBank',
        'BP1', 'CA1' 
    ],
  );

  // ServiceReceiver
  console.log("Insert ServiceReceiver");
  INSERT.into(ServiceReceiver).columns(
      'id', 'serviceAgreement_ID', 'businessPartner_ID', 'company_ID', 'costAllocationObject_ID'
  ). rows(
    [ 'SR1', 'SA1', 'BP1', 'CP1', 'CA1' ]
  );

  // PlannedCost
  console.log("Insert PlannedCost");
  INSERT.into(PlannedCost).columns(
      'id', 'serviceAgreement_ID', 'validFrom', 'validTo'  ,
      'costElement_ID', 'amount_amount', 'amount_currency'
  ).rows(
    [ 
      'PC1', 'SA1', 1,1,
      'CE1', '100.00', 'EUR' 
    ]
  );

  // BusinessPartner
  console.log("Insert BusinessPartner");
  INSERT.into(BusinessPartner).columns(
       'id', 'description'  
  ).rows(
    [ 'BP1', 'Business Partner 1' ]
  );

  // Company
  console.log("Insert Company");
  INSERT.into(Company).columns(
    'id', 'code', 'description'
  ).rows(
    [ 'CP1', '0001', 'Company A']
  );

  // CostAllocationObject 
  console.log("Insert CostAllocationObject");
  INSERT.into(CostAllocationObject).columns(
    'id', 'costAllocationObjectType', 'description'
  ).rows(
    [ 'CA1', 'Project', 'Project I']
  );

  // CostElement
  console.log("Insert CostElement");
  INSERT.into(CostElement).columns(
    'id', 'description'
  ).rows(
    [ 'CE1', 'Cost Element 1']
  );

////// test reads
  console.log("Test");
  SELECT.from (ServiceAgreement) .then (console.log);
  console.log("----");
  SELECT.from (ServiceReceiver) .then (console.log);
  console.log("----");
  SELECT.from (PlannedCost) .then (console.log);
  console.log("----");
  SELECT.from (BusinessPartner) .then (console.log);
  console.log("----");
  SELECT.from (Company) .then (console.log);
  console.log("----");
  SELECT.from (CostAllocationObject) .then (console.log);
  console.log("----");
  SELECT.from (CostElement) .then (console.log);
  console.log("End Test");

  //  SELECT.from (serviceAgreement, ['description']) .where ({ 
//    businesPartner_id: SELECT('id').from(Authors) .where ({name: {like:'%Brontë%'}})
//  }) .then (all => console.log (
//    `\nby Brontës: \n\n  ${all.map(b=>b.title).join('\n  ')}
//  `)) 

}); 