
# 39. Does it use short circuit evaluation? Are these operators with options or not as you like?


Clojure does short-circuit evaluation for `and` and `or`. Google searches yielded no trace of short-circuiting being optional.


``` clj
user> (or true 
    (do (println "no short-circuit")))
true
;; nothing prints so does short circuit
;; the operator and does the same thing
;; (and false ....) short circuits
```

See[stackoverflow (link)](http://stackoverflow.com/questions/8190417/does-clojure-have-short-circuit-logic).
