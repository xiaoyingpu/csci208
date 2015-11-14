# 11. built in list comprehensions

Yes Clojure has list comprehensions using macro `for`.



```clojure
;; (for sequence-exprs body-expr)
;; python equiv of for x in range(3):
usr => (for [x (range 3)] (* x x))
;; returns a new list
(0 1 4)
```

See [clojuredoc](https://clojuredocs.org).
