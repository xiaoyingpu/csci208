# 11. built in list comprehensions

Yes Clojure has list comprehensions using macro `for`.



```clojure
;; (for sequence-exprs body-expr)
;; python equiv of for x in range(3):
usr => (for [x (range 3)] (* x x))
;; returns a new list
(0 1 4)
```
Do some combinations:
```clojure
user> (for [x [1 2 3] y [4 5 6]] [x y])
([1 4] [1 5] [1 6] [2 4] [2 5] [2 6] [3 4] [3 5] [3 6])
```
Nested:
```clojure
user> (for [x (for [y (range 3)] (+ y 100))] (* x x))
(10000 10201 10404)
```
See [clojuredoc](https://clojuredocs.org).
