package ion.content;

import arc.graphics.Color;
import ion.defs.IColor;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;

import ion.entities.bullet.*;

public class IonBullets{
    public static BulletType
    
    //geometry
    geometricBullet, energyOrbBullet, xeusLaser;
    
    public static void load(){
        geometricBullet = new GeometricBulletType(3, 10){{
            damage = 370f;
            speed = 3.4f;
            lifetime = 72f;
            hitSize = 15f;
            spinSpeed = 3.4f;
            pierce = true;
            pierceBuilding = true;
            pierceCap = 3;
            chargeEffect = IonFx.geometryCharge;
            color = IColor.energy;
            trailEffect = Fx.trailFade;
            trailWidth = 7.5f;
            trailLength = 17;
            trailColor = IColor.energy;
        }};

        energyOrbBullet = new UnstableEnergyBulletType(0.2f){{
            damage = 67f;
            speed = 2.7f;
            lifetime = 120f;
            hitSize = 4.8f;
            pierce = true;
            pierceBuilding = true;
            pierceCap = 2;
            lightningLength = 7;
            lightningDamage = 8f;
            lightningColor = IColor.energy;
            color = IColor.energy;
        }};

        xeusLaser = new SparkingContinuousLaserBulletType(0.4f){{
            lifetime = 360f;
            length = 388f;
            width = 4f;
            damage = 85f;
            colors = new Color[]{
                    IColor.energy,
                    IColor.lightEnergy,
                    Color.white
            };
            despawnEffect = Fx.smokeCloud;
            shootEffect = IonFx.xeusCharge;
            lightningDamage = 760f;
            lightningLength = 45;
            lightningColor = IColor.lightEnergy;
        }};


    }
}
