# 22. Does your language use pointers/references? 

(C allows references to anything. Java requires references to Objects and Arrays). Can you access them as references?

## Answer:


Clojure uses refs to coordinate _identities_ in a concurrent setting [@emerick2012clojure].


