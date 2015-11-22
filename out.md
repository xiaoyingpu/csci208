![For the brave and true<span data-label="fig:my_label"></span>](http://clojure.org/file/view/clojure-icon.gif)



Phase 2: Paradigms and Features
===============================

<span>*What paradigms is your language? What features of the language support your answer? Match specific features to specific paradigms.* </span>

**Answers**

------------------------------------------------------------------------

Clojure is a dynamic languange, and it belongs to the following paradigms: functional, (beyond) object-oriented and concurrent programming.

**Dynamic**

Clojure, like its parent Lisp, is first and foremost a dynamic language . Our text may not have listed being dynamic as one of the paradigms, but it is one of the most important features of Clojure. A dynamic language determines many more things at run-time than in compile time .

-   Clojure does not require type declaration .

-   Clojure has an `eval` function to load code for execution in run-time, a feature most static languages lack .

-   REPL, Read-Eval-Print-Loop, is the primary interface for programming in Clojure. It is a console for entering and executing commands .

-   Clojure is compiled, but REPL automatically “compiles to JVM bycode on the fly” .

**Functional programming**

According to the textbook, a functional language is based on functions over types such as lists and trees. Clojure is a dialect of Lisp, a classical functional language. Clojure is suited for developing significant programs without having mutable variables, as it possesses, but not limited to, the following characteristics:

1.  Clojure functions are <span>*first-class functions*</span>. Like the more familiar integer or boolean objects, Clojure functions can be created, stored, used as function arguments and returned by other functions . In addition, it is easy to use high order functions like `map, reduce, filter` .

2.  Clojure has a fine selection of <span>*immutable*</span>, persistent data structures. Imperative languages feature the use of variables and manipulation of memory contents. By comparison, the values in Clojure is immutable ; a var in Clojure is the closest thing to a variable in imperative languages .

3.  <span>*Lazy eval*</span>: Clojure sequences are lazy, meaning that the elements are only computed when needed. It is thus possible to create list of infinite length .

4.  <span>*Anonymous functions*</span>: the keyword `fn` mentioned above created a function without a name. It takes a <span>*special form*</span> in Clojure syntax, because it is not defined in terms of functions, types or macros .

5.  <span>*Recursive looping*</span>: since Clojure does not employ mutable local variable, its implementation of <span>*for*</span> or <span>*while*</span> loop is different from imperative languages with changing states .

**Beyond Object-oriented**

Imperative programming views everything as object with mutable states; in comparison, Clojure sees the world in terms of time, state and identity. The OO in a traditional sense has traits of imperative programming baked in, contrary to Clojure’s philosophy . Clojure has a “broad support” for various paradigms ; it can implement useful aspects in OO with its functional focus and immutability features. .

1.  <span> *Polymorphism*</span> makes the system extensible and flexible. Clojure’s <span>*multimethods*</span> separates polymorphism from OO and types . Instead of having a new data type for a new situation, Clojure would rather use a large collection of functions operating on a small set of data types. See the multimethods page on .

2.  <span>*Abstraction-oriented*</span>: Clojure provides the option of <span>*ad hoc*</span> hierarchy; this form of inheritance relationship can be defined among data types and even symbols. The Clojure equivalent of interface is called `protocol`.

3.  <span>*Encapsulation*</span> hides the implementation details and enhances levels of abstraction. Clojure accomplishes encapsulation by immutability, closures and name spaces .

**Concurrent programming**

Concurrency is easy to implement with Clojure. Since Clojure runs on JVM, it uses JVM threads. Clojure has language-level support for safe and lock-free concurrency . Its basic tools for concurrency include `future`, `delay` and `promise`, which are all macros built in `clojure.core` .

Clojure provides four mechanisms that ensure <span>*controlled*</span> state changes:

1.  <span>*Macros*</span> such as ref, set, dosync expose Clojure’s software transaction memory (STM). This feature supports sharing changing states synchronously, in coordination.

2.  The <span>*Agent*</span> system also provide access to mutable states. Compared to the ref’s, Agents provide independent and asynchronous access to data residing at individual locations.

3.  <span>*Atoms*</span> share changing states in an independent and asynchronous manner between threads.

4.  A <span>*Var*</span> “refer to a mutable storage location that can be dynamically rebound (to a new storage location) on a per-thread basis.”, according Clojure’s official website.

Phase 3: Primitive Types
========================

**Question**

------------------------------------------------------------------------

<span>*What primitive types are available? (integer? boolean?) What kinds of values can they have? (0? -0? true? -00.30?) What range of values can they have? (0 to infinity? -231 to 231?) How much memory does it each type use? (Bits and bytes - not all languages will let you know this. Some languages, like Python, make the integer grow to fit your needs.). Write a program to demonstrate as much of this as possible. Give a (short) explanation in comments. Remember to include your citation(s).* </span>

**Overview**

------------------------------------------------------------------------

<span>*Scalar literal*</span> is the closest thing to the familiar primitives. Since Clojure code runs on JVM, its data types are Java data types.

Clojure (Lisp, really) has the philosophy of code-as-data, meaning that its code is literally its own data structures and atomic values . The <span>*reader*</span> is used to interpret these data structure out of textual code; there are “noncollection values”, or scalar literals, in the reader syntax. Some of the scalar literals do not have corresponding concepts in languages like Java or python.

Clojure’s scalar literals include:

-   Numbers

-   Characters

-   Strings

-   Booleans

-   nil

-   Keywords

-   Symbols

-   Regular expressions

**Numbers**

Clojure by defaults stores integers as Long, and floating point numbers as Double. Clojure can intelligently uses `java.lang``.BigInteger` and <span>java.lang.BigDecimal</span> so that the maximum degree of precision is preserved; there is no limit to how big (or small) numbers can be in Clojure . Consequently, there is no bound to the size of integers and floating point numbers.

Rationals
---------

A rational is a number with a nominator and a denominator, both of type arbitrary-precision integers. Rationals retain more precision than floating point numbers .

<span>|p<span>0.8</span>|</span>

``` clj
;; Integers
user> (class 42) ;; get the class of literal 42
java.lang.Long
user> Long/SIZE  ;; get static member SIZE of class 
64               ;; java.lang.Long, signed int
                 ;; 64 bits or 8 bytes

;; integer of arbitrary precision
;; N to force to use BigInt
user> (class 42N)
clojure.lang.BigInt

;; Floating points
user> (class 42.0)
java.lang.Double
user> Double/SIZE
64               ;; Both Long and Double are 64 bits
                 ;; IEEE floating point
                 ;; 64 bits or 8 bytyes
                 
;; Floating point of arbitrary precision
;; M to force to use BigDecimal
user> (class 42M) 
java.math.BigDecimal

;; Rational
user> (class 2/42)
clojure.lang.Ratio
```

To run: in Emacs, `M-x`, select cider-jack-in
Then do `C-c C-k` to compile the current buffer
For using cider in Emacs, see
Reference is here , here and here .

Special cases of numbers
------------------------

Clojure deals with special cases without surprises.

<span>|p<span>0.8</span>|</span>

``` clj
;; comparing 0 to -0
user> (= 0 -0)
true

;; leading 0's are ignored
user> (class -00.30)
java.lang.Double
```

To run: in Emacs, `M-x`, select cider-jack-in
Then do `C-c C-k` to compile the current buffer
For using cider in Emacs, see

**Characters**

Clojure character literals are denoted by a backslash prefix . They are stored as Java characters, and Unicode characters are included, too. Since the size of a char is 16 bits, the range is from `\u0000` to `\uffff` .

<span>|p<span>0.8</span>|</span>

``` clj
;; Of class java.lang.Character
clojure-noob.core> (class \u0042)
java.lang.Character
;; Unicode character
clojure-noob.core> \u0042
\B
clojure-noob.core> Character/SIZE
16  ;; 16 bits, 2 bytes
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
From .

**String**

Clojure strings are java strings. See comments in the code example for caveats in REPL environment.

<span>|p<span>0.8</span>|</span>

``` clj
(defn new-line
  []
  ;; A string is contained between two double quotes.
  ;; Including newlines.
  (println "I am a
oops... string...\n \toops"))
```

``` clj
;; Run the new-line function
clojure-noob.core> (new-line)
I am a
oops... string...  ;; there IS a newline
    oops
nil

;; But REPL escapes backslash newline literals
clojure-noob.core> (def a-string"Hi\nthere")
#'clojure-noob.core/a-string
clojure-noob.core> a-string
"Hi\nthere"     ;; see
;; But the string does print as expected
clojure-noob.core> (println a-string)
Hi
there
nil
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Create a clj file and `C-c M-n` to switch to current namespace, `C-c C-k` to compile. Also, enter code at the prompt.
For using cider in Emacs, see
From .

**Boolean**

Java’s true and false; they are not capitalized, nor are they represented by integers. Interestingly, Oracle documentation suggests that although booleans represent 1 bit of information, its size is not precisely defined .

<span>|p<span>0.8</span>|</span>

``` clj
;; Cannot cast true into Integer
clojure-noob.core> (cast Integer true)
ClassCastException Cannot cast java.lang.Boolean
to java.lang.Integer java.lang.Class.cast 
(Class.java:3369)
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
From .

**nil**

The famous null in Java. Logically equivalent to false. Some properties are shown below in the code example.

<span>|p<span>0.8</span>|</span>

``` clj
;; Does not equate to false
clojure-noob.core> (= nil false)
false
;; But logically is
clojure-noob.core> (if nil () (println "False!"))
False!  ;; else statement prints False!
nil     ;; every form evaluates to something
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
From .

**Symbols**

Symbols are objects that are often evaluated into something else .

<span>|p<span>0.8</span>|</span>

``` clj
;; define a symbol called a-string
clojure-noob.core> (def a-string"Hi\nthere")
#'clojure-noob.core/a-string
;; evaluate that symbol, returns 
;; a string, instead of the symbol itself
clojure-noob.core> a-string
"Hi\nthere"
;; But the evaluation can be suppressed
clojure-noob.core> `a-string ;; by ` 
clojure-noob.core/a-string
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
Adapted from .

**Keyword**

A keyword is similar to symbol, but a keyword evaluates to itself. Keywords are fare more commonly used than symbols .

<span>|p<span>0.8</span>|</span>

``` clj
;; a keyword called mass-wasting
clojure-noob.core> :mass-wasting
;; evaluates to itself
:mass-wasting
;; usage as map keys
;; rocks symbol evaluates to a map, constructed by {}
;; ls is the key
clojure-noob.core> (def rocks {:ls "limestone"})
#'clojure-noob.core/rocks
clojure-noob.core> (get rocks :ls)
;; limestone is the value
"limestone"
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
Adapted from .

**Regular expressions**

In Clojure, a regular expressions is a string prefixed with a hashtag . Although the usage of regular expression is far beyond the scope of this humble composition, Clojure’s regular expression uses Java’s regex. Regular expression is listed as one of the scalar literals in , and called “first-class data type” in .

<span>|p<span>0.8</span>|</span>

``` clj
clojure-noob.core> (class #"gneiss")
java.util.regex.Pattern
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
Inspired by .

: this section takes advantage of REPL environment for ease of testing, so a complete program is not provided.

Phase 4: Composite Types
========================

<span>*What composite types can you make? (tuple, struct, matrix...) List 3 or more. What formal definitions of constructors from your book and lecture do they each match? (record, cartesian product, array, union ...) If the type constructor has options, what choices did your language make? Give an example program using each of these type constructors?*</span>

**Answers**

Collections are very important Clojure composite types. Clojure collections are all immutable. The elements in some collections can be accessed via keys, but no values can be set by keys. Clojure has four basic collection types:

-   Lists

-   Vectors

-   Maps

-   Sets

**Lists**

Fun fact: the name Lisp comes from list processing .

Clojure’s list is a kind of mapping; it is also a recursive type (being a singly linked list). It is possible to access an item on the n-th index through `nth`; that is not the intended use of Clojure lists, because Clojure will do an O(n) traversal from the head . Instead, lists are mainly used for denoting forms in Clojure . The head of the list is resolved into “a function, macro or special operator” , and the rest of the elements are evaluated in order, as parameters .

Since collections in Clojure are immutable, the size of the list is fixed, and there is no limit in length when created . A list can hold elements of any type (heterogeneous), including other collections. Operations are usually done to the head of a list, such as `conj`.

<span>|p<span>0.8</span>|</span>

``` clj
;; Constructed by ()'s
;; Yes the famous (((((()))))))'s
;; (if...) is a list, as an element in (def....) list
;; So lists can contain objects of different types
;; Even other collections
clojure-noob.core> (def eg (if {} :truethy))

;; index from 0 to n-1, inclusive
;; Range is defined on non-negative integers
;; Else: IndexOutOfBoundsException from java
;; or a specified handler
clojure-noob.core> (nth (if nil "a") 1)
nil

;; Adding to the head of the list
;; put c in front of (a,b)
;; ' symbol suppresses evaluation
;; of list ("a" "b"), else error will occur
clojure-noob.core> (conj '("a" "b") "c")
;; the expr (conj ...) evaluates to a new list
;; the old list is still immutable 
("c" "a" "b")

;; Empty test
user=> (empty? ())
true

;; get length
;; Need to suppress evaluation of the list
user=> (count '(1 42))
2
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
See and .

**Vectors**

Clojure vectors belong to mapping, since there is a correspondence from type integer (indices) to vector elements, which can assume any type (heterogeneous) . The length of a vector is fixed once made; but there’s no limit in length. An empty vector is not nil.

Tuples in Clojure
-----------------

Tuples are commonly built with vectors in Clojure .

<span>|p<span>0.8</span>|</span>

``` clj
;; Constructed by [] `(literal syntax)
;; as in [:a "b" 42]: different types
;; multi-dimension is also possible
;; index from 0 to n-1, inclusive
;; Range is defined on non-negative integers
;; Else: IndexOutOfBoundsException from java
;; or a specified handler `(the (print.. ))
;; nth applies to vectors also
user=> (nth [:a "b" 42] 3 (println "bad index"))
bad index   ;; the handler prints
nil         ;; println's return value

;; alternative constructors
;; vector's arguments have an arbitrary length
clojure-noob.core> (vector 42 "42")
[42 "42"]
clojure-noob.core> (vec (range 2))
[0 1]       ;; vec takes a sequence 

;; Example operation: appending an element
;; The expression (conj... ) evaluates 
;;     to a new, longer vector
;; But the old vector itself is still immutable.
user=> (conj [:a :b] :c)
[:a :b :c]

;; Empty test
user=> (empty? [])
true

;; get length
user=> (count [])
0
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
See , and .

**Maps**

Map is, by name, a kind of mapping. An element in a map consists of a key-value pair . Clojure’s map can have any type for both keys and values (heterogeneous) . Since collections in Clojure are immutable, the size of the map is fixed throughout its lifetime. An empty map is not the same as nil .

The keys in a map should not duplicate . A map can be sorted or unsorted (hashmap) .

<span>|p|</span>

``` clj
;; {} constucts a map
;; with key-value pairs
;; {:answer 42 :who "DeepThought"} is the map
;; Recall :answer, :who are keywords
clojure-noob.core> (def ultimap {:answer 42 :who "DeepThought"})
#'clojure-noob.core/ultimap
;; Access a value through a key
clojure-noob.core> (get ultimap :answer)
42

;; Different types of keys and values are possible
;; Can have multidimensional maps
;; But the popular keys are still keyword type
;; note "a" and the first 42 is a pair;
;; for readability, the expression can also be
;; (def rand-map {"a" 42, 42 []})
clojure-noob.core> (def rand-map {"a" 42 42 []})
#'clojure-noob.core/rand-map

;; Get all the keys as a list
clojure-noob.core> (keys rand-map)
("a" 42)

;; Get all the values as a list
clojure-noob.core> (vals rand-map)
(42 [])

;; Empty test
user=> (empty? {})
true

;; Length is now the number of pairs
clojure-noob.core> (count rand-map)
2   ;; not 4

;; Sidenote of Clojure's truthiness
;; if empty map, then return :truthy
clojure-noob.core> (if {} :truthy)
:truethy    ;; {} looks to if like true
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
Adapted from and .

**Cartesian Products**

Sets
----

Clojure’s set is a collection of objects without duplication . Since a set can contain any data type (heterogeneous), it is a Cartesian product. It can come in a sorted or unsorted flavour . There is no obvious way to get set elements by name, because they technically don’t have any, and nor is there a limit to the number of elements created in the set.

<span>|p<span>0.8</span>|</span>

``` clj
;; Constructed by #{} (literal)
user=> (def rocks #{:gneiss :slate :slate})
;; Duplicated elements are not allowed
IllegalArgumentException Duplicate key: :slate

;; Making a set from other collections
user=> (set [42 42 42])
#{42}   ;; duplicates eliminated 

user=> (def rocks #{:gneiss :slate :schist})
#'clojure-noob.core/rocks       ;; OK

;; Empty test
user=> (empty? #{})
true

;; There seems to be no name access 
;; contains? checks if the given key is present
user=> (contains? rocks 0)
false
user=> (contains? rocks :slate)
true

;; get length
user=> (count rocks)
3
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
See and .

Interoperability with Java classes
----------------------------------

Clojure can use Java classes , a feature called <span>*interoperability*</span>. Clojure can access Java classes and their members, and even create new instances. Clojure provides mechanisms like `reify` and `deftype` to emulate Java interfaces .

A class contains objects of different types; it is a Cartesian product.

<span>|p<span>0.99</span>|</span>

``` clj
;; Create an instance of Point class
;; The dot behind Point denotes creation 
;; of an instance 
clojure-noob.core> (java.awt.Point. 1 1)
#object[java.awt.Point 0x37a2bc27 "java.awt.Point[x=1,y=1]"]
```

To run: in Emacs, `M-x`, select cider-jack-in to start REPL
Enter code at the prompt.
For using cider in Emacs, see
Adapted from .



Phase 6: Dynamic typing, scope & regex
======================================















**49. What are the regular expressions for its tokens? (Give a regular expression to describe each category of literals - integers, booleans, etc).**

<span>|p<span>0.98</span>|</span>

``` clj

(def ^Pattern int-pattern #"([-+]?)(?:(0)|([1-9][0-9]*)|
0[xX]([0-9A-Fa-f]+)|0([0-7]+)|
([1-9][0-9]?)[rR]([0-9A-Za-z]+)|
0[0-9]+)(N)?")
(def ^Pattern ratio-pattern #"([-+]?[0-9]+)/([0-9]+)")
(def ^Pattern float-pattern #"([-+]?[0-9]+(\.[0-9]*)?
([eE][-+]?[0-9]+)?)(M)?")
```

Clojure reader.clj can be found at <https://github.com/clojure/tools.reader/blob/master/src/main/clojure/clojure/tools/reader/impl/commons.clj>





<span>|p<span>0.8</span>|</span>

``` clj
(defmulti greeting
  "The multimethod greeting"
  (fn [x] (x "language")))
(defmethod greeting "English" [_]
  "Returns the appropriete greeting"
  "Hello!")
(defmethod greeting "Deutsch" [_]
  "Hallo!")
(defmethod greeting :default [params]
  (throw (IllegalArgumentException.
  (str "Kein " (params "language")))))
  
(def english-map {"id" "1" "language" "English"})
(def deutsch-map {"id" "1" "language" "Deutsch"})
(def espano-map {"id" "3" "language" "Espano"})
```

``` clj
clojure-noob.core> (greeting deutsch-map)
"Hallo!"
clojure-noob.core> (greeting espano-map)
IllegalArgumentException Kein Espano 
clojure-noob.core/eval3459/fn--3460 (core.clj:27)
```

To run: in Emacs, `M-x`, select cider-jack-in
Then do `C-c C-k` to compile the current buffer
For using cider in Emacs, see
Adapted from


[2] <https://github.com/clojure/clojure/commits/1.0.x?page=30>

[3] <https://www.youtube.com/watch?v=P76Vbsk_3J0&index=4&list=WL>. A talk by Rich Hickey

[4] <http://clojure.org/rationale>

[5] <https://gooroo.io/analytics/skill/Clojure#.VirsSLzSxnk>

[6] <http://cognitect.com>

[7] <https://www.linkedin.com/job/clojure-jobs/?sort=relevance&page_num=1&trk=jserp_pagination_1>







[15] http://clojure.org/multimethods

