package com.cognizant.truyum.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
//	onetoone
//	private User user;
//	onetomany
//	jointable
	private List<MenuItem> menuItemList;
	private double total;

	public void setTotal(Double total) {
		BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.FLOOR);
		this.total = bd.doubleValue();
	}
}
