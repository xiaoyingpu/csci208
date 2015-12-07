# 38. In what order are parameters to a function evaluated? 

_Left to right? right to left? middle outwards? not guaranteed?_


## Answer: left to right.

According to Clojure's offical site, the arguments for a function are evaluated from left to right, see [(link)](http://clojure.org/evaluation). Since Clojure uses lazy evaluation also, there is no good code example for this left-to-right property.