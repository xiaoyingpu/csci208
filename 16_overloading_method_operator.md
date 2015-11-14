# 16. overloading of method names or operators. Java allows overloaded method names.

In Clojure, operators are plain functions [@fogus2014joy] (p. 13).
Overloading is possible for both methods and operators. In practise, it
is better to use multimethods than simply overloading functions,
especially basic operators like +[^15].


```clojure
;; attempt to overload + operator
user> (defn + [x] 0)
;; compiler gives a warning
WARNING: + already refers to: #'clojure.core/+ in 
namespace: user, being replaced by: #'user/+
#'user/+
;; but the evil definition is used anyways
user> (+ 3)
0
;; what an awful thing to do
```
Source: my humble concoction.


## Overloading methods

## Arity overloading
Clojure also comes with overloaded methods. Clojure does arity
overloading within a single function definition. Below is a snippet of
the source code for + operator in `clojure.core`.


```clojure
(defn +
  "Returns the sum of nums. (+) returns 0. Does not auto-promote
  longs, will throw on overflow. See also: +'"
  {:inline (nary-inline 'add 'unchecked_add)
   :inline-arities >1?
   :added "1.2"}
  ([] 0)            ; no argument
  ([x] (cast Number x)) ; one argument
  ([x y] (. clojure.lang.Numbers (add x y))) ; 2
  ([x y & more]                              ; or more
     (reduce1 + (+ x y) more)))
```
See [github](https://github.com/clojure/clojure/blob/master/src/clj/clojure/core.clj)

### Ad hoc polymorphism

See question 15, discussion on `defrecord` and `defprotocol`.
