package com.example.BankingApplication1.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="savingsTransaction" )
public class SavingsTransaction {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String date;
	    private String description;
	    private String type;
	    private String status;
	    private double amount;
	    private Long availableBalance;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "savingsAccount_id")
	    private SavingsAccount savingsAccount;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public Long getAvailableBalance() {
			return availableBalance;
		}

		public void setAvailableBalance(Long availableBalance) {
			this.availableBalance = availableBalance;
		}

		public SavingsAccount getSavingsAccount() {
			return savingsAccount;
		}

		public void setSavingsAccount(SavingsAccount savingsAccount) {
			this.savingsAccount = savingsAccount;
		}
	    
}
