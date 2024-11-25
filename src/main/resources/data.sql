-- Inicia la transacción
START TRANSACTION;

-- INSERTs de roles

INSERT INTO `tpc-oo2`.`roles` (`rol_id`, `fecha_actualizacion`, `fecha_creacion`, `rol`)
SELECT '1', '2024-06-14', '2024-06-14', 'ROLE_ADMINISTRADOR'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`roles` WHERE `rol_id` = '1');

INSERT INTO `tpc-oo2`.`roles` (`rol_id`, `fecha_actualizacion`, `fecha_creacion`, `rol`)
SELECT '2', '2024-06-14', '2024-06-14', 'ROLE_CLIENTE'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`roles` WHERE `rol_id` = '2');

-- INSERTs de usuarios
INSERT INTO `tpc-oo2`.`usuarios` (`id_usuario`, `activo`, `apellido`, `clave`, `dni`, `nombre`, `usuario`, `rol_rol_id`)
SELECT '1', 1, 'Blandi', '$2a$10$RH3.vBfUE0BRRGNgHjNlCedEhxC67oMQWPUOEEG4w3mFpgW.IE8ve', '44098528', 'Leandro', 'lblandi', 2
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`usuarios` WHERE `id_usuario` = '1');

INSERT INTO `tpc-oo2`.`usuarios` (`id_usuario`, `activo`, `apellido`, `clave`, `dni`, `nombre`, `usuario`, `rol_rol_id`)
SELECT '2', 1, 'User', '$2a$10$RH3.vBfUE0BRRGNgHjNlCedEhxC67oMQWPUOEEG4w3mFpgW.IE8ve', '11000111', 'Dummy', 'dummy', 1
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`usuarios` WHERE `id_usuario` = '2');

INSERT INTO `tpc-oo2`.`usuarios` (`id_usuario`, `activo`, `apellido`, `clave`, `dni`, `nombre`, `usuario`, `rol_rol_id`)
SELECT '3', 1, 'Ceballos', '$2a$10$RH3.vBfUE0BRRGNgHjNlCedEhxC67oMQWPUOEEG4w3mFpgW.IE8ve', '44950291', 'Agustin', 'aceballos', 2
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`usuarios` WHERE `id_usuario` = '3');

INSERT INTO `tpc-oo2`.`usuarios` (`id_usuario`, `activo`, `apellido`, `clave`, `dni`, `nombre`, `usuario`, `rol_rol_id`)
SELECT '4', 1, 'Carreira', '$2a$10$RH3.vBfUE0BRRGNgHjNlCedEhxC67oMQWPUOEEG4w3mFpgW.IE8ve', '48293748', 'Marco', 'mcarreira', 2
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`usuarios` WHERE `id_usuario` = '4');

INSERT INTO `tpc-oo2`.`usuarios` (`id_usuario`, `activo`, `apellido`, `clave`, `dni`, `nombre`, `usuario`, `rol_rol_id`)
SELECT '5', 1, 'Brites', '$2a$10$RH3.vBfUE0BRRGNgHjNlCedEhxC67oMQWPUOEEG4w3mFpgW.IE8ve', '44582918', 'Alejo', 'abrites', 2
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`usuarios` WHERE `id_usuario` = '5');

-- INSERTs de articulos

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '1', 1, '1100.00', 'IPhone 15 Pro Max 512GB Dark Ocean', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '1700.00', true
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '1');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '2', 1, '950.00', 'IPhone 14 Pro Max', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '1300.00', true
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '2');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '3', 1, '1200.00', 'Play Station PS5 2TB + GTA VI', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '2100.00', true
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '3');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '4', 1, '850.00', 'Samsung S24 Ultra 1TB', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '3200.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '4');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '5', 0, '34.50', 'Redragon Kumara K552', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '56.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '5');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '6', 1, '55.50', 'Redragon Fizz Pro K631', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '70.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '6');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '7', 1, '3500.50', 'Smart TV Led 50 UHD Samsung', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '3800.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '7');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '8', 1, '700.50', 'Auriculares Logitech G733 inalámbricos RGB', '2024-06-14 15:31:53.962542', '2024-01-14 15:31:53.962542', '1800.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '8');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '9', 1, '3000.50', 'iPad Apple 10th generation 2022', '2024-06-14 15:31:53.962542', '2023-06-14 15:31:53.962542', '4200.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '9');



