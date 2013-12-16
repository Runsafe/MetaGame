package no.runsafe.metagame;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.metagame.command.*;
import no.runsafe.metagame.event.ServerReady;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void pluginSetup()
	{
		addComponent(ServerReady.class);
		addComponent(GameArgument.class);
		addComponent(GameCommand.class);
		GameCommand command = getComponent(GameCommand.class);
		command.addSubCommand(getInstance(StartCommand.class));
		command.addSubCommand(getInstance(StopCommand.class));
		command.addSubCommand(getInstance(DefineFieldCommand.class));
	}
}
