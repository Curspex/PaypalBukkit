package com.adamedw.paypalbukkit.command;

import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import paypalnvp.request.GetBalance;

import com.adamedw.paypalbukkit.PaypalBukkit;

public class Commandpaypal implements CommandExecutor {


	private final PaypalBukkit i;
	public Commandpaypal(PaypalBukkit i)
	{
		this.i = i;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		GetBalance balance = new GetBalance();
		this.i.getPaypal().setResponse(balance);
		Map<String, String> response = balance.getNVPResponse();

		// TODO THIS IS JUST A TEMPORARY IMPLEMENTATION, AS I CAN'T CURRENTLY TEST IT
		sender.sendMessage(ChatColor.GOLD + "--- PAYPAL START ------------");
		for (Entry<String, String> str : response.entrySet())
		{
			sender.sendMessage(str.getKey() + " :|: " + str.getValue());
		}
		sender.sendMessage(ChatColor.GOLD + "--- PAYPAL END --------------");
		// TODO SEE ABOVE COMMENT

		return true;
	}


}