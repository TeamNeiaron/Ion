package ion.content

import ion.game.*

object IonAchievements{
    lateinit var test: Achievement
    lateinit var test2: Achievement
    
    lateinit var allTest: Array<Achievement>
    
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
        
        
        allTest = arrayOf(test, test2)
    }
}
