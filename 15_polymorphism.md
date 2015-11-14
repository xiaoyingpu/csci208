# 15 polymorphism. Most languages have some support for this. Haskell has a ton of it. 

Answer: Clojure has a ton of it, too.

We covered three types of polymorphism:

1. adhoc / overloading polymorphism
2. Inclusion polymorphism
3. parametric polymorphism



## Ad hoc / Overloading

Many functions, same name. In Clojure, a dispatch function, `greeting` in this case, is called first, then the right method is called  based on the dispatch value.

```clojure
;; greeting is a dispatch function 
(defmulti greeting
  "The multimethod greeting"
  ;; dispatch depends on the key "language"
  ;; the param is a map, which can be considered a function and the 
  ;; argument given is "language"
  (fn [x] (x "language")))
;; lots of greeting here, so ad hoc polymorphism
(defmethod greeting "English"  [_]
  "Returns the appropriete greeting"
  "Hello!")
(defmethod greeting "Deutsch"  [_]
  "Hallo!")
(defmethod greeting :default params [_]
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

## Inclusion / Subclass / Subtype / Inheritance

Clojure allows inheritance relationships among data types or even among symbols [@fogus2014joy]. `defrecord` defines a Cartesian product (class), and `defprotocol` defines Java's equivalence of a interface, without implementation.

```clojure
;; defprotocol does not define class members like name
(defprotocol Walkable
  (walk [this]))
;; Walkable -> Human
(defrecord Human [name]
  ;; Java equiv of implements Walkable
  Walkable
  ;; defining the concrete method
  (walk [this] "Human walks"))
;; Walkable -> Dog
(defrecord Dog [name]
  Walkable
  (walk [this] "Woof"))
```

Output:

```clojure
user> (walk (Dog. "name"))
"Woof"
user> (walk (Human. "the killers"))
"Human walks"
```

## Parametric Polymorphism

Functions that can be applied on different types. Clojure has it.

```clojure
(defn head
 "clojure collection methods are 
  excellent examples of parametric functions"
  [coll]
   ;; returns head of the coll.
   (first coll))
```


```clojure
;; map, returns the first key-value pair
user> (head {:a "a", :b "b"})
[:a "a"]
;; vector
user> (head [1,2,3])
1
;; list
user> (head `(1 2 3))
1
```

Also see: [8thlight](https://blog.8thlight.com/myles-megyesi/2012/04/26/polymorphism-in-clojure.html), [clojuredoc/defmulti](https://clojuredocs.org/clojure.core/defmulti), [clojuredoc/defprotocol](https://clojuredocs.org/clojure.core/defprotocol).
