insert into rol (id,descripcion) values (1,"USER");
insert into rol (id,descripcion) values (2,"MODERATOR");


insert into user (id,address,email,first_name,last_name,password,phone,username,rol_id) values (1,"Cra40","andres@gmail.com","Andres","Castro","1234","3234609172","AndresF10",1);
insert into user (id,address,email,first_name,last_name,password,phone,username,rol_id) values (2,"Cra40","andrea@gmail.com","Andrea","Garcia","1234","3104129312","Andreita10",1);
insert into user (id,address,email,first_name,last_name,password,phone,username,rol_id) values (3,"","admin@gmail.com","","","1234","","",2);

insert into category (id,icon_font_awesome,nombre) values (1,"faDragon","Fantasia");
insert into category (id,icon_font_awesome,nombre) values (2,"faSkull","Terror");
insert into category (id,icon_font_awesome,nombre) values (3,"faBook","Educacion");
insert into category (id,icon_font_awesome,nombre) values (4,"faGlobe","Historia");
insert into category (id,icon_font_awesome,nombre) values (5,"faFaceGrinHearts","Romance");
insert into category (id,icon_font_awesome,nombre) values (6,"faHeart","Salud y cuidado");
insert into category (id,icon_font_awesome,nombre) values (7,"faUserSecret","Misterio");

insert into state_book (id,descripcion) values (1,"POR_REVISAR");
insert into state_book (id,descripcion) values (2,"APROBADO");
insert into state_book (id,descripcion) values (3,"DENEGADO");

insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (1,"Antoine de Saint-Exupéry","Reynal & Hitchcock",5,0,"1943-04-06","Este libro, un clásico de la literatura, cuenta la historia de un aviador perdido en el desierto, quien encuentra a un pequeño príncipe con el que inicia una larga conversación en la que este le cuenta su paso por diferentes planetas y su encuentro con distintos personajes","El principito",2,1,3);
insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (2,"Gabriel García Márquez","Gabriel García Márquez",10,0,"1967-06-05","Entre la boda de José Arcadio Buendía con Amelia Iguarán hasta la maldición de Aureliano Babilonia transcurre todo un siglo. Cien años de soledad para una estirpe única, fantástica, capaz de fundar una ciudad tan especial como Macondo y de engendrar niños con cola de cerdo.","Cien años de soledad",2,1,3);
insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (3,"Oscar Wilde","",5,0,"1888-01-01","Un estudiante desea bailar con la hija del profesor. Ésta le promete que bailará con él en la fiesta del príncipe si le consigue una rosa roja. El problema es que no es época de rosas rojas y es casi imposible encontrar la flor. Un ruiseñor, testigo de los lamentos del joven, intentará ayudarle.","El ruiseñor y la rosa",2,1,3);
insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (4,"Jane Austen","",25,0,"1813-01-28","La señora Bennet ha criado a sus cinco hijas con el único deseo de encontrar marido. La llegada al vecindario de Charles Bingley, un joven rico y soltero, con algunas amistades despierta el interés de las hermanas Bennet y de las familias vecinas, que verán una excelente oportunidad para cumplir su propósito. Elizabeth, una de las hijas de los Bennet, empezará una singular relación con Darcy, uno de los amigos de Bingley, que desencadenará esta historia de orgullo y prejuicios entre los dos hasta llegar a conocer el verdadero amor.","Orgullo y prejuicio",2,5,3);
insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (5,"Gabriel García Márquez","Auguirre Ed",10,0,"1961-01-01","Es una narración que reflexiona sobre la esperanza y la resignación, sobre las consecuencias de mantener los principios y la dignidad personal en una sociedad corrompida. El libro fue escrito por su autor durante una estancia en París, en 1955. No fue publicada sino hasta 1961.","El coronel no tiene quien le escriba",2,1,3);
insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (6,"Jorge Hernandez López Ramirez","Celsus",60,0,"2019-01-01","La Alegría de leer el Electrocardiograma, es un método rápido de lectura de electrocardiograma (ECG) dirigido especialmente a los estudiantes de medicina y áreas paramédicas, aunque también tiene mucha acogida entre médicos generales.","La alegria de leer el electrocardiograma",2,6,3);
insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (7,"Mario Mendoza","",10,0,"2001-01-01","Trata de reconstruir su vida a través de sus memorias para llegar a entender qué lo llevó a cometer un cruel asesinato. Con una prosa que cautiva desde el comienzo, Mario Mendoza sumerge al lector en la ambivalente vida de un individuo que busca liberarse de sus obsesiones.","Relato de un asesino",2,1,3);
insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (8,"Mario Mendoza","",4.99,0,"2014-09-17","Mario Mendoza conversó con diez personas capaces de hablar con los muertos, viajar en el tiempo, anticipar el fin de nuestra era, habitar conciencias ajenas y navegar por universos paralelos.","Paranormal Colombia: Al filo de lo real",2,1,3);
insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (9,"Mario Mendoza","",10,0,"2002-01-01","historias que se tejen en torno a la de Campo Elías, héroe de la guerra de Vietnam, quien inicia su particular descenso a los inﬁernos, obsesionado por la dualidad entre el bien y el mal, entre Jekyll y Hyde, y se convertirá en un ángel exterminador.","Satanas",2,2,3);
insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (10,"Carlos Ruiz Zafón","",30,0,"1993-01-01","En una misteriosa casa de la costa atlántica, lejos del Londres amenazado por la guerra, Max va a descubrir que los desafíos del presente a menudo tienen su razón de ser en pactos inconfesables sellados mucho tiempo atrás, donde habitan seres como El Príncipe de la Niebla","El príncipe de la niebla",2,7,3);

