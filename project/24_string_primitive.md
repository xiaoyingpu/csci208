# 24. Is string a primitive type? 

(In C++ it is, in Java, C, Haskell, ... it is not). What math operations can you do on strings? (s+s, s*3) What other operations are provided for strings? (none, substring, index of). Is there a concept of a terminating character like the NULL in C?


## Answers

* According to its inventor, Clojure String is one of the _atomic data types_;  an array of characters is not the same as a string in Clojure (see [this video of Hickey's](https://www.youtube.com/watch?v=P76Vbsk_3J0&list=WL&index=4)).
* Clojure does not do string math (+, *), otherwise `ClassCastException` will occur.
* There is a rich API for string manipulation, including:
	* reverse
	* replace
	* join
	* index-of
	* subs (substring)
* No there is no such thing as not having null-terminated the String and the program seg faults.

## Exmaple of substring

```clojure
user> (subs "01234" 1 3)
"12"
```
See [clojure source code](https://github.com/clojure/clojure/blob/master/src/clj/clojure/string.clj).
