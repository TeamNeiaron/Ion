package ion.ui.dialogs

import arc.scene.ui.*
import arc.scene.ui.layout.*
import mindustry.ui.dialogs.*

import ion.game.*
import ion.defs.*
import ion.content.*

open class AchievementDisplayDialog : BaseDialog{
    constructor() : super("Achievement"){
        addCloseButton()
    }
    
    fun show(ach: Achievement){
        cont.clear()
        val dat = ach.data(true)
        val t = Table()
        t.margin(10f)
        
        t.table(){ s: Table ->
            if(ach.isUnlocked()){
                s.add("[accent]${dat[0]}[]").row()
                s.add("Description: ${dat[1]}").row()
            } else {
                for(i in 0..1){
                    s.add("???").row()
                }
            }
        }
        
        val s = ScrollPane(t)
        cont.add(s)
        show()
    }
}
