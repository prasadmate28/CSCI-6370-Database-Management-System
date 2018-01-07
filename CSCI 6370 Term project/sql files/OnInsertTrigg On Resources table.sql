CREATE OR REPLACE FUNCTION dbms_final_projv1.status_trigger_function1()
  RETURNS trigger AS
$BODY$

DECLARE

r varchar(20);

id1 int;

sid int;

rid int;

BEGIN

for rid,sid in select request_id, service_id from dbms_final_projv1.service_allocation where status='UNAVAILABLE'

loop

if (select count(distinct resource_name) from dbms_final_projv1.resources where service_id is null and resource_name in (select resource_name from dbms_final_projv1.resource_services_map where service_id = sid)) = (select count(*) from dbms_final_projv1.resource_services_map where service_id = sid)

then

for r in select resource_name from dbms_final_projv1.resource_services_map where service_id = sid

loop

select asset_id into id1 from dbms_final_projv1.resources where service_id is null and resource_name=r limit 1;

update dbms_final_projv1.resources set service_id=sid where asset_id=id1;

end loop;

update dbms_final_projv1.service_allocation set status ='ACTIVE' where request_id = rid;

end if;

end loop;

return null;

end;

$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


CREATE TRIGGER oninsert
  AFTER INSERT
  ON dbms_final_projv1.resources
  FOR EACH STATEMENT
  EXECUTE PROCEDURE dbms_final_projv1.status_trigger_function1();
