package edu.training.news_portal.web.concrete;

import java.util.HashMap;
import java.util.Map;

import edu.training.news_portal.web.concrete.impl.*;

public class CommandProvider {

	private final Map<RequestPath, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(RequestPath.PAGE_AUTH, new PageAuth());
		commands.put(RequestPath.PAGE_MAIN, new PageMain());
		commands.put(RequestPath.PAGE_REGISTRATION, new PageRegistration());
		commands.put(RequestPath.DO_AUTH, new DoAuth());
		commands.put(RequestPath.PAGE_USER_HOME, new PageUserHome());
		commands.put(RequestPath.DO_REGISTRATION, new DoRegistration());
		commands.put(RequestPath.DO_REGISTRATION, new DoRegistration());
		commands.put(RequestPath.NO_COMMAND, new NoCommand());

	}

	public Command take(String path) {

		try {
			RequestPath pathName = RequestPath.valueOf(path.toUpperCase());
			
			Command command = commands.get(pathName);
			
			return (command != null) ? command : new NoCommand();
		} catch (IllegalArgumentException | NullPointerException e) {
			
			return new NoCommand();
		}
	}

}
