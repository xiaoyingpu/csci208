#13. infinite lists. Haskell supports these.


Yes Clojure has those, too. With lazy evaluation, one is encouraged to `take`
a finite number of items from the infinite list without breaking the
universe.

We talk about three flavors of infinity:

1. `(range)`
2. stream
3. list comprehension

## (range)
```clojure
;; (range) returns a lazy sequence,
;; staring from the default 0 to infinity
;; Run this and see what infinity means
usr => (println (range))
;; or, just take the first two in the coll
usr => (take 2 (range))
(0 1)
;; starting infinity from i
usr => #(drop % (range))
```
See [clojuredoc](https://clojuredocs.org/clojure.core/range)

## Stream

Stream is a function that returns an infinite list. 

```clojure
;; the recursive calls go on forever
(defn fib [m n]
  ;; need to tell clojure to be lazy about this
  (cons m (lazy-seq (fib n (+ m n)))))

(defn fibs []
  (fib 1 1))
```

Output:

```clojure
user> (take 8 (fibs))
(1 1 2 3 5 8 13 21)
```

To run: in Emacs, `M-x`, select `cider-jack-in` to start REPL. For using cider in Emacs, see @brave2015.

Inspired by CSCI 208 class notes; see [stackoverflow](http://stackoverflow.com/questions/4992298/clojure-lazy-sequence-usage) for usage of `lazy-seq`.




## List comprehension

```clojure
;; (range) still does the trick
user> (take 4 (for [x (range)] (* x x)))
(0 1 4 9)
```
