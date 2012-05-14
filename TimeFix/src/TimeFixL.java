
public class TimeFixL extends PluginListener{
	public boolean onCommand(Player player,String[] split){
		if (split[0].equalsIgnoreCase("/time")&&player.canUseCommand("/time")){
			if (split.length <2 || split.length >3){
				player.notify("The correct usage is '/time on|off'");
				return true;
			}else{
				if (split[1].equalsIgnoreCase("day")){
					player.getWorld().setTime(0);
					player.sendMessage("§cTime Changed!");
					return true;
				}
				if (split[1].equalsIgnoreCase("night")){
				 player.getWorld().setTime(18000);
				 player.sendMessage("§cTime Canged!");
				 return true;
				}
				if (split[1].equalsIgnoreCase("set")){
					try{Long.parseLong(split[2]);}catch(NumberFormatException nfe){player.sendMessage("§cThe correct usage is /time set x"); return true;}
					player.getWorld().setTime(Long.parseLong(split[2]));
					player.sendMessage("§2Time changed!");
					return true;
				}
		}
		}
			
		if (split[0].equalsIgnoreCase("/weather")&&player.canUseCommand("/weather")){
			if (split.length <2 || split.length >2){
				player.notify("The correct usage is /weather on|off");
				return true;
			}else{
				if (split[1].equalsIgnoreCase("on")){
					player.getWorld().setRaining(true);
					player.sendMessage("§cWeather turned on!");
					return true;
				}
				if (split[1].equalsIgnoreCase("off")){
					player.getWorld().setRaining(false);
					player.sendMessage("§cWeather turned off!");
					return true;
				}
			}
		}
		if (split[0].equalsIgnoreCase("/thunder")&&player.canUseCommand("/thunder")||player.canUseCommand("/weather")){
			if (split.length <2 || split.length >2){
				player.notify("The correct usage is '/thunder on|off'");
				return true;
			}else{
				if (split[1].equalsIgnoreCase("on")){
					player.getWorld().setThundering(true);
					player.sendMessage("§cThunder turned on!");
					return true;
				}
				if (split[1].equalsIgnoreCase("off")){
					player.getWorld().setThundering(false);
					player.sendMessage("§cThunder turned off!");
					return true;
				}
			}
		}
		if (split[0].equalsIgnoreCase("/spawnmob")&&player.canUseCommand("/spawnmob")){
			if (split.length <2 || split.length >3){
				player.notify("The correct usage is '/spawnmob mob amount'");
				return true;
			}
			if (split.length ==2){
			if (Mob.isValid(split[1])){
				Block block = new HitBlox(player).getTargetBlock();
				Mob mob = new Mob(split[1], block.getLocation());
				mob.spawn();
				player.sendMessage("§cMob Spawned");
				return true;
			}else{
			player.notify("Invalid mob!");
			return true;
			}
			}
			if (split.length == 3){
				if (Mob.isValid(split[1])){
				try{Integer.parseInt(split[2]);}catch(NumberFormatException nfe){player.sendMessage("The correct usage is '/spawnmob mob amount'");return true;}
				int i = Integer.parseInt(split[2]);
				Block block = new HitBlox(player).getTargetBlock();
				Mob mob = new Mob(split[1], block.getLocation());
				while(i!=0){
					mob.spawn();
					i--;
				}
				player.sendMessage("§cMobs spawned!");
				return true;
				}
				player.notify("Invalid mob!");
				return true;
			}
		}
		return false;
	}
	}
