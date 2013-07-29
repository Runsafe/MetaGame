package no.runsafe.metagame.command;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.TrailingArgument;
import no.runsafe.metagame.api.IStoppable;

import java.util.Map;

public class StopCommand extends ExecutableCommand
{
	protected StopCommand(GameArgument gameArgument)
	{
		super("stop", "Stops the game", null, new TrailingArgument("reason"));
		this.gameArgument = gameArgument;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		IStoppable stoppable = gameArgument.get(parameters.get("game"), IStoppable.class);
		return stoppable.StopCurrentGame(parameters.get("reason"))
			? "The game was stopped."
			: "The game was not stopped.";
	}

	private final GameArgument gameArgument;
}
