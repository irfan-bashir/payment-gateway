CREATE TABLE `payment_methods` (
`id` int NOT NULL AUTO_INCREMENT,
`display_name` varchar(255) DEFAULT NULL,
`name` varchar(255) NOT NULL,
`payment_type` varchar(255) DEFAULT NULL,
`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `payment_plans` (
`id` int NOT NULL AUTO_INCREMENT,
`currency` varchar(255) NOT NULL,
`gross_amount` varchar(255) DEFAULT NULL,
`duration` varchar(255) NOT NULL,
`net_amount` varchar(255) NOT NULL,
`tax_amount` varchar(255) DEFAULT NULL,
`payment_method_id` int NOT NULL,
`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
KEY `payment_method_foreign_key` (`payment_method_id`),
CONSTRAINT `payment_method_foreign_key` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_methods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
