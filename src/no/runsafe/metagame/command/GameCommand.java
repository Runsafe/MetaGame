package no.runsafe.metagame.command;

import no.runsafe.framework.api.command.Command;
import no.runsafe.framework.api.command.argument.ITabComplete;
import no.runsafe.framework.api.command.argument.RequiredArgument;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.ArrayList;
import java.util.List;

public class GameCommand extends Command
{
	public GameCommand(GameArgument game)
	{
		super("game", "Commands to handle games", "runsafe.metagame.manage", game);
	}
}

