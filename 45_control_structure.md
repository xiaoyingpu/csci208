# 45. What control structures does it use? For instance C has an old style ?: for selection.

Clojure has two types of flow control: normal and exceptional (see [here](https://clojuredocs.org/quickref)).

* Normal types of control structures include the usual if, if-let, when, when-let, cond, do, eval, loop and more.  
*  Exceptional circumstances include assert and try-catch.


``` clj
;; if 
user=> (if nil "not" "is nil")
"is nil"

;; when-let is useful for dealing with empty collection
(defn get-head
  [coll]
  (when-let [handle (seq coll)]
    (first handle)))
```

Output:
```clojure
user=> (get-head [1,43,34])
1
user=> (get-head [])
nil
```

``` clj
;; An example for when
(defn train ;; define a function, train
    [x]     ;; that takes one argument
    (when (pos? x)  ;; when x is positive
      (println "Choo choo!")
      ;; recur is a special form that does
      ;; __tail recursion__
      (recur (dec x)))) 
```

``` clj
clojure-noob.core> (train 3)
Choo choo!
Choo choo!
Choo choo!
nil
```

See [clojuredoc](https://clojuredocs.org/clojure.core/when-let).

