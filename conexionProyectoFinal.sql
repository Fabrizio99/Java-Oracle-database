create or replace procedure sp_agregarpedido(fecha date,cantidad number, observacion varchar2, producto varchar2,sede varchar2)
is
begin
    insert into pedido values(SQ_PEDIDO.nextval,fecha,cantidad,observacion,producto,sede);
end;
select * from pedido;
create or replace procedure sp_modificarpedido(idp number, fec date,cant number, obs varchar2, prod varchar2,sd varchar2)
is
begin
    update pedido
        set
            fecha = fec,
            cantidad = cant,
            observacion = obs,
            producto = prod,
            sede = sd
        where
            idpedido = idp;
end;
select * from pedido order by idpedido;
begin
    sp_modificarpedido(3,'05/05/2005','50','Modificado','lapiz','principal');
end;
commit;