-- INSERTs de lote_articulos

INSERT INTO `tpc-oo2`.`lote_articulos` (`id_lote`, `cantidad`, `fecha_actualizacion`, `fecha_creacion`, `fecha_recepcion`, `precio_compra`, `proveedor`, `articulo_id`)
SELECT '1', '350', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '385000.00', 'IPhone Store Miami', '1'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`lote_articulos` WHERE `id_lote` = '1');

INSERT INTO `tpc-oo2`.`lote_articulos` (`id_lote`, `cantidad`, `fecha_actualizacion`, `fecha_creacion`, `fecha_recepcion`, `precio_compra`, `proveedor`, `articulo_id`)
SELECT '2', '150', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '142000.00', 'IPhone Store Miami', '2'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`lote_articulos` WHERE `id_lote` = '2');

INSERT INTO `tpc-oo2`.`lote_articulos` (`id_lote`, `cantidad`, `fecha_actualizacion`, `fecha_creacion`, `fecha_recepcion`, `precio_compra`, `proveedor`, `articulo_id`)
SELECT '3', '200', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '24000.00', 'Gamers Store Latam', '3'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`lote_articulos` WHERE `id_lote` = '3');

-- Verifica e inserta en items_venta
INSERT INTO items_venta (id_item, articulo_id_articulo, fecha_creacion, fecha_actualizacion, subtotal, cantidad)
SELECT 4, 1, '2024-06-18 21:57:29.271988', '2024-06-18 21:57:29.271988', 1700, 1
WHERE NOT EXISTS (SELECT 1 FROM items_venta WHERE id_item = 4);

INSERT INTO items_venta (id_item, articulo_id_articulo, fecha_creacion, fecha_actualizacion, subtotal, cantidad)
SELECT 5, 1, '2024-06-18 21:57:29.274000', '2024-06-18 21:57:29.274000', 1300, 2
WHERE NOT EXISTS (SELECT 1 FROM items_venta WHERE id_item = 5);

INSERT INTO items_venta (id_item, articulo_id_articulo, fecha_creacion, fecha_actualizacion, subtotal, cantidad)
SELECT 6, 1, '2024-06-18 21:57:29.275000', '2024-06-18 21:57:29.275000', 2100, 3
WHERE NOT EXISTS (SELECT 1 FROM items_venta WHERE id_item = 6);

INSERT INTO items_venta (id_item, articulo_id_articulo, fecha_creacion, fecha_actualizacion, subtotal, cantidad)
SELECT 7, 1, '2024-06-18 21:57:48.562457', '2024-06-18 21:57:48.562457', 1700, 1
WHERE NOT EXISTS (SELECT 1 FROM items_venta WHERE id_item = 7);

INSERT INTO items_venta (id_item, articulo_id_articulo, fecha_creacion, fecha_actualizacion, subtotal, cantidad)
SELECT 8, 4, '2024-06-18 21:57:48.563460', '2024-06-18 21:57:48.563460', 5200, 2
WHERE NOT EXISTS (SELECT 1 FROM items_venta WHERE id_item = 8);

INSERT INTO items_venta (id_item, articulo_id_articulo, fecha_creacion, fecha_actualizacion, subtotal, cantidad)
SELECT 9, 3, '2024-06-18 21:57:48.565972', '2024-06-18 21:57:48.565972', 6300, 3
WHERE NOT EXISTS (SELECT 1 FROM items_venta WHERE id_item = 9);

INSERT INTO items_venta (id_item, articulo_id_articulo, fecha_creacion, fecha_actualizacion, subtotal, cantidad)
SELECT 10, 1, '2024-06-18 21:57:54.620021', '2024-06-18 21:57:54.620021', 1700, 1
WHERE NOT EXISTS (SELECT 1 FROM items_venta WHERE id_item = 10);

INSERT INTO items_venta (id_item, articulo_id_articulo, fecha_creacion, fecha_actualizacion, subtotal, cantidad)
SELECT 11, 1, '2024-06-18 21:58:01.883182', '2024-06-18 21:58:01.883182', 1700, 1
WHERE NOT EXISTS (SELECT 1 FROM items_venta WHERE id_item = 11);

