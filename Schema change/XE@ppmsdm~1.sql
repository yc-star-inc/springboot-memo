--create synonym ppms_func_triglog for ppmsdm.ppms_func_triglog;

grant select, insert, update, delete on ppmsdm.ppms_func_triglog to ppmsappl; 
grant select, insert, update, delete on PPMSDM.PPMS_SECT_SPC_CHART to ppmsappl;

create synonym func_triglog for ppmsdm.ppms_func_triglog;