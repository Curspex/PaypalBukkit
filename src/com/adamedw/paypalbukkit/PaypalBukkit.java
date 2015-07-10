package com.adamedw.paypalbukkit;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import paypalnvp.core.PayPal;
import paypalnvp.core.PayPal.Environment;
import paypalnvp.profile.BaseProfile;

import com.adamedw.paypalbukkit.command.Commandpaypal;

public class PaypalBukkit extends JavaPlugin {


	public static PaypalBukkit i;

	private PayPal paypal;
	public final PayPal getPaypal() { return PaypalBukkit.i.paypal; }


	/*
	 * TODO LIST
	 * - Implementation for Commandpaypal
	 * - Add locale
	 * - Include more paypal features
	 * - Encrypt data
	 */


	@Override
	public void onEnable()
	{
		PaypalBukkit.i = this;

		PaypalBukkit.i.saveDefaultConfig();

		FileConfiguration config = PaypalBukkit.i.getConfig();
		PaypalBukkit.i.paypal = new PayPal(new BaseProfile.Builder(config.getString("username"), config.getString("password")).signature(config.getString("signature")).build(), Environment.LIVE);

		PaypalBukkit.i.getCommand("paypal").setExecutor(new Commandpaypal(PaypalBukkit.i));
	}

	@Override
	public void onDisable()
	{
		
		PaypalBukkit.i = null;
	}


}