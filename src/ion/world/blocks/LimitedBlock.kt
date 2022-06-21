package ion.world.blocks

import mindustry.game.*
import mindustry.world.*
import mindustry.world.blocks.environment.*
import mindustry.content.*

/** A Block that can only be placed on a specific floor. */
open class LimitedBlock : Block{
    
    var floor = Blocks.stone
    
    constructor(name: String, floor: Floor) : super(name){
        this.floor = floor
    }
    
    override fun canPlaceOn(tile: Tile, team: Team, rotation: Int): Boolean{
        return tile.floor() == floor
    }
}
