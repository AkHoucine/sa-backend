alter table CLIENT
add column CREATION timestamp not null default current_timestamp,
add column UPDATING timestamp not null on update current_timestamp;