# 17 polymorphism. Most languages have some support for this. Haskell has a ton of it. 

Answer: Clojure has a ton of it, too.

We covered three types of polymorphism:
1. adhoc / overloading polymorphism
2. Inclusion polymorphism
3. parametric polymorphism

## Inclusion
Clojure allows inheritance relationships among data types or even among symbols @fogus2014joy (@fogus2014joy).
```clojure
(defmulti greeting
  "The multimethod greeting"
  (fn x () (x "language")))
(defmethod greeting "English"  ()
  "Returns the appropriete greeting"
  "Hello!")
(defmethod greeting "Deutsch"  ()
  "Hallo!")
(defmethod greeting :default params ()
  (throw (IllegalArgumentException.
  (str "Kein " (params "language")))))
 
(def english-map "id" "1" "language" "English")
(def deutsch-map "id" "1" "language" "Deutsch")
(def espano-map "id" "3" "language" "Espano")
```
Output:
```clojure
clojure-noob.core> (greeting deutsch-map)
"Hallo!"
clojure-noob.core> (greeting espano-map)
IllegalArgumentException Kein Espano 
clojure-noob.core/eval3459/fn--3460 (core.clj:27)
```
