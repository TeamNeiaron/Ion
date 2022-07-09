package ion.entities.bullet

import arc.util.*
import arc.struct.*
import mindustry.gen.*
import mindustry.entities.part.*
import mindustry.entities.bullet.*

import java.lang.*

open class PartBulletType : BulletType(){
    
    val parts = Seq<DrawPart>(DrawPart::class.java)
    
    override fun init(b: Bullet){
        super.init(b)
        b.data(floatArrayOf(0f, 0f))
        val data = b.data() as FloatArray
        data[1] = b.lifetime
    }
    
    override fun update(b: Bullet){
        super.update(b)
        val data = b.data() as FloatArray
        data[0] = Math.min(data[0] + Time.delta, data[1])
    }
    
    override fun draw(b: Bullet){
        super.draw(b)
        val data = b.data() as FloatArray
        
        if(parts.size > 0){
            
            DrawPart.params.set(0f, 0f, 0f, 0f, 0f, 0f, b.x, b.y, b.rotation())
            DrawPart.params.life = data[0] / data[1]
            
            for(i in 0..parts.size - 1){
                var part = parts[i]
                
                part.draw(DrawPart.params)
            }
        }
    }
}
