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

Clojure does allow type hints. Type hints can be useful for improving performance when interopping with Java [@emerick2012clojure].

```clojure
(defn length
  ;; java's String class
  [^String s]
  (.length s ))
```

Output:
```clojure
user> (length "dfd")
3
user> (length [1])
;; look, type error
ClassCastException clojure.lang.PersistentVector cannot be cast 
to java.lang.String  user/length (test.clj:77)
```

