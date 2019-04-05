package com.warems.warehouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.warems.warehouse")
@MapperScan("com.warems.warehouse.dao")
public class WarehouseApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(WarehouseApplication.class, args);
	}
}
