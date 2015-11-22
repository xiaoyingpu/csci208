# 49. What are the regular expressions for its tokens? 

(Give a regular expression to describe each category of literals - integers, booleans, etc).

## Answer

Snippets found in Clojure source code: 

## Numbers

``` clj
;; integer
(def ^Pattern int-pattern #"([-+]?)(?:(0)|([1-9][0-9]*)|
0[xX]([0-9A-Fa-f]+)|0([0-7]+)|
([1-9][0-9]?)[rR]([0-9A-Za-z]+)|
0[0-9]+)(N)?")

;; ratio
(def ^Pattern ratio-pattern #"([-+]?[0-9]+)/([0-9]+)")

;; float
(def ^Pattern float-pattern #"([-+]?[0-9]+(\.[0-9]*)?
([eE][-+]?[0-9]+)?)(M)?")
```
Clojure reader.clj can be found at [github](https://github.com/clojure/tools.reader/blob/master/src/main/clojure/clojure/tools/reader/impl/commons.clj).



## Keywords

_Clojure Programming_ says that a keyword always starts with a `:`, and is followed by any non-white characters.

```clj
(def ^Pattern keyword-pattern #":[^\space\tab\newline\formfeed\return\backspace]+")

;; verify
user> (def akey :-)
#'user/akey
user> ({:- 3} :-)
3 ;; OK
```
