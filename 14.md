
# 14. Anonymous functions

As a functional language, Clojure uses a special form to build anonymous, or unnamed, functions \cite{fogus2014joy}. There is also a reader feature to define in-place functions using `#()`.

```clojure
;; This function has no name
((fn [n]     ;; a vector of function params, n
  (* 3 n))            ;; return value = 3 * n
 2)                  ;; passing in param
```
Output

```
6                       ;; return value
;; ... which is the same as using #()
(#(* 3 %) 2)  
;; The % implicitly declares the accepted argument
```
Adapted from \cite{koan} and \cite{fogus2014joy}.
