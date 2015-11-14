# 12. higher order functions. Haskell supports these in many ways. C lets you pass functions into a function which is higher order but that's it.

A higher order function is defined such that it takes functions as arguments, and / or it returns a function as a result [@fogus2014joy] (Ch.7.1.2).

## Functions as arguments

There are three important high order functions in Clojure [@fogus2014joy] (Ch 6.3.4).

- `map`: applies the function passed in as argument to the provided
    sequence, and returns another sequence as the result.
- `reduce`: applies the given function to the first two items in the
    collection; it then take the intermediate result and apply the
    function with the third item and so forth.
- `filter`: applies the function to every item in the collection; if
    function returns false for an item, this item is filtered out.



```clojure
;; =============== map ===================
;; dec decreases the value of argument by 1;
;; dec as a function, is one of the two arguments
;; map applies dec to every element in [0 42]
;; A new sequence is returned.
user=> (map dec [0 42])
(-1 41)

;; using map to get columns of a 2D array
user=> (map vector [:x :1] [:y :2] [:z])
;; map stops when one of the sequence runs out
([:x :y :z]) ;; so no [:1 :2] here

;; =============== reduce ================
;; Go Gauss!
;; range returns a lazy sequence from 1 to 100, inclusive
;; Step 1: 1 + 2 = 3
;; Step 2: 3 + 3 = 6
;; Step 3: 6 + 4 = 10 and so forth
;; The sequence is "reduced" to 5050, the sum of all items
user=> (reduce + (range 1 101))
5050

;; ============= filter ==================
;; even? is a function
user=> (filter even? (range 41 43))
;; between 41 and 42, inclusive
(42) ;; 42 is even!
```

Adapted from [@empty].

## Functions as return values

Clojure has three important functions in this category [@fogus2014joy]:

- `comp` takes a set of functions and return a composition function.
    The returned function will apply the set of functions from the right
    most to the left.
- `partial` takes a function f that expects n arguments, and x
    arguments of f. `partial f args`. Returns a fn that takes y
    arguments, such that $x + y = n$.
- `complement` returns the opposite truth value for the argument
    function passed in.

It is also possible to define a new function that returns a function.


```clojure
;; =============== comp ===================
;; First, -84/2 = -42
;; Second, -(-42)
;; Applied from right to left
user=> ((comp - /) -84 2)
42

;; =============== partial ================
;; Partial returns a fn: "4" + ?
;; then fn found its other arg to be "2"
;; In Haskell you get the currying for free tho.
user=> ((partial str "4") "2")
"42"

;; ============= complement ==================
;; (complement odd?) effectively returns an even? function
user=> (filter (complement odd?) (range 41 43))
(42)
```

Definitions adapted from [clojuredoc](https://clojuredocs.org).
