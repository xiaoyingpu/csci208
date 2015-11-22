# 2. static vs dynamic typing. duck typed?


Clojure, like Lisp, is dynamically typed[1]. Lisp was a pioneer in adopting dynamic typing [Paul Graham](http://www.paulgraham.com/icad.html). There are no mutable states in Clojure ([@fogus2014joy]), so the following example is a work-around to illustrate dynamic typing.


``` clj
usr=> (defn foo [x y] (/ x y)) ;; x / y
usr=> (foo \a 1) ;; char 'a' and int 1
ClassCastException java.lang.Character cannot be 
cast to java.lang.Number  clojure.lang.Numbers.
divide (Numbers.java:159)
;; So the exception came from divide operator,
;; not the type checking of foo()
;; foo() does not require args to be certain types
;; so clojure is ducked typed as well.
```

As shown in the code, Clojure is __duck typed__ as well.


[1] <https://www.quora.com/Is-Scala-faster-than-Clojure>. Michael Klishin seems to be an experienced developer of Clojure.
