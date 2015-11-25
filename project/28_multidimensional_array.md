# 28. Can you do multi-dimensional arrays? 


How? Are there limits? C and Java both allow this. Java even has some support for it.


## Answer: yes!

Clojure even has a function to build multi-dimensional arrays with specified dimension and length. There seems to be no but memory's limit to its maximum dimension. 


```clojure
user> (pprint (make-array Integer/TYPE 4 2))
[[0, 0], [0, 0], [0, 0], [0, 0]]
```

From [clojuredoc (link)](https://clojuredocs.org/clojure.core/make-array).




