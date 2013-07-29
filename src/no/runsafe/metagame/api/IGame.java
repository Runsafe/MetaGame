package no.runsafe.metagame.api;

import javafx.geometry.BoundingBox;

import java.util.List;

public interface IGame
{
	public List<BoundingBox> getLobbies();
	public List<IField> getFields();
}
