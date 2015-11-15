# 19. Implicitly or explicitly typed? 

For example, In C all declarations are explicitly typed (globals and parameters and local variables are declared with types, struct fields are declared with types, even functions have explicit return types). In Python or Ocaml, the answer is very different.

## Answer

Clojure is implicitly typed. 

Declaraing a `var`:
```clojure
;; not type info involved
user> (def a 42)
```

A function:
```clojure
;; no type info for param or return type
user> (defn foo [x] (+ 2 x))
```

### Type hint

Clojure does allow type hints, which are not required. Type hints are useful for improving performance. 


See 

