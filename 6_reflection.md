# 6. Reflection (computational and structural)

Clojure has an API for clojure.reflect . It mainly reflects on the host types, such as the class of an instance. Clojure’s reflection is computational. There are two ways to do reflection:

-   Reflects on a class that implements TypeReference (type-reflect).

-   Get the class of an instance, or reflect on the class itself.

Reflection can provide a map with keys like :bases and :members.


``` clj
;; reflect on the number 42
;; getting the base classes of 42
clojure.reflect=> ((reflect 42) :bases)
;; returns a set of java classes
#{java.lang.Comparable java.lang.Number}
```

See the [API](https://clojure.github.io/clojure/clojure.reflect-api.html).
