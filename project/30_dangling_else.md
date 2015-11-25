# 30. What about dangling else? Is it a problem? If yes, how does it handle it? if not, why is it not a problem? It is a problem in both C and Java but not in Haskell

## Answer: no

Since Clojure is fully-paranthesized, there is no such problem as dangling else; every `else` knows which `if` it belongs to.

```clojure
(defn funk []
  (if true
    (if false 
      ;; execute this line if true
      (println "nested")
      ;; execute this line if false
      ;; there is no keyword else anyways....
      (println "this else knows....")))
    ;; meanwhile outside the parenthesis: 
    (println "Am I getting printed?))
```

Output:

```clojure
user> (funk)
this else knows.... ;; to whom it belongs
nil
```


## More about `if`

The argument in case of `else` condition is optional. Since Clojure has all expressions, `if` always returns something. If nothing is supplied to the `else` condition, Clojure defaults to return nil. 

```clojure
;; prototype: (if test then else?)
;; then clause = "try dangling"
;; else? is missing here
user> (if false "try dangling")
nil ;; default
```


See [clojure.core](https://clojuredocs.org/clojure.core/if). 
