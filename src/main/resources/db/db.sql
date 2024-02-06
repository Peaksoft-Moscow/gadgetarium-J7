insert into users (create_date, email, gender, last_name, local, password, name, phone_number,
                   role, subscribe)
values ('04-01-2024', 'admin@gmail.com', 'FEMALE', 'Adminova', '-',
        '$2a$12$cJqV4jcJgevHCRzZ6CHYmeE6iMpMhRH0OmCxjU16fck/rPDfgng32', 'Adminka', '+7389683423', 'ADMIN', false),

       ('04-01-2024', 'user1@gmail.com', 'FEMALE', 'Userova', '-',
        '$2a$12$03nsempyLxGKYZ9uhEew0u/dv1g0u7v.Mplf7hrvoMoJ4gl72Vkle', 'Userka', '+7834932112', 'USER', true),

       ('04-01-2024', 'user2@gmail.com', 'MALE', 'Userov', '-',
        '$2a$12$WoDhXlFLi.GlgMqrEaxEsuxTuHGIk0i95/s44U52wQAUTVDbVg6Am',
        'User', '+7984342034', 'USER', false);

insert into categories (electronic_type)
values ('Smartphones'),
       ('Laptops and tablets'),
       ('Smart watches'),
       ('Accessories');

insert into sub_categories (category_id, name_of_sub_category)
values (1, 'Flagship smartphone'),
       (1, 'Budget smartphone'),
       (1, 'Game smartphone'),
       (1, 'Folding smartphone'),
       (1, 'Autonomous smartphone'),

       (2, 'High-performance tablet'),
       (2, 'Hybrid tablet'),
       (2, 'Game tablet'),
       (2, 'Graphic tablet'),

       (2, 'High-performance laptop'),
       (2, 'Hybrid laptop'),
       (2, 'Ultrabook'),
       (2, 'Business laptop'),
       (2, 'Game laptop'),
       (2, 'Netbook'),
       (2, 'Graphic laptop'),

       (3, 'Apple Watch'),
       (3, 'Samsung Galaxy Watch'),
       (3, 'Fitbet Verse'),
       (3, 'Xiaomi Mi Band'),

       (4, 'Watch Straps'),
       (4, 'Headphones'),
       (4, 'Chargers'),
       (4, 'Cables and adapters'),
       (4, 'Stands'),
       (4, 'Covers and cases'),
       (4, 'Screen protection'),
       (4, 'External batteries'),
       (4, 'Memory card and drives');

insert into payments (month_date, year_date, card_number, cvc, payment_systems, user_name)
values (03, 2035, '********2322', '***', 'VISA', 'Userka Userova'),
       (10, 2040, '********9892', '***', 'МИР', 'User Userov');

insert into brands (brand_name)
values ('Apple'),
       ('Samsung'),
       ('Xiaomi'),
       ('Huawei'),
       ('Microsoft');

insert into products (create_date, discount, price, weight, brand_id, color, date_of_release, guarantee, memory,
                      operation_memory, operation_system,
                      operation_system_num, processor, product_name, product_status, rating, screen, sim_card)
values ('05-01-2024', 10, 30000, 187, 1, 'WHITE', '10-09-2019', '1 year', 'GB_128', 'GB_8', 'IOS', '17',
        'Apple A13 Bionic', 'Iphone 11',
        'BY_REDUCING_THE_PRICE', '-', '1792×828', 'nano-SIM / eSIM'),
       ('05-01-2024', 20, 60000, 170, 2, 'GREY', '01-02-2023', '2 year', 'GB_512', 'GB_8', 'ANDROID', '14',
        ' Snapdragon 8 Gen 2 for Galaxy',
        'Samsung S23+', 'NEW_DEVICES', '4', '2340×1080', 'nano-SIM / eSIM');

insert into orders (amount, payment_id, user_id, address, delivery_type, image)
values (4500, 1, 2, 'Avia St.12/3', 'PICKUP_FROM_STORE', null),
       (7800, 2, 3, 'Baytik St.42', 'DELIVERY_BY_COURIER', null);

insert into baskets(quantity, price, discount, total_price, user_id)
values (0, 0.0, 0, 0.0, 1),
       (0, 0.0, 0, 0.0, 2),
       (0, 0.0, 0, 0.0, 3);