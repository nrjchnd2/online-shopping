CREATE TABLE category(
id IDENTITY,
name varchar(50),
description varchar(50),
is_active BOOLEAN,
image_url varchar(50),
CONSTRAINT pk_category_id PRIMARY KEY(id)

);

