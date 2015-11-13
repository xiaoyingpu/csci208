# 17 polymorphism. Most languages have some support for this. Haskell has a ton of it. 

Answer: Clojure has a ton of it, too.

We covered three types of polymorphism:

1. adhoc / overloading polymorphism
2. Inclusion polymorphism
3. parametric polymorphism


## Inclusion

TODO: really?

Clojure allows inheritance relationships among data types or even among symbols [@fogus2014joy].

## Ad hoc

A dispatch function, `greeting` in this case, is called first, then the right method is called  based on the dispatch value.

```clojure
;; greeting is a dispatch function 
(defmulti greeting
  "The multimethod greeting"
  ;; dispatch depends on the key "language"
  (fn [x] (x "language")))
;; lots of greeting here, so ad hoc polymorphism
(defmethod greeting "English"  []
  "Returns the appropriete greeting"
  "Hello!")
(defmethod greeting "Deutsch"  []
  "Hallo!")
(defmethod greeting :default params []
  (throw (IllegalArgumentException.
  (str "Kein " (params "language")))))


;; defining maps here
;; the combination "language": "English"
;; makes the dispatcher calls the appropriate method
(def english-map { "id" "1" "language" "English"})
(def deutsch-map {"id" "2" "language" "Deutsch"})
(def espano-map {"id" "3" "language" "Espano"})
```
Output:
```clojure
clojure-noob.core> (greeting deutsch-map)
"Hallo!"
clojure-noob.core> (greeting espano-map)
IllegalArgumentException Kein Espano 
clojure-noob.core/eval3459/fn--3460 (core.clj:27)
```


Also see: [8thlight](https://blog.8thlight.com/myles-megyesi/2012/04/26/polymorphism-in-clojure.html), [clojuredoc](https://clojuredocs.org/clojure.core/defmulti)
