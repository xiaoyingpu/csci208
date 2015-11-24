# 14. Anonymous functions

As a functional language, Clojure uses a special form to build anonymous, or unnamed, functions [@fogus2014joy].

```clojure
;; This function has no name
((fn [n]     ;; a vector of function params, n
  (* 3 n))            ;; return value = 3 * n
 2)                  ;; passing in param
```

Output:


```
6                       ;; return value
```

There is also a reader feature to define in-place functions using `#()`.


``` clojure
usr> (#(* 3 %) 2)  
;; The % implicitly declares the accepted argument
```
Adapted from [@koan] and [@fogus2014joy].


