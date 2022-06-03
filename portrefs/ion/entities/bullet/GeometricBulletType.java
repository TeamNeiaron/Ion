package ion.entities.bullet;

import arc.util.*;
import arc.math.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.game.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.graphics.*;

public class GeometricBulletType extends BulletType{
    /** Amount of minimum/maximum sides the bullet can have. */
    public int minSides = 3, maxSides = 7;
    /** Spin speed of bullet. Set to 0 if you don't want it to spin. */
    public float spinSpeed = 2f;
    /** Bullet color. */
    public Color color = Color.white;
    /** Whether or not the bullet is hollow. */
    public boolean hollow = false;
    
    public GeometricBulletType(int min, int max){
        super();
        minSides = min;
        maxSides = max;
    }
    
    public GeometricBulletType(){
        super();
    }
    
    @Override
    public void draw(Bullet b){
        super.draw(b);
        Draw.z(Layer.bullet);
        Draw.color(color);
        
        if(!(b.data() instanceof Integer)) return;
        
        if(hollow){
            Lines.poly(b.x, b.y, ((int)b.data()), b.type.hitSize, b.rotation() + (Time.time * spinSpeed));
        } else {
            Fill.poly(b.x, b.y, ((int)b.data()), b.type.hitSize, b.rotation() + (Time.time * spinSpeed));
        }
    }
    
    @Override
    public Bullet create(Entityc owner, Team team, float x, float y, float angle, float damage, float velocityScl, float lifetimeScl, Object data, Mover mover, float aimX, float aimY){
        Bullet bullet = super.create(owner, team, x, y, angle, damage, velocityScl, lifetimeScl, data, mover, aimX, aimY);
        bullet.data(Mathf.random(minSides, maxSides));
        
        return bullet; //java
    }
}
