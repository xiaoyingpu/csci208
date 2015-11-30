
# 25. What math operations can you do on numbers? Is this different for characters and other integer-like types? Does it allow math that makes no sense?



## Math operations

Clojure’s [core (link)](https://github.com/clojure/clojure/blob/bdc752a7fefff5e63e0847836ae5e6d95f971c37/src/clj/clojure/core.clj) supports: `+ - * / inc dec quot rem min max`. It also supports comparisons: `== < <= > >= zero? pos? neg?`. Outside the core, [clojure.math.numeric-tower (link)](https://github.com/clojure/math.numeric-tower) provides exponents, ceiling, floor functions and more. There is also the [clojure.math.combinatorics (link)](https://github.com/clojure/math.combinatorics) to do discrete maths.

## Math on characters?

Clojure does not  do math on characters. The closest thing is string concatenation.


``` clojure
usr> (str "one" " and another")
"one and another"	;; success
```



## Example of nonsense math

``` clojure
;; \a is the character 'a'
user> (+ \a 1)
;; ClassCastException 
```

No Clojure does not do nonsense math.





