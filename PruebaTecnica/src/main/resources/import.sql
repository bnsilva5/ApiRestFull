INSERT INTO clientes(nombre, apellidos, numero_contacto, correo_contacto) VALUES ('Nicholas', 'Silva Ruiz', 3206901034, '1234@gmail.com');
INSERT INTO clientes(nombre, apellidos, numero_contacto, correo_contacto) VALUES ('Mick', 'Ruiz S', 3206934534, '271589@gmail.com');
INSERT INTO clientes(nombre, apellidos, numero_contacto, correo_contacto) VALUES ('Manuel', 'Silva Ruiz', 3284601034, '009716@gmail.com');
INSERT INTO clientes(nombre, apellidos, numero_contacto, correo_contacto) VALUES ('Maria', 'Ruiz', 3284319034, '1115607@gmail.com');
INSERT INTO clientes(nombre, apellidos, numero_contacto, correo_contacto) VALUES ('Sidd', 'Harta', 3194619034, '001161534@gmail.com');

INSERT INTO tipo_productos(categoria) VALUES('Consumo');
INSERT INTO tipo_productos(categoria) VALUES('Tecnologia');
INSERT INTO tipo_productos(categoria) VALUES('Duraderos');
INSERT INTO tipo_productos(categoria) VALUES('Perecederos');
INSERT INTO tipo_productos(categoria) VALUES('Farmaceuticos');
INSERT INTO tipo_productos(categoria) VALUES('Artesanales');

INSERT INTO productos(nombre, descripcion) VALUES ('Celulares Iphone', 'Iphon 12, 13, 14 de 128GB y 256GB');
INSERT INTO productos(nombre, descripcion) VALUES ('Alimentos','Frutas y verduras');
INSERT INTO productos(nombre, descripcion) VALUES ('Lacteo', 'Bolsas de leche');
INSERT INTO productos(nombre, descripcion) VALUES ('Medicamentos', 'Ibuprofeno, antibioticos');

INSERT INTO almacenamiento(nombre, tipo, descripcion, direccion, origen, disponibilidad) VALUES ('Almacenamiento Nicholas', 'Terrestre', 'Almacenamiento de alimentos', 'calle 3 # 17', 'Nacional', true);
INSERT INTO almacenamiento(nombre, tipo, descripcion, direccion, origen, disponibilidad) VALUES ('Bodega Eclipse', 'Maritimo', 'Almacenamiento de electronicos', 'avenida 24 # 45', 'Internacional', true);

INSERT INTO plan_entrega_terrestre(cantidad_productos, fecha_registro, fecha_entrega, precio_envio, descuento, total_envio, placa_vehiculo, numero_guia, tipo_producto, tipo_almacenamiento) VALUES (250, '2024-04-22', '2024-05-22', 45000, 2250, 42750, 'ABC567', 0393754637, 2, 2);
INSERT INTO plan_entrega_terrestre(cantidad_productos, fecha_registro, fecha_entrega, precio_envio, descuento, total_envio, placa_vehiculo, numero_guia, tipo_producto, tipo_almacenamiento) VALUES (300, '2024-04-20', '2024-05-05', 35000, 1750, 33250, 'NNN321', 7773754637, 5, 1);

INSERT INTO envios(cliente_id, plan_entrega_id, fecha_solicitud_envio) VALUES (1, 1, '2024-04-22');
INSERT INTO envios(cliente_id, plan_entrega_id, fecha_solicitud_envio) VALUES (3, 1, '2024-04-22');
INSERT INTO envios(cliente_id, plan_entrega_id, fecha_solicitud_envio) VALUES (1, 1, '2024-04-22');