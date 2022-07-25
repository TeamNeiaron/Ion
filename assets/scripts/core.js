function getInstance(name){
    return Reflect.get(Vars.mods.getMod("ion").loader.loadClass(name), "INSTANCE")
}

//objects
const Utils = getInstance("ion.misc.Utils")
const TempVars = getInstance("ion.game.TempVars")
const PermVars = getInstance("ion.game.PermVars")
const IonAchievements = getInstance("ion.content.IonAchievements")
const IonVars = getInstance("ion.IonVars")
const IonUnitTypes = getInstance("ion.content.IonUnitTypes")
const IonBlocks = getInstance("ion.content.IonBlocks")
const IonStatusEffects = getInstance("ion.content.IonStatusEffects")
const IonBullets = getInstance("ion.content.IonBullets")
const IonFx = getInstance("ion.content.IonFx")
const IonItems = getInstance("ion.content.IonItems")
const IonTechTree = getInstance("ion.content.IonTechTree")
const IColor = getInstance("ion.misc.IColor")
const IDraw = getInstance("ion.misc.IDraw")
const ISettings = getInstance("ion.ui.ISettings")
const YellowUnitTypes = getInstance("ion.hiearchy.yellow.content.YellowUnitTypes")
