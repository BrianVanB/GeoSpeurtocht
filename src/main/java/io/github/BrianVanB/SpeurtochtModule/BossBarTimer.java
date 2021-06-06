package io.github.BrianVanB.SpeurtochtModule;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import io.github.BrianVanB.GeoSpeurtocht.GeoSpeurtocht;

public class BossBarTimer implements Listener {
	
	private GeoSpeurtocht Master;
	private SpeurtochtManager Manager;
	private BossBar Bar;
	private BukkitTask updater;
	
	public BossBarTimer(GeoSpeurtocht master, SpeurtochtManager manager)
	{
		Master = master;
		Manager = manager;
	}
	
	public void Create(int min) 
	{
		Bar = Bukkit.createBossBar(Integer.toString(min) +  ":00", BarColor.GREEN, BarStyle.SOLID);
		Bar.setProgress(1.0);
		
		for(Player p : Master.getServer().getOnlinePlayers())
			Bar.addPlayer(p);
		
		updater = new BarUpdater(Bar, min, 0).runTaskTimer(Master, 20, 20);
	}
	
	public void Cancel()
	{
		Bar.removeAll();
		Bar.setVisible(false);
		updater.cancel();
	}
	
//	@EventHandler
//	private void onLogin(PlayerLoginEvent e)
//	{
//		if(Manager.Running)
//		{
//			if(e == null)
//				Master.getLogger().info("Event is NULL");
//			if(Bar == null)
//				Master.getLogger().info("Bar is NULL");
//			Player plToAdd = e.getPlayer();
//			if(plToAdd == null)
//				Master.getLogger().info("Player is NULL");
//
//			Master.getLogger().info("Adding " + plToAdd + " to " + Bar);
//		 	Bar.addPlayer(plToAdd);
//		}
//	}
}

class BarUpdater extends BukkitRunnable
{
	private BossBar Bar;
	private int Min, Sec;
	private double StartTotal;
	private double CurrentTotal;
	
	public BarUpdater(BossBar bar, int m, int s)
	{
		Bar = bar;
		Min = m; Sec = s;
		
		StartTotal = Min * 60.0;
		CurrentTotal = StartTotal;
	}
	
	@Override
	public void run()
	{
		Sec--;
		CurrentTotal--;
		if(Sec == -1)
		{
			Sec = 59;
			Min--;
		}
		
		if(Min == -1)
		{
			Bar.removeAll();
			Bar.setVisible(false);
			this.cancel();
		}
				
		if(Sec < 10)
			Bar.setTitle(Integer.toString(Min) + ":0" + Integer.toString(Sec));
		else
			Bar.setTitle(Integer.toString(Min) + ":" + Integer.toString(Sec));
		
		if(CurrentTotal == (int)(StartTotal / 2))
			Bar.setColor(BarColor.YELLOW);
		
		if(CurrentTotal == 30)
			Bar.setColor(BarColor.RED); 

		//make sure the bar does not go below 0
		Bar.setProgress(Math.max(CurrentTotal/StartTotal, 0.001));
	}
}