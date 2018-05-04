package com.tactfactory.spacetravel.entity;

import java.util.List;

public interface Trader {
	void setBalance(double balance);
	double getBalance();
	void sell(List<BuySale> sallables, Trader buyer);
	void buy(List<BuySale> sallables, Trader seller);
	List<BuySale> stock(List<BuySale> toStock);
	void unstock(List<BuySale> toUnstock);
}
