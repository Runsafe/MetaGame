package no.runsafe.metagame.api;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;

public interface ISpectateableField extends IField
{
	public void addSpectator(RunsafePlayer spectator);
	public List<RunsafePlayer> getSpectators();
}
