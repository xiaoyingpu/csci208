# 42. Does it diferentiate between/allow use of procedures or functions?

## Answer: there is no procedure

In Clojure, an expression always returns something (`nil` for instance) [@fogus2014joy]. There is no such thing as procedure in Clojure.


```clojure
;; even print returns something
user> (println "yeah")
yeah
nil
```