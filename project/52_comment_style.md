# 52. What comment stypes does it support?


Clojure has two ways of commenting:

1.  commenting out a line with `;`
2.  commenting out a form with `#_`


``` clojure
; This is a comment
;; but using two of ;'s is more common
user=> (if true (:answer) (+ 1 41))
IllegalArgumentException Wrong number of args
;; #_ comments out a pair of ()
user> (if true #_(:answer) (+ 1 41))
42
;; #_ works for [] as well
user> (if true #_[0] [42])
[42]
```

See [this Clojure style guide @ github](https://github.com/bbatsov/clojure-style-guide).
