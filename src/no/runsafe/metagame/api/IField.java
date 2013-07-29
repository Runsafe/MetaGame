package no.runsafe.metagame.api;

import javafx.geometry.BoundingBox;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;

public interface IField
{
	public BoundingBox getBounds();
	public List<RunsafeLocation> getSpawnPoints();
	public List<RunsafePlayer> getContenders();
	public void ejectPlayersTo(RunsafeLocation location, String message);
}
