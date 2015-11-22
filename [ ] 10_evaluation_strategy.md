# 10. evaluation strategy

Clojure is partly a lazy language [@fogus2014joy].


## Strict 

Normally, Clojure uses _eager_ evaluation, which starts from the innermost parenthesis and works its way outwards. Notice that in Clojure, the precedence of operators is __not__ a problem because of all the `(((((())))))`’s.


```clojure
;; precedence is not a problem here
usr => (* 7 ( + 4 2))
42
```

### Example with side-effect to show strict evaluation

Try:
```clojure
;; a is immutable tho

```

Output:

## Lazy

If clojure used call-by-name, then Clojure would have printed two `tri`'s because function `tri` should be called twice on the line `(* x x)`. (Clojure data is basically immutable, so there is no eazy way to increment that global `a`.)



When dealing with sequence types, Clojure uses lazy evaluation. For instance, Clojure only “takes” what it needs:


```clojure
;; (range) is a sequence of 0 to infinite int's
;; it did not compute the entire list
usr=> (take 2 (range))
;; universe is still intact because Clojure is lazy
(0 1)
```


