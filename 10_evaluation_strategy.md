## 10. evaluation strategy

Clojure is partly a lazy language [@fogus2014joy].

Normally, Clojure uses _eager_ evaluation, which starts from the innermost parenthesis and works its way outwards. Notice that in Clojure, the precedence of operators is __not__ a problem because of all the `(((((())))))`’s.


```clojure
;; 4 + 2 is eagerly evaluated first
;; then 7 * 6
usr => (* 7 ( + 4 2))
42
```

When dealing with sequence types, Clojure uses lazy evaluation. For instance, Clojure only “takes” what it needs:


```clojure
;; (range) is a sequence of 0 to infinite int's
usr=> (take 2 (range))
;; universe is still intact because Clojure is lazy
(0 1)
```