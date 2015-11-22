
# 23. For languages with both a stack and a heap

...what goes where? (In Java, arrays are all on the heap. primitive contents are actually inside the array. object contents are somewhere else on the heap. In C, array are where ever you want them. Contents are in the array or out on the heap as you like).


## Answer:

Since Clojure is written in Java (and in Clojure of course) and runs on JVM, it's reasonable that Clojure uses the same memory allocation strategy as Java, as stated above. As an indirect evidence, _Clojure Programming_  says that _many thousands_ of agent objects can be created on the heap.

See Emerick, Chas, Brian Carper, and Christophe Grand. Clojure programming. " O'Reilly Media, Inc.", 2012.
