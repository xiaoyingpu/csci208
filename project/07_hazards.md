# 7. Hazards 

_Which ones can you make? C has aliasing, dangling references, and memory leaks. Java has only aliasing._


## Answer

###  Aliasing

- Normally, Clojure var's are immutable and do not have states; aliasing does not happen. 
- If interop'ing with Java, Clojure can invoke method calls on Java objects, and aliasing is indeed possible.


```clojure
(def ^:dynamic x (java.awt.Point. 1 1))
;; y points to the same object as x
(def ^:dynamic y x)

(defn aliaspt []
  ;; changing y 
  (. y setLocation 2 2)
  ;; altered the state of x
  ;; returns x.toString()
  (. x toString))
```

Output:

```clojure
user> (aliaspt)
"java.awt.Point[x=2,y=2]"
```

### Other hazards

I searched around and found none. Since Clojure is hosted on Java, it is safe to assume that it does not suffer from dangling references or memory leaks.



-----------------------
