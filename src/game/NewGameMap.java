package game;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.GroundFactory;
import edu.monash.fit2099.engine.Range;

// IGNORE MEEE

public class NewGameMap extends GameMap {

    public NewGameMap(GroundFactory groundFactory, char groundChar, int width, int height) {
        super(groundFactory, groundChar, width, height);
    }

    public Range getMapHeight() {
        return super.heights;
    }

    public Range getMapWidth() {
        return super.widths;
    }

}
