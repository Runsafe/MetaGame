package no.runsafe.metagame;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.metagame.command.GameArgument;
import no.runsafe.metagame.command.GameCommand;
import no.runsafe.metagame.command.StartCommand;
import no.runsafe.metagame.command.StopCommand;
import no.runsafe.metagame.event.ServerReady;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		addComponent(ServerReady.class);
		addComponent(GameArgument.class);
		addComponent(GameCommand.class);
		GameCommand command = getComponent(GameCommand.class);
		command.addSubCommand(getInstance(StartCommand.class));
		command.addSubCommand(getInstance(StopCommand.class));
	}
}
