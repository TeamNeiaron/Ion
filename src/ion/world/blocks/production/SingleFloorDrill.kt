package ion.world.blocks.production

import arc.Core
import arc.graphics.g2d.Draw
import arc.math.Mathf
import arc.util.Time
import arc.util.io.Reads
import arc.util.io.Writes
import ion.world.blocks.LimitedBlock
import mindustry.content.Fx
import mindustry.entities.Effect
import mindustry.gen.Building
import mindustry.graphics.Drawf
import mindustry.graphics.Layer
import mindustry.type.Category
import mindustry.type.Item
import mindustry.world.blocks.environment.Floor

/** A Drill that can only be placed on a specific floor. Exists to prevent conflicts with other mods. */
open class SingleFloorDrill(name: String, floor: Floor, output: Item) : LimitedBlock(name, floor) {
    
    var outputItem = output
    var drillEffect: Effect = Fx.none
    var drillTime = 120f
    var drillBitSpeed = 2.3f
    var amount = 3

    init{
        update = true
        solid = true
        hasItems = true
        itemCapacity = 15
        category = Category.production
    }
    
    inner class SingleFloorBuild : Building(){
        
        var progress = 0f
        
        override fun updateTile(){
            super.updateTile()
            if(floor() != floor) kill() //yeah screw you payload unit users
            if(outputItem != null){

                if(!items.empty()){
                    dump(outputItem)
                }

                progress += Time.delta * efficiency()

                if(progress >= drillTime){
                    progress = if(items.has(outputItem, itemCapacity)){
                        items.set(outputItem, itemCapacity)
                        0f
                    } else {
                        items.add(outputItem, amount)
                        drillEffect.at(x + Mathf.range(block.size * 6), y + Mathf.range(block.size * 6))
                        0f
                    }
                }
            }
        }
        
        override fun drawCracks(){}
        
        fun drawDefaultCracks(){
            super.drawCracks()
        }
        
        fun drillBitRot(): Float{
            if(items.has(outputItem, itemCapacity)){
                return 0f
            }
            return Time.time * drillBitSpeed * efficiency()
        }
        
        override fun draw(){
            Draw.z(Layer.block)
            Draw.rect(region, x, y)
            Draw.z(Layer.block - 2f)
            Drawf.shadow(region, x, y)
            Draw.z(Layer.blockCracks)
            drawDefaultCracks()
            
            Draw.z(Layer.block)
            Drawf.spinSprite(Core.atlas.find("${block.name}-rotator"), x, y, drillBitRot())
            Draw.rect("${block.name}-top", x, y)
        }
        
        override fun write(write: Writes){
            super.write(write)
            
            write.f(progress)
        }
        
        override fun read(read: Reads, revision: Byte){
            super.read(read, revision)
            
            progress = read.f()
        }
    }
}
