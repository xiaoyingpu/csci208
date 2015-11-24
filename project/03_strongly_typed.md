# 3. Untyped vs weakly typed vs strongly typed

Clojure is strongly typed, at least stronger than Java; see the tests below.


``` clojure
;; Clojure is typed, see the cast exception
usr=> (/ \a 1)
ClassCastException java.lang.Character cannot be cast to
java.lang.Number  clojure.lang.Numbers.divide 
(Numbers.java:159)
;; Clojure being unable to cast character into int
;; does not do nonsense math
;; => Stronger than Java

usr=> (/ 1 4.2)
0.23809523809523808
;; Coerced 1, an int, into floating point
;; => weaker than Ada
```



