# 17. regular expression support in a library? Java has a regular expression library (so does Python).

In Clojure, a regular expressions is a string prefixed with a hashtag [@rathore2011clojure]. Clojure’s regular
expression uses Java’s regex. Regular expression is listed as one of the scalar literals in [@rathore2011clojure], and called “first-class data type” in [@fogus2014joy].


```clojure
clojure-noob.core> (class #"gneiss")
java.util.regex.Pattern
```


There are mainly four things we do with regular expressions:

1. recognize
2. search
3. capture / backreference
4. replace

## Recognize

Clojure has `re-matches` that returns true only if the entire given string matches the regular expression given.

```clojure
user> (re-matches #"[+-]?[0]*[0-9]+" "-3")
"-3"
user> (re-matches #"[+-]?[0]*[0-9]+" "-3.14")
nil
user> (re-matches #"[0-4]?[3-9]+(6*[2-4a-e]+)*" "176a3b62")
["176a3b62" "62"]
TODO: what does this mean?
```

## Search

TODO
Search inside a string for a regular expression. In general, languages can adopt one of the two options for searching:

1. greedy - returns the longest portion of the string that matches.
2. non-greedy - returns the first part of the string that matches. (clojure's choice)

Clojure has `re-find` that does searching.


```Clojure
;; always the first match
user> (re-find #"fo*" "fooofooooooooo")
"fooo"
;; so it does non-greedy
user> (re-find #"fo*" "fooofo")
"fooo"
```