insert into book_file (book_id,file,file_key) values (1,"http://res.cloudinary.com/dxmalxjle/image/upload/v1699799170/bookHubFiles/qrqchrqykq1sgadxda01.pdf","bookHubFiles/qrqchrqykq1sgadxda01");
insert into book_file (book_id,file,file_key) values (2,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700014072/bookHubFiles/r8dg5z0qi2nwcb5ly2gv.pdf","bookHubFiles/r8dg5z0qi2nwcb5ly2gv");
insert into book_file (book_id,file,file_key) values (3,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700014069/bookHubFiles/r8twlc10ikrve6hovn23.pdf","bookHubFiles/r8twlc10ikrve6hovn23");
insert into book_file (book_id,file,file_key) values (4,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700014075/bookHubFiles/gvue9iezeakyhsksypjm.pdf","bookHubFiles/gvue9iezeakyhsksypjm");
insert into book_file (book_id,file,file_key) values (5,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700014068/bookHubFiles/o8zt5p8ikuzdmtjddvoy.pdf","bookHubFiles/o8zt5p8ikuzdmtjddvoy");
insert into book_file (book_id,file,file_key) values (6,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700018293/bookHubFiles/qda4zvave5faeweqhwo8.pdf","bookHubFiles/qda4zvave5faeweqhwo8");
insert into book_file (book_id,file,file_key) values (7,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700014066/bookHubFiles/i3fawtkhtnpdmqikg6d2.pdf","bookHubFiles/i3fawtkhtnpdmqikg6d2");
insert into book_file (book_id,file,file_key) values (8,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700014066/bookHubFiles/pcfw5iaa2g1udo4dbn92.pdf","bookHubFiles/pcfw5iaa2g1udo4dbn92");
insert into book_file (book_id,file,file_key) values (9,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700014068/bookHubFiles/grx2avgmlakpsx5uwb1l.pdf","bookHubFiles/grx2avgmlakpsx5uwb1l");
insert into book_file (book_id,file,file_key) values (10,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700014062/bookHubFiles/cpb1zcgwyz96uyawyaxw.pdf","bookHubFiles/cpb1zcgwyz96uyawyaxw");

insert into book_image (book_id,image,image_key) values (1,"http://res.cloudinary.com/dxmalxjle/image/upload/v1699798826/bookHubImages/rwmmdunqpabyn7mnlxa9.jpg","bookHubImages/rwmmdunqpabyn7mnlxa9");
insert into book_image (book_id,image,image_key) values (2,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700015243/bookHubImages/vz9fbrguhvzjiwyvwhhq.jpg","bookHubImages/vz9fbrguhvzjiwyvwhhq");
insert into book_image (book_id,image,image_key) values (3,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700015243/bookHubImages/gm5lxspcmypopzjekyfm.jpg","bookHubImages/gm5lxspcmypopzjekyfm");
insert into book_image (book_id,image,image_key) values (4,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700015243/bookHubImages/lb52yzrag47aac9eiu82.jpg","bookHubImages/lb52yzrag47aac9eiu82");
insert into book_image (book_id,image,image_key) values (5,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700015243/bookHubImages/ftpwfvqki7urrf67hrsx.jpg","bookHubImages/ftpwfvqki7urrf67hrsx");
insert into book_image (book_id,image,image_key) values (6,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700015243/bookHubImages/w80dwi00fyaw7zrj0qvc.jpg","bookHubImages/w80dwi00fyaw7zrj0qvc");
insert into book_image (book_id,image,image_key) values (7,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700015243/bookHubImages/ialntrcbatu8cdg9b6d0.jpg","bookHubImages/ialntrcbatu8cdg9b6d0");
insert into book_image (book_id,image,image_key) values (8,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700015243/bookHubImages/ka8eizqbmlfo6wp6xers.jpg","bookHubImages/ka8eizqbmlfo6wp6xers");
insert into book_image (book_id,image,image_key) values (9,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700015242/bookHubImages/vsabm98mxesomevam8ih.jpg","bookHubImages/vsabm98mxesomevam8ih");
insert into book_image (book_id,image,image_key) values (10,"https://res.cloudinary.com/dxmalxjle/image/upload/v1700015242/bookHubImages/tjkjnuujymwecxtg4ow4.jpg","bookHubImages/tjkjnuujymwecxtg4ow4");

insert into payment_method (id,card_number,cvv,expedition_date,state,surname,user_id) values (1,"1004591239",123,"2029-10-28",true,"Andres",1);
insert into payment_method (id,card_number,cvv,expedition_date,state,surname,user_id) values (2,"41291231254",477,"2029-10-28",true,"Andrea",2);

insert into review (id,date,puntuation,review,book_id,user_id) values (1,"2023-11-03",5,"Buen libro",1,2);

insert into transaction (id,date,total_price,payment_method_id,user_id) values (1,"2023-10-04",10,2,2);

insert into transaction_detail (id,price,book_id,transaction_id) values (1,10,1,1);

insert into user_favorite_book (user_favorite_id,favorite_book_id) values (1,1);