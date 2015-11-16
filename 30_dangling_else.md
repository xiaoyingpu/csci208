# 30. What about dangling else? Is it a problem? If yes, how does it handle it? if not, why is it not a problem? It is a problem in both C and Java but not in Haskell

Since Clojure is fully-paranthesized, there is no such problem as dangling else; every `else` knows which `if` it belongs to.

```clojure
(defn funk []
  (if true
    (if false 
      ;; execute this line if true
      (println "nested")
      ;; execute this line if false
      ;; there is no keyword else anyways....
      (println "this else knows...."))))
```

Output:

```clojure
user> (funk)
this else knows....
nil
```


## More about `if`

Since Clojure has all expressions, `if` always returns something. The argument in case of `else` condition is optional. Specifically, if nothing is supplied to the `else` condition, Clojure defaults to return nil. It is a problem in that user does not have to specify anything for the dangling else; on the other hand, something is always returned.

``` clj
;; prototype: (if test then else?)
;; then clause = "try dangling"
;; else? is missing here
user> (if false "try dangling")
nil ;; default
```


See [clojure.core](https://clojuredocs.org/clojure.core/if). 
