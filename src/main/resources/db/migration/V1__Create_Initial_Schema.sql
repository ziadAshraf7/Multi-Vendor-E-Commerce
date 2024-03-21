CREATE TABLE `product` (
                           `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                           `title` VARCHAR(50) NOT NULL,
                           `price` DOUBLE NOT NULL CHECK (price >= 0.25),
                           `code` VARCHAR(255) NOT NULL UNIQUE,
                           `description` TEXT NOT NULL,
                           `meta_title` VARCHAR(255) ,
                            created_at TIMESTAMP,
                            updated_at TIMESTAMP
);

CREATE TABLE `product_image` (
                                 `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 `product_id` BIGINT NOT NULL,
                                 `image` LONGBLOB NOT NULL,
                                 CONSTRAINT `fk_product_image` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
);

CREATE TABLE `product_video` (
                                 `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 `product_id` BIGINT NOT NULL,
                                 `video` LONGBLOB,
                                 CONSTRAINT `fk_product_video` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
);

CREATE TABLE `product_color` (
                                 `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 `product_id` BIGINT NOT NULL,
                                 `image` LONGBLOB NOT NULL,
                                 `color` VARCHAR(255) NOT NULL,
                                 CONSTRAINT `fk_product_color` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
);

CREATE TABLE `ProductAttributeName` (
                                        `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        `product_id` BIGINT NOT NULL,
                                        `attr_name` VARCHAR(255) NOT NULL,
                                        CONSTRAINT `fk_product_attr_name` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
);

CREATE TABLE `ProductAttributeValue` (
                                         `id` INT AUTO_INCREMENT PRIMARY KEY,
                                         `product_attr_id` BIGINT NOT NULL,
                                         `value` VARCHAR(255),
                                         CONSTRAINT `fk_attributeName_attributeValue` FOREIGN KEY (`product_attr_id`) REFERENCES `ProductAttributeName`(`id`)
);

CREATE TABLE `parent_category` (
                                   `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   `title` VARCHAR(255) NOT NULL COLLATE utf8_general_ci,
                                   `meta_title` VARCHAR(255) NOT NULL,
                                   `image` LONGBLOB NOT NULL,
                                   `description` TEXT
);

CREATE TABLE `sub_category` (
                                `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                `title` VARCHAR(255) NOT NULL COLLATE utf8_general_ci,
                                `meta_title` VARCHAR(255) NOT NULL,
                                `image` LONGBLOB NOT NULL,
                                `description` TEXT NOT NULL,
                                `parent_category_id` BIGINT,
                                CONSTRAINT `fk_parent_category` FOREIGN KEY (`parent_category_id`) REFERENCES `parent_category`(`id`)
);
