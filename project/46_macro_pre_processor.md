# 46. language pre-processors and macros



The _times_ in Clojure:

- read time
- _macro-expansion time_
- compile time 
- run-time


```clojure
user> (-> 25 Math/sqrt list)
(5.0)
user> (macroexpand `(user> (-> 25 Math/sqrt list)))
(user/user> (clojure.core/-> 25 java.lang.Math/sqrt clojure.core/list))
```