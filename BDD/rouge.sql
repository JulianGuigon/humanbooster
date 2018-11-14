--Créez des vues qui classent les idees par top et par flop. 
--Ces vues affichent le nombre de commentaires par idées et tout les champs de bases d'une idée
--(id, titre, votes, creerle, description de l'idée (30 premiers caractères uniquement)).

--create database topaidi;
--\i C:/Users/julia/Desktop/rouge2.sql
--\c topaidi

drop sequence seqtopaidi;
drop view top;
drop view flop;
drop table commentaire;
drop table alerte;
drop table note;
drop table idee;
drop table categorie;
drop table utilisateur;
drop table adresse;
drop table visiteur;
drop table modelstructure;

create table modelstructure(
	id integer primary key,
	titre varchar(300),
	creerle timestamp not null,
	modifierle timestamp,
	desactiverle timestamp
);

create table visiteur(
	idvisiteur integer primary key,
	constraint fk_modstr foreign key (idvisiteur) references modelstructure(id)
);

create table adresse(
	idadresse integer primary key,
	pays varchar(300) not null,
	ville varchar(300) not null,
	codepostal integer not null,
	rue varchar(300) not null,
	numero integer not null, 
	constraint fk_modstr foreign key (idadresse) references modelstructure(id)
);

create table utilisateur(
	idutilisateur integer primary key,
	idadresse integer,
	nom varchar(300) not null,
	email varchar(500) not null,
	motdepasse varchar(200) not null,
	tel varchar(200),
	questionsecrete varchar(500) not null,
	reponsesecrete varchar(500) not null,
	estactif boolean not null,
	estvalide boolean not null,
	estadmin boolean not null,
	constraint fk_modstr foreign key (idutilisateur) references modelstructure(id),
	constraint fk_adr foreign key (idadresse) references adresse(idadresse)
);

create table categorie(
	idcategorie integer primary key,
	idadministrateur integer not null,
	constraint fk_modstr foreign key (idcategorie) references modelstructure(id),
	constraint fk_adm foreign key (idadministrateur) references utilisateur(idutilisateur)	
);

create table idee(
	ididee integer primary key,
	idutilisateur integer not null,
	idcategorie integer not null,
	description text,
	image text,
	constraint fk_modstr foreign key (ididee) references modelstructure(id),
	constraint fk_uti foreign key (idutilisateur) references utilisateur(idutilisateur),
	constraint fk_cat foreign key (idcategorie) references categorie(idcategorie)
);

create table note(
	idnote integer primary key,
	idutilisateur integer not null,
	ididee integer not null,
	esttop boolean not null,
	constraint fk_modstr foreign key (idnote) references modelstructure(id),
	constraint fk_uti foreign key (idutilisateur) references utilisateur(idutilisateur),
	constraint fk_ide foreign key (ididee) references idee(ididee)
);

create table alerte(
	idalerte integer primary key,
	idutilisateur integer not null,
	idsignale integer not null,
	message text,
	type varchar(30) not null,
	constraint fk_modstr foreign key (idalerte) references modelstructure(id),
	constraint fk_uti foreign key (idutilisateur) references utilisateur(idutilisateur),
	constraint fk_signal foreign key (idsignale) references modelstructure(id)
);

create table commentaire(
	idcommentaire integer primary key,
	idutilisateur integer not null,
	idpost integer not null,
	contenu text not null,
	type varchar(30) not null,
	constraint fk_modstr foreign key (idcommentaire) references modelstructure(id),
	constraint fk_uti foreign key (idutilisateur) references utilisateur(idutilisateur),
	constraint fk_pos foreign key (idpost) references modelstructure(id)
);

create view top as select ididee, ms.titre, ms.creerle, (select count(*) from commentaire where idpost=ms.id) nbcom, (select count(*) from note where ididee=ms.id and esttop=true) nbtop, substr(i.description,0,30) from idee i, modelstructure ms where ms.id=i.ididee order by nbtop desc limit 3;
create view flop as select ididee, ms.titre, ms.creerle, (select count(*) from commentaire where idpost=ms.id) nbcom, (select count(*) from note where ididee=ms.id and esttop=false) nbflop, substr(i.description,0,30) from idee i, modelstructure ms where ms.id=i.ididee order by nbflop desc limit 3;

create sequence seqtopaidi minvalue 1 increment by 1;

--insert into values();
--1
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into visiteur values(currVal('seqtopaidi'));
--2/5
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into adresse values(currVal('seqtopaidi'),'France','Lyon',69130,'chemin Louis Chirpaz',8);
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into adresse values(currVal('seqtopaidi'),'France','Civens',42110,'chemin de Gervais',225);
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into adresse values(currVal('seqtopaidi'),'France','Montlucon',03100,'rue des rouges gorges',1);
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into adresse values(currVal('seqtopaidi'),'France','Lyon',69100,'rue yvonne',8);
--6/8
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into utilisateur values(currVal('seqtopaidi'),2,'Tiskull','julian.guigon.jg@gmail.com','user','0768125842','a','b',true,true,false);
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into utilisateur values(currVal('seqtopaidi'),5,'Arkaethos','alexandre.benkheira@gmail.com','root', null,'a','b',true,true,true);
insert into modelstructure values(nextVal('seqtopaidi'),'C''est le roi de tout les ouragans du ciel.',current_timestamp,null,null);
insert into utilisateur values(currVal('seqtopaidi'),null,'Michel','michel.super@gmail.com','michel', null,'michel','michel',true,true,false);
--9
insert into modelstructure values(nextVal('seqtopaidi'),'Nourriture',current_timestamp,null,null);
insert into categorie values(currVal('seqtopaidi'),7);
--10
insert into modelstructure values(nextVal('seqtopaidi'),'Des fruits gratos',current_timestamp,null,null);
insert into idee values(currVal('seqtopaidi'),8,9,'Les fruits c''est bon.',null);
--11
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into note values(currVal('seqtopaidi'),6,10,false);
--12
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into alerte values(currVal('seqtopaidi'),6,8,'C''est inacceptable.','commentaire');
--13
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into commentaire values(currVal('seqtopaidi'),6,10,'Top cool, des fruits gratos !','idee');
--14
insert into modelstructure values(nextVal('seqtopaidi'),'Techno',current_timestamp,null,null);
insert into categorie values(currVal('seqtopaidi'),7);
--15
insert into modelstructure values(nextVal('seqtopaidi'),'Ventilateur air chaud',current_timestamp,null,null);
insert into idee values(currVal('seqtopaidi'), 8, 14, 'Un ventilateur pour l''hiver.',null);
--16
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into note values(currVal('seqtopaidi'),8,10,true);
--17
insert into modelstructure values(nextVal('seqtopaidi'),'Un radiateur froid',current_timestamp,null,null);
insert into idee values(currVal('seqtopaidi'), 6, 14, 'Un radiateur pour se refroidir l''ete.',null);
--18
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into note values(currVal('seqtopaidi'),6,17,true);
--19
insert into modelstructure values(nextVal('seqtopaidi'),'Une simple personne.',current_timestamp,null,null);
insert into utilisateur values(currVal('seqtopaidi'),null,'Fred','fred.lustu@gmail.com','fredo', null,'fredo','fredo',true,true,false);
--20
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into note values(currVal('seqtopaidi'),19,17,true);
--21
insert into modelstructure values(nextVal('seqtopaidi'),null,current_timestamp,null,null);
insert into note values(currVal('seqtopaidi'),19,10,true);

--select count(*) from commentaire where idpost=10;
--select count(*) from note where ididee=10 and esttop=false;
--select ididee, ms.titre, ms.creerle, (select count(*) from commentaire where idpost=ms.id) nbcom, (select count(*) from note where ididee=ms.id and esttop=true) nbtop from idee i, modelstructure ms where ms.id=i.ididee;
select * from top;
select * from flop;