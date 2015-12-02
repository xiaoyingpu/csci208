# 20. Can a user define types (beyond the given type constructors)? If so, how? (typedef or #define in C)


There are three main type features in Clojure (see [clojure.org/datatypes](http://clojure.org/datatypes)):

* `deftype`
* `defrecord`
* `reify`

Both `deftype` and `defrecord` generate _named_ classes dynamically.




## Example usage of deftype:


```clojure
;; defining the type
;; constructor takes two parameters, name & age
(deftype Animal [name age])

;; check: a java class indeed
user> (class Animal)
java.lang.Class

;; Usage

(deftype Animal [name age])
(def dog (Animal. "Worf" 10))
```

Output:


```clojure
user> (.name dog)
"Worf"  ;; success
```
