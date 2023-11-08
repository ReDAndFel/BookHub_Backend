insert into rol (id,descripcion) values (1,"USER");
insert into rol (id,descripcion) values (2,"MODERATOR");

insert into user (id,address,email,first_name,last_name,password,phone,username,rol_id) values (1,"Cra40","andres@gmail.com","Andres","Castro","1234","3234609172","AndresF10",1);
insert into user (id,address,email,first_name,last_name,password,phone,username,rol_id) values (2,"Cra40","andrea@gmail.com","Andrea","Garcia","1234","3104129312","Andreita10",1);


insert into category (id,icon_font_awesome,nombre) values (1,"","Fantasia");

insert into state_book (id,descripcion) values (1,"POR_REVISAR");
insert into state_book (id,descripcion) values (2,"APROBADO");
insert into state_book (id,descripcion) values (3,"DENEGADO");

insert into book (id,autor,editorial,price,puntuation,realease_date,sinopsis,title,available_id,category_id,user_id) values (1,"Pepito","Pepito Editorial",10,5,"2021-10-24","Libro de pepito","Pepito Book",2,1,1);

insert into book_file (book_id,file,file_key) values (1,"http/dasd.com","qweqw");

insert into book_image (book_id,image,image_key) values (1,"http/dasd.com","qweqw");

insert into payment_method (id,card_number,cvv,expedition_date,state,surname,user_id) values (1,"1004591239",123,"2029-10-28",true,"Andres",1);

insert into review (id,date,puntuation,review,book_id,user_id) values (1,"2023-11-03",5,"Buen libro",1,1);

insert into transaction (id,date,total_price,payment_method_id,user_id) values (1,"2023-10-04",10,1,1);

insert into transaction_detail (id,price,book_id,transaction_id) values (1,10,1,1);

insert into user_favorite_book (user_favorite_id,favorite_book_id) values (1,1);

insert into user_friend (user_id,friend_id) values (1,2);

insert into user_shared_library_user (user_lender_id,shared_library_user_id) values (1,2);