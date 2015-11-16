# Partially apply constructor of a class?

Since Haskell and Ocaml take different design decisions about this...

Yes, we can use `partial` to do things similar to currying.

Define a class:
```clojure
(deftype Animal [name age])
```

In use:
```clojure
;; a java class indeed
user> (class Animal)
java.lang.Class

user> (map (partial #(Animal. 11 %)) [1 2 3])
(#object[user.Animal 0x52845f1 "user.Animal@52845f1"] #object[user.Animal 0x5857a1a1 "user.Animal@5857a1a1"] #object[user.Animal 0x4ec5bfca "user.Animal@4ec5bfca"])
```

