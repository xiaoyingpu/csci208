# 46. Language pre-processors and macros

## Answer: yes Clojure have them

The _times_ in Clojure [@fogus2014joy]:

- read time
- _macro-expansion time_
- compile time 
- run-time

Clojure's macro-expansion can be viewed as pre-processing [@kingsbury].  During this phase prior to compilation, the Clojure code is restructured. 

```clojure
;; use macroexpand to see what's under the hood
user> (macroexpand `(-> 25 Math/sqrt list))

;; expanded version
(clojure.core/list (java.lang.Math/sqrt 25))

;; the expressions evaluate to 5 as expected
user> (-> 25 Math/sqrt list)
(5.0)
user> (clojure.core/list (java.lang.Math/sqrt 25))
(5.0)
```

## Macros compared: Clojure and C


The C preprocessor uses its own syntax (not C) and operates _on text_. Since Lisp / Clojure has the philosophy of "data is code is data", macro-expansion is written in Clojure and happens on data structures.  In fact, many more fundamental functions in Clojure are written as macros, and users can rewrite them or define their own macros [@kingsbury]. 


```clojure
;; source code for operator and
user> (source and)
(defmacro and
  ([] true)
  ([x] x)
  ([x & next]
   `(let [and# ~x]
      (if and# (and ~@next) and#))))
nil

;; overwriting the macro
user> (defmacro and
  ([x y] (println "oops")))
#'user/and
user> (and 1 2)
oops
nil
```


