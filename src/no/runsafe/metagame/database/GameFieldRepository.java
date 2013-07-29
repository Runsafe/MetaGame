package no.runsafe.metagame.database;

import javafx.geometry.BoundingBox;
import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameFieldRepository extends Repository
{
	public GameFieldRepository(IDatabase database)
	{
		this.database = database;
	}

	public void persist(String game, String field, BoundingBox box)
	{
		database.Update(
			"INSERT INTO metagame_fields (`game`,`field`,x,y,z,w,h,d) VALUES (?,?,?,?,?,?,?,?)" +
				"ON DUPLICATE KEY UPDATE x=VALUES(x),y=VALUES(y),z=VALUES(z),w=VALUES(w),h=VALUES(h),d=VALUES(d)",
			game, field,
			box.getMinX(), box.getMinY(), box.getMinZ(),
			box.getWidth(), box.getHeight(), box.getDepth()
		);
	}

	@Override
	public String getTableName()
	{
		return "metagame_fields";
	}

	@Override
	public HashMap<Integer, List<String>> getSchemaUpdateQueries()
	{
		HashMap<Integer, List<String>> revisions = new HashMap<Integer, List<String>>();
		List<String> sql = new ArrayList<String>();
		sql.add(
			"CREATE TABLE `metagame_fields` (" +
				"`game` VARCHAR(50)," +
				"`field` VARCHAR(50)," +
				"`x` DOUBLE," +
				"`y` DOUBLE," +
				"`z` DOUBLE," +
				"`w` DOUBLE," +
				"`h` DOUBLE," +
				"`d` DOUBLE," +
				"PRIMARY KEY (`game`,`field`)" +
				")"
		);
		revisions.put(1, sql);
		return revisions;
	}

	private final IDatabase database;
}
