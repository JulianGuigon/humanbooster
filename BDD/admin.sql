INSERT INTO public.role(roleid) VALUES (666);
INSERT INTO public.address(adressid, city, country, postalcode, streetnumber, wording) VALUES (667, 'hell', 'hell', 666, 666, 'highway to hell');
INSERT INTO public.connected(email, name, password, phonenumber, picture, roleid, address_adressid) VALUES ('root@root', 'Root', 'root', '666', 'http://placehold.it/100x100', 666, 667);
INSERT INTO public.uzer(isactive, isvalid, roleid) VALUES (true, true, 666);

INSERT INTO public.role(roleid) VALUES (668);
INSERT INTO public.address(adressid, city, country, postalcode, streetnumber, wording) VALUES (669, 'hell', 'hell', 666, 666, 'highway to hell');
INSERT INTO public.connected(email, name, password, phonenumber, picture, roleid, address_adressid) VALUES ('root@root', 'Root', 'root', '666', 'http://placehold.it/100x100', 668, 669);
INSERT INTO public.admin(roleid) VALUES (668);