package ion.entities.bullet

import arc.*
import arc.graphics.g2d.*
import arc.graphics.g2d.TextureAtlas.*
import mindustry.gen.*
import mindustry.graphics.*
import mindustry.entities.bullet.*

open class PodBulletType : BulletType{
    
    var sprite = "launchpod"
    
    constructor() : super(){}
    
    constructor(sprite: String) : super(){
        this.sprite = sprite
    }
    
    //TODO engine draw
    override fun draw(b: Bullet){
        super.draw(b)
        Draw.z(Layer.flyingUnit)
        Draw.rect(sprite, b.x, b.y, b.rotation())
        Draw.z(Layer.flyingUnit - 0.01f)
        Drawf.shadow(Core.atlas.find(sprite), b.x - 7f, b.y - 13f, b.rotation())
    }
}