INSERT INTO items_venta (id_item, articulo_id_articulo, fecha_creacion, fecha_actualizacion, subtotal, cantidad)
SELECT 12, 1, '2024-06-18 21:58:20.693179', '2024-06-18 21:58:20.693179', 1300, 2
WHERE NOT EXISTS (SELECT 1 FROM items_venta WHERE id_item = 12);

-- Verifica e inserta en ventas
INSERT INTO ventas (id_venta, fecha_creacion, fecha_actualizacion, fecha_venta, precio_final, usuario_id_usuario)
SELECT 5, '2024-06-18 21:57:29.257448', '2024-06-18 21:57:29.257448', '2024-06-18', 5100, 1
WHERE NOT EXISTS (SELECT 1 FROM ventas WHERE id_venta = 5);

INSERT INTO ventas (id_venta, fecha_creacion, fecha_actualizacion, fecha_venta, precio_final, usuario_id_usuario)
SELECT 6, '2024-06-18 21:57:48.559933', '2024-06-18 21:57:48.559933', '2024-06-18', 13200, 3
WHERE NOT EXISTS (SELECT 1 FROM ventas WHERE id_venta = 6);

INSERT INTO ventas (id_venta, fecha_creacion, fecha_actualizacion, fecha_venta, precio_final, usuario_id_usuario)
SELECT 7, '2024-06-18 21:57:54.618015', '2024-06-18 21:57:54.618015', '2024-06-18', 1700, 3
WHERE NOT EXISTS (SELECT 1 FROM ventas WHERE id_venta = 7);

INSERT INTO ventas (id_venta, fecha_creacion, fecha_actualizacion, fecha_venta, precio_final, usuario_id_usuario)
SELECT 8, '2024-06-18 21:58:01.880665', '2024-06-18 21:58:01.880665', '2024-06-18', 1700, 1
WHERE NOT EXISTS (SELECT 1 FROM ventas WHERE id_venta = 8);

INSERT INTO ventas (id_venta, fecha_creacion, fecha_actualizacion, fecha_venta, precio_final, usuario_id_usuario)
SELECT 9, '2024-06-18 21:58:20.691504', '2024-06-18 21:58:20.691504', '2024-06-18', 1300, 4
WHERE NOT EXISTS (SELECT 1 FROM ventas WHERE id_venta = 9);

-- Verifica e inserta en ventas_items
INSERT INTO ventas_items (venta_id_venta, items_id_item)
SELECT 5, 4 WHERE NOT EXISTS (SELECT 1 FROM ventas_items WHERE venta_id_venta = 5 AND items_id_item = 4);

INSERT INTO ventas_items (venta_id_venta, items_id_item)
SELECT 5, 5 WHERE NOT EXISTS (SELECT 1 FROM ventas_items WHERE venta_id_venta = 5 AND items_id_item = 5);

INSERT INTO ventas_items (venta_id_venta, items_id_item)
SELECT 5, 6 WHERE NOT EXISTS (SELECT 1 FROM ventas_items WHERE venta_id_venta = 5 AND items_id_item = 6);

INSERT INTO ventas_items (venta_id_venta, items_id_item)
SELECT 6, 7 WHERE NOT EXISTS (SELECT 1 FROM ventas_items WHERE venta_id_venta = 6 AND items_id_item = 7);

INSERT INTO ventas_items (venta_id_venta, items_id_item)
SELECT 6, 8 WHERE NOT EXISTS (SELECT 1 FROM ventas_items WHERE venta_id_venta = 6 AND items_id_item = 8);

INSERT INTO ventas_items (venta_id_venta, items_id_item)
SELECT 6, 9 WHERE NOT EXISTS (SELECT 1 FROM ventas_items WHERE venta_id_venta = 6 AND items_id_item = 9);

INSERT INTO ventas_items (venta_id_venta, items_id_item)
SELECT 7, 10 WHERE NOT EXISTS (SELECT 1 FROM ventas_items WHERE venta_id_venta = 7 AND items_id_item = 10);

INSERT INTO ventas_items (venta_id_venta, items_id_item)
SELECT 8, 11 WHERE NOT EXISTS (SELECT 1 FROM ventas_items WHERE venta_id_venta = 8 AND items_id_item = 11);

INSERT INTO ventas_items (venta_id_venta, items_id_item)
SELECT 9, 12 WHERE NOT EXISTS (SELECT 1 FROM ventas_items WHERE venta_id_venta = 9 AND items_id_item = 12);

-- Commit de la transacción
COMMIT;

