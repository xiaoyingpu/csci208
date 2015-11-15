# 17. regular expression support in a library? Java has a regular expression library (so does Python).

In Clojure, a regular expressions is a string prefixed with a hashtag [@rathore2011clojure]. Clojure’s regular
expression uses Java’s regex. Regular expression is listed as one of the scalar literals in [@rathore2011clojure], and called “first-class data type” in [@fogus2014joy].


```clojure
clojure-noob.core> (class #"gneiss")
java.util.regex.Pattern
```

TODO
* Design decision clojure took: * eager / non-eager?


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
```

## Search


