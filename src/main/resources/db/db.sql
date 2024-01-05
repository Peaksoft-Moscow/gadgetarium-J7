insert into  users (create_date, id, confirm_the_password, email, gender, last_name, local, name, password, phone_number, role)
values ('04-01-2024',1,'$2a$12$tjLAEM0FrP9ZKJ/PDzkTbu3P/CPcpQ.gAUKeNE83bbiH6JqBY0ERi
','admin@gmail.com','FEMALE','Adminova','-','$2a$12$tjLAEM0FrP9ZKJ/PDzkTbu3P/CPcpQ.gAUKeNE83bbiH6JqBY0ERi
','Adminka','+7389683423','ADMIN');
values ('04-01-2024',2,'$2a$12$EPCPGh7S3lXbDl6Zv1biuuWw7.G0CgdMnJkOOlUGJiBNInpV4NTIS
','user1@gmail.com','FEMALE','Userova','-','$2a$12$EPCPGh7S3lXbDl6Zv1biuuWw7.G0CgdMnJkOOlUGJiBNInpV4NTIS
','Userka','+7834932112','USER');
values ('04-01-2024',3,'$2a$12$ZeI6kBEqBgnRCrKhkUd9GuTu8/GiWErUkkyBWxpuEKV4NuYHUGkSC',
        'user2@gmail.com','MALE','Userov','-','$2a$12$ZeI6kBEqBgnRCrKhkUd9GuTu8/GiWErUkkyBWxpuEKV4NuYHUGkSC',
        'User','+7984342034','USER');

insert into categories (id,electronic_type)
values (1,'Smartphones');
values (2,'Laptops and tablets');
values (3,'Smart watches');
values (4,'Accessories');

insert into sub_categories (category_id, id, name_of_sub_category)
values (1,1,'Flagship smartphone');
values (1,2,'Budget smartphone');
values (1,3,'Game smartphone');
values (1,4,'Folding smartphone');
values (1,5,'Autonomous smartphone');

values (2,6,'High-performance tablet');
values (2,7,'Hybrid tablet');
values (2,8,'Game tablet');
values (2,9,'Graphic tablet');

values (2,10,'High-performance laptop');
values (2,11,'Hybrid laptop');
values (2,12,'Ultrabook');
values (2,13,'Business laptop');
values (2,14,'Game laptop');
values (2,15,'Netbook');
values (2,16,'Graphic laptop');

values (3,17,'Apple Watch');
values (3,18,'Samsung Galaxy Watch');
values (3,19,'Fitbet Verse');
values (3,20,'Xiaomi Mi Band');

values (4,21,'Watch Straps');
values (4,22,'Headphones');
values (4,23,'Chargers');
values (4,24,'Cables');
values (4,25,'Covers');

insert into payments (month_date, year_date, id, card_number, cvc, payment_systems, user_name)
values (03,2035,1,'********2322','***','VISA','Userka Userova');
values (10,2040,2,'********9892','***','МИР','User Userov');

insert into brands (id, brand_name)
values (1, 'Apple');
values (2, 'Samsung');
values (3, 'Xiaomi');
values (4, 'Huawei');
values (5, 'Microsoft');

insert into products (create_date, discount, price, weight, brand_id, id, color, date_of_release, guarantee, memory,
                      operation_memory, operation_system,
                      operation_system_num, processor, product_name, product_status, rating, screen, sim_card)
values ('05-01-2024',0,30000,187,1,1,'WHITE','10-09-2019','1 year','GB_128','GB_8','IOS','17','Apple A13 Bionic','Iphone 11',
'BY_REDUCING_THE_PRICE','-','1792×828','nano-SIM / eSIM');
values ('05-01-2024',0,60000,170,2,2,'GREY','01-02-2023','2 year','GB_512','GB_8','ANDROID','14',' Snapdragon 8 Gen 2 for Galaxy',
        'Samsung S23+','NEW_DEVICES','4','2340×1080','nano-SIM / eSIM');

insert into orders (amount, id, payment_id, user_id, address, delivery_type, image, payment_type)
values (3500,1,1,1,'Avia St.14/2','DELIVERY_BY_COURIER','-' ,'PAYMENT_BY_CARD_ON_RECEIPT');
values (800,2,2,3,'Baytik St.43','DELIVERY_BY_COURIER','-' ,' PAYMENT_BY_CARD_ONLINE');