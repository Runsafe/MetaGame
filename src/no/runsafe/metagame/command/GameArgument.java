package no.runsafe.metagame.command;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.command.argument.ITabComplete;
import no.runsafe.framework.api.command.argument.RequiredArgument;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class
	GameArgument extends RequiredArgument implements ITabComplete
{
	public GameArgument()
	{
		super("game");
	}

	@Override
	public List<String> getAlternatives(RunsafePlayer executor, String partial)
	{
		return ImmutableList.copyOf(games.keySet());
	}

	public <T> T get(String game, Class<T> type)
	{
		return getKernel(game).getComponent(type);
	}

	public IKernel getKernel(String game)
	{
		return games.get(game);
	}

	public void Update(Map<String, IKernel> options)
	{
		games.clear();
		games.putAll(options);
	}

	private final Map<String, IKernel> games = new ConcurrentHashMap<String, IKernel>();
}
