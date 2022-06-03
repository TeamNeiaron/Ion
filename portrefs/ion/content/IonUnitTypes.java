package ion.content;

import arc.*;
import arc.graphics.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.game.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;

import ion.defs.*;
import ion.content.*;
import ion.entities.bullet.*;

public class IonUnitTypes{
    public static UnitType
    
    //geometry
    orion, xender, astro, geometry, xeus;
    
    public static void load(){
        orion = new UnitType("orion"){{
            flying = true;
            health = 290f;
            speed = 3.62f;
            accel = 0.15f;
            drag = 0.05f;
            engineOffset = 7f;
            hitSize = 13f;
            
            constructor = UnitEntity::create;
            
            
            weapons.add(new Weapon("orion-arc"){{
                x = 0f;
                y = 0f;
                reload = 40f;
                mirror = false;
                shootSound = Sounds.spark;
                shoot.shots = 2;
                bullet = new LightningBulletType(){{
                    damage = 14f;
                    lightningColor = IColor.energy;
                    lightningLength = 19;
                }};
            }});
        }};
        
        xender = new UnitType("xender"){{
            flying = true;
            health = 740f;
            armor = 4.2f;
            speed = 2.7f;
            accel = 0.2f;
            drag = 0.09f;
            engineSize = 3.7f;
            engineOffset = 9f;
            hitSize = 16f;
            
            constructor = UnitEntity::create;
            
            weapons.add(new Weapon("xender-lancer"){{
                reload = 95f;
                x = 0f;
                y = -4.3f;
                mirror = false;
                
                shootSound = Sounds.laser;
                shoot = new ShootSpread(2, 2f);
                
                bullet = new LaserBulletType(34f){{
                    length = 152f;
                    width = 5f;
                }};
            }});
        }};
        
        astro = new UnitType("astro"){{
            flying = true;
            health = 1030f;
            armor = 7.8f;
            speed = 1.6f;
            accel = 0.1f;
            drag = 0.08f;
            engineSize = 6f;
            engineOffset = 17f;
            hitSize = 27f;
            rotateSpeed = 3f;
            
            constructor = UnitEntity::create;
            
            weapons.add(new Weapon("electric-orb-launcher"){{
                x = 0f;
                reload = 180f;
                mirror = false;
                shootSound = Sounds.laser;
                shoot.shots = 3;
                shoot.shotDelay = 20f;
                bullet = IonBullets.energyOrbBullet;
            }});
        }};
        
        geometry = new UnitType("geometry"){{
            flying = true;
            health = 9850f;
            armor = 13.5f;
            speed = 0.9f;
            accel = 0.4f;
            drag = 0.07f;
            engineSize = 7f;
            engineOffset = 22f;
            hitSize = 33f;
            rotateSpeed = 2f;
            
            constructor = UnitEntity::create;
            
            weapons.add(new Weapon("geo-launcher"){{
                x = 0f;
                reload = 258f;
                mirror = false;
                
                shoot = new ShootSpread(8, 2.3f);
                shootSound = Sounds.laser;
                
                shoot.firstShotDelay = IonFx.geometryCharge.lifetime;
                shoot.shotDelay = 6f;
                
                bullet = IonBullets.geometricBullet;
            }});
        }};
        
        xeus = new UnitType("xeus"){{
            flying = true;
            health = 25380f;
            armor = 18f;
            speed = 0.65f;
            accel = 0.45f;
            drag = 0.06f;
            engineSize = 9f;
            engineOffset = 26f;
            hitSize = 47f;
            rotateSpeed = 0.8f;
            
            constructor = UnitEntity::create;
            
            weapons.add(new Weapon("energy-laser"){{
                x = 0f;
                y = -7f;
                reload = 660f;
                mirror = false;
                continuous = true;
                shootSound = Sounds.beam;
                
                shoot.firstShotDelay = IonFx.chargeEffect.lifetime;
                
                bullet = IonBullets.xeusLaser;
            }});
        }};
    }
}
