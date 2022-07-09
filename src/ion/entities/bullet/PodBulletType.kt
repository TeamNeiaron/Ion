package ion.entities.bullet

import arc.*
import arc.util.*
import arc.struct.*
import arc.graphics.g2d.*
import arc.graphics.g2d.TextureAtlas.*
import mindustry.gen.*
import mindustry.game.*
import mindustry.content.*
import mindustry.graphics.*
import mindustry.entities.*
import mindustry.entities.part.*
import mindustry.entities.bullet.*

import ion.entities.bullet.*

import java.lang.Math

open class PodBulletType : PartBulletType{
    
    var sprite = "launchpod"
    
    constructor() : super(){}
    
    constructor(sprite: String) : super(){
        this.sprite = sprite
        hitEffect = Fx.none
        despawnEffect = Fx.none
    }
    
    override fun draw(b: Bullet){
        super.draw(b)
        Draw.z(Layer.flyingUnitLow)
        Draw.rect(sprite, b.x, b.y, b.rotation())
        Draw.z(Layer.flyingUnitLow - 0.01f)
        Drawf.shadow(Core.atlas.find(sprite), b.x - 9f, b.y - 13f, b.rotation())
    }
}
