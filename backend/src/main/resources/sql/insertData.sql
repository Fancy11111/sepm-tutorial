-- insert initial test data
-- the IDs are hardcoded to enable references between further test data
-- negative IDs are used to not interfere with user-entered data and allow clean deletion of test data

DELETE FROM dog where id < 0;

INSERT INTO dog (id, name, description, birthdate, gender)
VALUES (-1, 'Bello', 'description 1', '2000-01-31', 'FEMALE'),
    (-2, 'Marley', 'description 1', '1999-11-15', 'FEMALE'),
    (-3, 'Einstein', 'description 1', '2000-02-27', 'MALE')
;
