package no.runsafe.metagame.command;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.metagame.api.IStartable;

import java.util.Map;

public class StartCommand extends ExecutableCommand
{
	public StartCommand(GameArgument gameArgument)
	{
		super("start", "Starts the game", null);
		this.gameArgument = gameArgument;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		IStartable startable = gameArgument.get(parameters.get("game"), IStartable.class);
		return startable.StartGame()
			? "The game was started."
			: "The game was not started.";
	}

	private GameArgument gameArgument;
}
