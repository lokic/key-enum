drop table if exists crossing;
drop table if exists crossing2;

create table crossing
(
    id    int,
    light int
);

create table crossing2
(
    id    int,
    light varchar
);

INSERT INTO crossing (id, light) VALUES (1, 1);
INSERT INTO crossing (id, light) VALUES (2, null);

INSERT INTO crossing2 (id, light) VALUES (1, 'B');
INSERT INTO crossing2 (id, light) VALUES (2, null);