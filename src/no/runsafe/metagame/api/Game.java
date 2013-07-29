package no.runsafe.metagame.api;

import no.runsafe.framework.minecraft.RunsafeLocation;

public abstract class Game implements IStartable, IStoppable, IGame
{
	@Override
	public boolean StartGame()
	{
		running = true;
		return true;
	}

	@Override
	public boolean StopCurrentGame(String reason)
	{
		running = false;
		RunsafeLocation ejectTo = getLobbyEntrance();
		for (IField field : getFields())
			field.ejectPlayersTo(ejectTo, reason);
		return true;
	}

	@Override
	public boolean isRunning()
	{
		return running;
	}

	private boolean running;
}
