
# 23. For languages with both a stack and a heap

...what goes where? (In Java, arrays are all on the heap. primitive contents are actually inside the array. object contents are somewhere else on the heap. In C, array are where ever you want them. Contents are in the array or out on the heap as you like).


## Answer:

Since Clojure runs on JVM, it's reasonable that Clojure uses the same memory allocation strategy as Java. As an indirect evidence, _Clojure Programming_  documents the following java memory error:

```clojure
#<OutOfMemoryError java.lang.OutOfMemoryError: Java heap space>
```

See Emerick, Chas, Brian Carper, and Christophe Grand. Clojure programming. " O'Reilly Media, Inc.", 2012.
