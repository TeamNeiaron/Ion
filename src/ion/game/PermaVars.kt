package ion.game

import arc.Core.settings

import kotlin.reflect.KProperty

/** Variable sets that are saved to your save file. Does not reset when the game is closed. */
object PermaVars{
    var testInt by intSetting()
    var testFloat by floatSetting()
    var testString by stringSetting()
    var testBool by boolSetting()
    var testByteArr by byteArraySetting()
    var killCount by intSetting()

    fun intSetting(prefix: String = "ion-") = IntSettingDelegate(prefix)
    
    fun floatSetting(prefix: String = "ion-") = FloatSettingDelegate(prefix)
    
    fun stringSetting(prefix: String = "ion-") = StringSettingDelegate(prefix)
    
    fun boolSetting(prefix: String = "ion-") = BooleanSettingDelegate(prefix)
    
    fun byteArraySetting(prefix: String = "ion-") = ByteArraySettingDelegate(prefix)

    class IntSettingDelegate(val prefix: String){
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Int{
                return settings.getInt("$prefix${property.name}")
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int){
                settings.put("$prefix${property.name}", value)
        }
    }
    
    class FloatSettingDelegate(val prefix: String){
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Float{
                return settings.getFloat("$prefix${property.name}")
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Float){
                settings.put("$prefix${property.name}", value)
        }
    }
    
    class StringSettingDelegate(val prefix: String){
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String{
                return settings.getString("$prefix${property.name}")
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
                settings.put("$prefix${property.name}", value)
        }
    }
    
    class BooleanSettingDelegate(val prefix: String){
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean{
                return settings.getBool("$prefix${property.name}")
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean){
                settings.put("$prefix${property.name}", value)
        }
    }
    
    class ByteArraySettingDelegate(val prefix: String){
        operator fun getValue(thisRef: Any?, property: KProperty<*>): ByteArray{
                return settings.getBytes("$prefix${property.name}")
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: ByteArray){
                settings.put("$prefix${property.name}", value)
        }
    }
}
