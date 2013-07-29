package no.runsafe.metagame.event;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.event.IServerReady;
import no.runsafe.metagame.Plugin;
import no.runsafe.metagame.api.IManageable;
import no.runsafe.metagame.command.GameArgument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerReady implements IServerReady
{
	public ServerReady(GameArgument argument)
	{
		this.argument = argument;
	}

	@Override
	public void OnServerReady()
	{
		List<IManageable> manageables = Plugin.getPluginAPI(IManageable.class);
		if (manageables != null)
		{
			Map<String, IKernel> games = new HashMap<String, IKernel>();
			for (IManageable manageable : manageables)
				games.put(manageable.getName(), manageable.getKernel());
			argument.Update(games);
		}
	}

	private final GameArgument argument;
}
