drop table if exists crossing;

create table crossing
(
    id    int,
    light int
);

INSERT INTO crossing (id, light) VALUES (1, 1);
INSERT INTO crossing (id, light) VALUES (2, null);