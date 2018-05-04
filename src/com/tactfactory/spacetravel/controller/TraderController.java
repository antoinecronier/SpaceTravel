package com.tactfactory.spacetravel.controller;

import java.util.List;

import com.tactfactory.spacetravel.entity.BuySale;
import com.tactfactory.spacetravel.entity.Trader;

public abstract class TraderController implements Trader {

	protected static final String TRADE_ACTION_BUY = "Acheter de la marchandise";
	protected static final String TRADE_ACTION_SELL = "Vendre de la marchandise";

	private double balance;

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @param balance
	 */
	public TraderController(double balance) {
		super();
		this.balance = balance;
	}

	@Override
	public void sell(List<BuySale> sallables, Trader buyer) {
		this.unstock(sallables);
		sallables.removeAll(buyer.stock(sallables));

		double godsPrice = 0;
		for (BuySale buySale : sallables) {
			godsPrice += buySale.getPrice();
		}
		this.balance += godsPrice;
		buyer.setBalance(buyer.getBalance() - godsPrice);
	}

	@Override
	public void buy(List<BuySale> sallables, Trader seller) {
		seller.unstock(sallables);
		sallables.removeAll(this.stock(sallables));

		double godsPrice = 0;
		for (BuySale buySale : sallables) {
			godsPrice += buySale.getPrice();
		}
		seller.setBalance(seller.getBalance() + godsPrice);

		this.setBalance(this.getBalance() - godsPrice);
	}
}
