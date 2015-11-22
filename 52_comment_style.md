52. What comment stypes does it support?
----------------------------------------

Clojure has two ways of commenting:

1.  commenting out a line with `;`

2.  commenting out a form with `#_`


``` clj
; This is a comment
;; but using two of ;'s is more common
;; #_ comments out a pair of ()
user> (if true #_(:answer) (+ 1 41))
42
;; #_ works for [] as well
user> (if true #_[0] [42])
[42]
```

