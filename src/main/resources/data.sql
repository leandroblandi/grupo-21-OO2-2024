-- DELETEs de las tablas, para insertar datos
-- DELETE FROM `tpc-oo2`.`lote_articulos`;
-- DELETE FROM `tpc-oo2`.`articulos`;
-- DELETE FROM `tpc-oo2`.`usuarios`;
-- DELETE FROM `tpc-oo2`.`roles`;

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
SELECT '3', 1, 'Sanchez', '$2a$10$RH3.vBfUE0BRRGNgHjNlCedEhxC67oMQWPUOEEG4w3mFpgW.IE8ve', '32075398', 'Fabian', 'fsanchez', 2
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`usuarios` WHERE `id_usuario` = '3');

INSERT INTO `tpc-oo2`.`usuarios` (`id_usuario`, `activo`, `apellido`, `clave`, `dni`, `nombre`, `usuario`, `rol_rol_id`)
SELECT '4', 1, 'Rodriguez', '$2a$10$RH3.vBfUE0BRRGNgHjNlCedEhxC67oMQWPUOEEG4w3mFpgW.IE8ve', '11938279', 'Alberto', 'arodriguez', 2
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`usuarios` WHERE `id_usuario` = '4');

-- INSERTs de articulos

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '1', 1, '1100.00', 'IPhone 15 Pro Max 512GB Dark Ocean', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '1700.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '1');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '2', 1, '950.00', 'IPhone 14 Pro Max', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '1300.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '2');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '3', 1, '1200.00', 'Play Station PS5 2TB + GTA VI', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '2100.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '3');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '4', 1, '850.00', 'Samsung S24 Ultra 1TB', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '3200.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '4');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '5', 1, '34.50', 'Redragon Kumara K552', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '56.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '5');

INSERT INTO `tpc-oo2`.`articulos` (`id_articulo`, `activo`, `costo`, `descripcion`, `fecha_actualizacion`, `fecha_creacion`, `precio_venta`, `esta_en_un_lote`)
SELECT '6', 1, '55.50', 'Redragon Fizz Pro K631', '2024-06-14 15:31:53.962542', '2024-06-14 15:31:53.962542', '70.00', false
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`articulos` WHERE `id_articulo` = '6');

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

-- INSERTs de item_venta

INSERT INTO `tpc-oo2`.`items_venta` (`id_item`, `cantidad`, `subtotal`, `articulo_id_articulo`)
SELECT '1', '13', '5000.00', '1'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`items_venta` WHERE `id_item` = '1');

INSERT INTO `tpc-oo2`.`items_venta` (`id_item`, `cantidad`, `subtotal`, `articulo_id_articulo`)
SELECT '2', '70', '9000.00', '3'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`items_venta` WHERE `id_item` = '2');

INSERT INTO `tpc-oo2`.`items_venta` (`id_item`, `cantidad`, `subtotal`, `articulo_id_articulo`)
SELECT '3', '21', '2500.00', '2'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`items_venta` WHERE `id_item` = '3');


-- INSERTs de venta

INSERT INTO `tpc-oo2`.`ventas` (`id_venta`, `fecha_venta`, `precio_final`, `usuario_id_usuario`)
SELECT '1', '2024-01-01', '20000.00', '2'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`ventas` WHERE `id_venta` = '1');


-- INSERTs de venta_item

INSERT INTO `tpc-oo2`.`ventas_items` (`venta_id_venta`, `items_id_item`)
SELECT '1', '1'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`ventas_items` WHERE `venta_id_venta` = '1' AND `items_id_item` = '1');

INSERT INTO `tpc-oo2`.`ventas_items` (`venta_id_venta`, `items_id_item`)
SELECT '1', '2'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`ventas_items` WHERE `venta_id_venta` = '1' AND `items_id_item` = '2');

INSERT INTO `tpc-oo2`.`ventas_items` (`venta_id_venta`, `items_id_item`)
SELECT '1', '3'
WHERE NOT EXISTS (SELECT 1 FROM `tpc-oo2`.`ventas_items` WHERE `venta_id_venta` = '1' AND `items_id_item` = '3');

