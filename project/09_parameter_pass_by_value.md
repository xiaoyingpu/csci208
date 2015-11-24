# 9. parameter passing mechanisms


## Answer

### By value

Like Java, Clojure passes arguments by value; in the case of references, they are passed by references pointing to objects [@pass]. One way to test it is to use `identical?`, which decides if the two arguments are the same object [@empty].




``` clojure
;; define a global z with a vector
usr => (def z [1])
#'clojure-noob.core/z
;; foo takes a parameter 
;; foo uses identical? to check
usr => (defn foo [a] (identical? a z))
#'clojure-noob.core/foo
usr => (foo z)
;; the z passed in and the global z are the same obj
true    
```



