# Partially apply constructor of a class?

Since Haskell and Ocaml take different design decisions about this...

## Answer: yes

Yes, we can use the higher order function `partial`.

Define a class:
```clojure
;; constructor takes two parameters, name & age
(deftype Animal [name age])
```

Applying the constructor:

```clojure
;; check: a java class indeed
user> (class Animal)
java.lang.Class

;; partial returns a function short of one parameter
user> (map (partial #(Animal. "a name" %)) [1 2 3])
;; mapped the constuctor and created a lot of animals
(#object[user.Animal 0x52845f1 "user.Animal@52845f1"] 
 #object[user.Animal 0x5857a1a1 "user.Animal@5857a1a1"] 
 #object[user.Animal 0x4ec5bfca "user.Animal@4ec5bfca"])
```

