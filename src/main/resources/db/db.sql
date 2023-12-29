insert into users (id, name, last_name, email, phone_number, password, role, create_date)
values (1, 'Admin', 'Adminova', 'admin@gmail.com', '+79939160305', 'admin111!', 0, '27-12-2023');

insert into categories (id, product_id, electronic_type)
values (1, null, 'Smartphones');
values (2, null, 'Laptops and tablets');
values (3, null, 'Smart-watches and bracelet');
values (4, null, 'Accessories');

insert into sub_categories(id, sub_category_id, name_of_sub_category)
values (1, 1, 'Apple , Honor , Xiaomi , Windows');
values (1, 2, 'Apple , Honor , Xiaomi , Windows');
values (1, 3, 'Apple , Honor , Xiaomi , Windows');
values (1, 4, 'Watch straps , Сhargers , Screen protection , Covers and cases , Stands , ' ||
              'Cables and adapters , External batteries , Headphones , Memory card and drives');