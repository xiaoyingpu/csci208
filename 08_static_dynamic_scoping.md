# 8. static and/or dynamic scope.

Clojure supports both static and dynamic scopes [@fogus2014joy].

## `let` 

`let` defines locals of static scope.


``` clj
(def x 3)           ;; binds global var x to 3
;; (let [bindings*] exprs*)
;; symbols are resolved within 
(let [x 1]          ;; binds x with 1
  (let [x 42]       ;; binds x with 42
    (println x))    ;; in the inner let block
  (println x))      ;; in the outer let block
;; global var unchanged
(println x)
```
Output:

``` clj
42
1
3
```

From [@fogus2014joy](Ch.10.6.4).

## `binding`

`binding` takes a dynamic var, and the new binding affects the call stack . `binding` can allow a var to be shared safely between threads; each thread pushes / pops its own local binding of the same var, leaving the global var unchanged, nor does its local binding affect other threads. The following example only shows one simple use case of binding. 

It is not within the scope of this report to present the advantage of dynamic scoping in a concurrent context. The code examples are either not illustrative or broken in [clojuredoc](https://clojuredocs.org/clojure.core/binding) due to API change among different versions of Clojure.


``` clj
(def y 3)
#'clojure-noob.core/y
usr => (binding [y 3] (println y))
IllegalStateException Can't dynamically bind 
non-dynamic var: clojure-noob.core/y 
clojure.lang.Var.pushThreadBindings (Var.java:320)

;; has to be declared dynamic 
usr => (def ^:dynamic x 1)
usr => (binding [x 2] (println x))
2   ;; prints x is 2
nil ;; binding returns
usr => (println x)
1   ;; outside binding, x is still 1
```

From [clojuredoc](https://clojuredocs.org/clojure.core/binding) and [@fogus2014joy](Ch.10.6).
