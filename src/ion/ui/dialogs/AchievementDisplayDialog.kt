package ion.ui.dialogs

import arc.scene.ui.ScrollPane
import arc.scene.ui.layout.Table
import com.github.mnemotechnician.mkui.extensions.dsl.addImage
import ion.game.Achievement
import mindustry.ui.dialogs.BaseDialog

open class AchievementDisplayDialog : BaseDialog("Achievement") {
    init{
        addCloseButton()
    }
    
    fun show(ach: Achievement){
        cont.clear()
        val dat = ach.data(true)
        val t = Table()
        t.margin(5f)
        
        t.table{ s: Table ->
            if(ach.isUnlocked()){
                s.addImage(ach.icon).size(165f).row()
                s.add("[accent]${dat[0]}[]").row()
                s.add("Description: ${dat[1]}").row()
            } else {
                for(i in 0..2){
                    s.add("???").row()
                }
            }
        }
        
        val s = ScrollPane(t)
        cont.add(s)
        show()
    }
}
