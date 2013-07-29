package no.runsafe.metagame.command;

import javafx.geometry.BoundingBox;
import no.runsafe.framework.api.command.argument.RequiredArgument;
import no.runsafe.framework.api.command.player.PlayerCommand;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.metagame.database.GameFieldRepository;
import no.runsafe.worldeditbridge.WorldEditInterface;

import java.util.Map;

public class DefineFieldCommand extends PlayerCommand
{
	protected DefineFieldCommand(WorldEditInterface worldEdit, GameFieldRepository fieldRepository)
	{
		super("definefield", "Defines a field region for the chosen game, based on your worldedit selection", null, new RequiredArgument("name"));
		this.worldEdit = worldEdit;
		this.fieldRepository = fieldRepository;
	}

	@Override
	public String OnExecute(RunsafePlayer executor, Map<String, String> parameters)
	{
		BoundingBox selection = worldEdit.getSelection(executor);
		fieldRepository.persist(parameters.get("game"), parameters.get("name"), selection);
		return String.format("Field %s for game %s defined.", parameters.get("name"), parameters.get("game"));
	}

	private final WorldEditInterface worldEdit;
	private final GameFieldRepository fieldRepository;
}
