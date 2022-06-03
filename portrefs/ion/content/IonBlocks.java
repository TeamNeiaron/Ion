package ion.content;

import mindustry.type.*;
import mindustry.world.blocks.units.*;

import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.world.Block;

public class IonBlocks{
    public static Block
    
    geoEnergeticAirFactory, gonicReconstructor;
    
    public static void load() {
        geoEnergeticAirFactory = new UnitFactory("geo-energetic-air-factory") {{
            requirements(Category.units, ItemStack.with(
                    Items.lead, 550,
                    Items.silicon, 80,
                    Items.metaglass, 80,
                    Items.titanium, 250,
                    IonItems.zinc, 30

            ));
            
            health = 450;
            size = 3;
            consumePower(2f);
            plans.addAll(new UnitPlan(IonUnitTypes.orion, 20f * 60, ItemStack.with(
                        Items.silicon, 10,
                        Items.titanium, 25,
                        IonItems.zinc, 5
                ))
            );
        }};
        
        gonicReconstructor = new Reconstructor("gonic-reconstructor"){{
            requirements(Category.units, ItemStack.with(
                Items.copper, 570,
                Items.lead, 480,
                Items.silicon, 95,
                Items.titanium, 300,
                IonItems.zinc, 55
            ));
            
            health = 670;
            size = 3;
            consumePower(2.4f);
            consumeItems(ItemStack.with(Items.lead, 30, Items.titanium, 25, Items.silicon, 45, IonItems.zinc, 20));
            
            upgrades.add(
                new UnitType[]{IonUnitTypes.orion, IonUnitTypes.xender}
            );
        }};
    }
}
