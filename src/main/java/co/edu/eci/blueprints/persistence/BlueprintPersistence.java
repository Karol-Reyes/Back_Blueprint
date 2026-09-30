package co.edu.eci.blueprints.persistence;

import co.edu.eci.blueprints.model.Blueprint;
import java.util.Set;
import java.util.List;
import co.edu.eci.blueprints.model.Point;

public interface BlueprintPersistence {

    void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException;

    Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException;

    Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException;

    Set<Blueprint> getAllBlueprints();

    void addPoint(String author, String name, int x, int y) throws BlueprintNotFoundException;

    // nuevos

    void updateBlueprint(String author, String name, List<Point> points) throws BlueprintNotFoundException;

    void deleteBlueprint(String author, String name) throws BlueprintNotFoundException;
}
