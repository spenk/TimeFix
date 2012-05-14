import java.util.logging.Logger;


public class TimeFix extends Plugin{
	  String name = "Time Fix";
	  String version = "1.1";
	  String author = "spenk";
	  static Logger log = Logger.getLogger("Minecraft");
	  
	  
public void initialize(){
TimeFixL listener = new TimeFixL();
log.info(this.name +" version "+ this.version + " by " +this.author+ " is initialized!");
etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
}
public void enable(){
	log.info(this.name + " version " + this.version + " by " + this.author + " is enabled!");
}

public void disable(){
	log.info(this.name + " version " + this.version + " is disabled!");
}
}
