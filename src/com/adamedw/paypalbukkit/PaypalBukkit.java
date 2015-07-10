package com.adamedw.paypalbukkit;

import org.bukkit.plugin.java.JavaPlugin;

import com.adamedw.paypalbukkit.command.Commandpaypal;

public class PaypalBukkit extends JavaPlugin {


	@Override
	public void onEnable()
	{
		this.saveDefaultConfig();
		this.getCommand("paypal").setExecutor(new Commandpaypal());
	}

	@Override
	public void onDisable()
	{
		
	}


}