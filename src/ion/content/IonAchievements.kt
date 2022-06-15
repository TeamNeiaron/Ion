package ion.content

import ion.game.*

object IonAchievements{
    lateinit var test: Achievement
    lateinit var test2: Achievement
    lateinit var groundDominance: Achievement
    
    lateinit var all: Array<Achievement>
    
    fun load(){
        test = object : Achievement("test", "Test Achievement"){
            init{
                description = "A test achievement."
            }
        }

        test2 = object : Achievement("test-2", "Another Test Achievement"){
            init{
                description = "\"How does one obtain me?\" - The achievement curiously asks."
            }
        }
        
        groundDominance = object : Achievement("ground-dominance", "Ground Dominance"){
            init{
                description = "Capture Ground Zero."
            }
        }
        
        all = arrayOf(test, test2, groundDominance)
    }
}
