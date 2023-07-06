insert into organisation(id, name) values(2, 'Another Org' );


 INSERT INTO public.app_user
 (id, enabled, "password", username,organisation_id)
 VALUES(3, true, '$2a$10$f1UDckWmSLD5oHm9kcpsgOzy9ZrD6ggVkQXZGNVkuJybY/dkOsHru', 'AnotherUser_1',1);

INSERT INTO public.app_user
(id, enabled, "password", username,organisation_id)
VALUES(4, true, '$2a$10$f1UDckWmSLD5oHm9kcpsgOzy9ZrD6ggVkQXZGNVkuJybY/dkOsHru', 'AnotherUser_2',1);

INSERT INTO public.app_user
(id, enabled,"password", username, organisation_id)
VALUES(5, true, '$2a$10$f1UDckWmSLD5oHm9kcpsgOzy9ZrD6ggVkQXZGNVkuJybY/dkOsHru', 'AnotherUser_3',2);

update app_user set roles = 15;