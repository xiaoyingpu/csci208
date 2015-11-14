# 20. Can a user define types (beyond the given type constructors)? If so, how? (typedef or #define in C)


There are three main type features in Clojure:

* `deftype`
* `defrecord`
* `reify`

Both `deftype` and `defrecord` generate _named_ classes dynamically.


## deftype


