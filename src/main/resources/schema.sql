CREATE DATABASE IF NOT EXISTS `grindhouse`;

USE `grindhouse`;

ALTER TABLE `order`
  DROP FOREIGN KEY `order_per_employee_constraint`;

ALTER TABLE `shop_employee`
  DROP FOREIGN KEY `shop_employee_per_employee_constraint`;

ALTER TABLE `item`
  DROP FOREIGN KEY `items_per_order_constraint`;

ALTER TABLE `order`
  DROP FOREIGN KEY `orders_per_customer_constraint`;

ALTER TABLE `item`
  DROP FOREIGN KEY `product_per_item_constraint`;

ALTER TABLE `ingredient`
  DROP FOREIGN KEY `ingredients_per_product_constraint`;

ALTER TABLE `audit_log`
  DROP FOREIGN KEY `audit_logs_per_employee_constraint`;

ALTER TABLE `ingredient`
  DROP FOREIGN KEY `ingredients_per_inventory_constraint`;

ALTER TABLE `shop_employee`
  DROP FOREIGN KEY `shop_employees_per_shop_constraint`;

ALTER TABLE `shop_owner`
  DROP FOREIGN KEY `shop_owner_per_shop_constraint`;

ALTER TABLE `shop_owner`
  DROP FOREIGN KEY `shop_owner_per_employee_constraint`;

ALTER TABLE `shop_owner`
  DROP FOREIGN KEY `shop_owner_per_employee_constraint`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee`(
    `emp_id` INT NOT NULL,
    `emp_name` VARCHAR(255) NOT NULL,
    `emp_number` VARCHAR(255) NOT NULL,
    `emp_password` VARCHAR(255) NOT NULL,

    PRIMARY KEY (`emp_id`)
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order`(
    `order_id` INT NOT NULL,
    `fk_emp_id` INT NOT NULL,
    `fk_cust_id` INT NOT NULL,
    `state` VARCHAR(255) NOT NULL,
    `total` DECIMAL NOT NULL,

    PRIMARY KEY (`order_id`)
);

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item`(
    `item_id` INT NOT NULL,
    `fk_order_id` INT NOT NULL,
    `fk_prod_id` INT NOT NULL,
    `qauntity` INT NOT NULL,
    `milk` TINYINT NOT NULL,
    `cream` TINYINT NOT NULL,
    `suger` TINYINT NOT NULL,

    PRIMARY KEY (`item_id`)
);

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer`(
    `cust_id` INT NOT NULL,
    `cust_name` VARCHAR(255) NOT NULL,
    `cell` VARCHAR(255) NOT NULL,
    `order_count` INT NOT NULL,
    `isValid` BOOLEAN NOT NULL,

    PRIMARY KEY (`cust_id`)
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product`(
    `prod_id` INT NOT NULL,
    `prod_name` VARCHAR(255) NOT NULL,
    `prod_price` DECIMAL NOT NULL,
    `prod_desc` TEXT NOT NULL,
    `has_milk` BOOLEAN,
    `has_cream` BOOLEAN,
    `has_sugar` BOOLEAN,
    `has_condiments` BOOLEAN,

    PRIMARY KEY (`prod_id`)
);

DROP TABLE IF EXISTS `audit_log`;

CREATE TABLE `audit_log`(
    `audit_id` INT NOT NULL,
    `fk_emp_id` INT NOT NULL,
    `created` TIMESTAMP NOT NULL,
    `action_type` TEXT NOT NULL,
    `note` TEXT NOT NULL,

    PRIMARY KEY (`audit_id`)
);

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop`(
    `shop_id` INT NOT NULL,
    `shop_name` VARCHAR(255) NOT NULL,

    PRIMARY KEY (`shop_id`)
);

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory`(
    `inv_id` INT NOT NULL,
    `fk_shop_id` INT NOT NULL,
    `inv_desc` VARCHAR(255) NOT NULL,
    `inv_allergens` VARCHAR(255) NOT NULL,
    `quantity` INT NOT NULL,

    PRIMARY KEY (`inv_id`)
);

DROP TABLE IF EXISTS `ingredient`;

CREATE TABLE `ingredient`(
    `ingr_id` INT NOT NULL,
    `fk_prod_id` INT NOT NULL,
    `fk_inv_id` INT NOT NULL,

    PRIMARY KEY (`ingr_id`)
);

DROP TABLE IF EXISTS `shop_employee`;

CREATE TABLE `shop_employee`(
    `shop_employee_id` INT NOT NULL,
    `fk_shop_id` INT NOT NULL,
    `fk_emp_id` INT NOT NULL,
    `manager` BOOLEAN,

    PRIMARY KEY (`shop_employee_id`)
);

DROP TABLE IF EXISTS `shop_owner`;

CREATE TABLE `shop_owner`(
    `shop_owner_id` INT NOT NULL,
    `fk_shop_id` INT NOT NULL,
    `fk_emp_id` INT NOT NULL,

    PRIMARY KEY (`shop_owner_id`)
);


ALTER TABLE
    `order` ADD CONSTRAINT `order_per_employee_constraint` FOREIGN KEY(`fk_emp_id`) REFERENCES `employee`(`emp_id`);
ALTER TABLE
    `shop_employee` ADD CONSTRAINT `shop_employee_per_employee_constraint` FOREIGN KEY(`fk_emp_id`) REFERENCES `employee`(`emp_id`);
ALTER TABLE
    `item` ADD CONSTRAINT `items_per_order_constraint` FOREIGN KEY(`fk_order_id`) REFERENCES `order`(`order_id`);
ALTER TABLE
    `order` ADD CONSTRAINT `orders_per_customer_constraint` FOREIGN KEY(`fk_cust_id`) REFERENCES `customer`(`cust_id`);
ALTER TABLE
    `item` ADD CONSTRAINT `product_per_item_constraint` FOREIGN KEY(`fk_prod_id`) REFERENCES `product`(`prod_id`);
ALTER TABLE
    `ingredient` ADD CONSTRAINT `ingredients_per_product_constraint` FOREIGN KEY(`fk_prod_id`) REFERENCES `product`(`prod_id`);
ALTER TABLE
    `audit_log` ADD CONSTRAINT `audit_logs_per_employee_constraint` FOREIGN KEY(`fk_emp_id`) REFERENCES `employee`(`emp_id`);
ALTER TABLE
    `ingredient` ADD CONSTRAINT `ingredients_per_inventory_constraint` FOREIGN KEY(`fk_inv_id`) REFERENCES `inventory`(`inv_id`);
ALTER TABLE
    `inventory` ADD CONSTRAINT `inventory_per_shop_constraint` FOREIGN KEY(`fk_shop_id`) REFERENCES `shop`(`shop_id`);
ALTER TABLE
    `shop_employee` ADD CONSTRAINT `shop_employees_per_shop_constraint` FOREIGN KEY(`fk_shop_id`) REFERENCES `shop`(`shop_id`);
ALTER TABLE
    `shop_owner` ADD CONSTRAINT `shop_owner_per_shop_constraint` FOREIGN KEY(`fk_shop_id`) REFERENCES `shop`(`shop_id`);
ALTER TABLE
    `shop_owner` ADD CONSTRAINT `shop_owner_per_employee_constraint` FOREIGN KEY(`fk_emp_id`) REFERENCES `employee`(`emp_id`);