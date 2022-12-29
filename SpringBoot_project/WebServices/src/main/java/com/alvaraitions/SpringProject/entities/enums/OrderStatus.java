package com.alvaraitions.SpringProject.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//The enum constructor is always private
	private OrderStatus(int code)
	{
		this.code = code;
	}
	
	public int getCode()
	{
		return code;
	}
	
	//Static because it will work without need to be instantiated
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values())
		{
			if(value.getCode() == code)
			{
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code!");
	}
}
