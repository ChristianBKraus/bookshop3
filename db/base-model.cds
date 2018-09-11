namespace base;

type User : String;
type Status : String enum  { created; started; finished; };

type managed {
    status: Status;

    @odata.on.insert: #now
    createdAt : Timestamp;
    @odata.on.insert: #user
    createdBy : User;
    @odata.on.update: #now
    changedAt : Timestamp;
    @odata.on.update: #user
    changedBy : User;
}

type Amount {
    amount : Decimal(23, 2);
    currency : String(3);
}

type Message {
    type : String enum { S; I; W; E; A ;};
    id : String;
    number : Integer;
    v1 : String;
    v2 : String;
    v3 : String;
    v4 : String;
    text : String;
}