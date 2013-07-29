package no.runsafe.metagame.api;

import javafx.geometry.BoundingBox;
import no.runsafe.framework.minecraft.RunsafeLocation;

import java.util.List;

public interface IGame
{
	public boolean isRunning();
	public BoundingBox getLobby();
	public RunsafeLocation getLobbyEntrance();
	public List<BoundingBox> getEntrances();
	public List<IField> getFields();
}
