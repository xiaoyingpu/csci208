
# 25. What math operations can you do on numbers? Is this different for characters and other integer-like types? Does it allow math that makes no sense?


Clojure’s core[9] supports: `+ - * / inc dec quot rem min max`. It also supports comparisons: `== < <= > >= zero? pos? neg?`. Outside the core, clojure.math.numeric-tower provides exponents, ceiling, floor functions and more[10]. There is also the clojure.math.combinatorics to do discrete maths[11].


``` clj
;; \a is the character 'a'
user> (+ \a 1)
ClassCastException 
```

No Clojure does not do nonsense math.


[9] <https://github.com/clojure/clojure/blob/bdc752a7fefff5e63e0847836ae5e6d95f971c37/src/clj/clojure/core.clj>

[10] <https://github.com/clojure/math.numeric-tower>

[11] <https://github.com/clojure/math.combinatorics>