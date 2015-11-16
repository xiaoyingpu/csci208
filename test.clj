;; test file, not coll of answers

(defn is-positive 
  [i]
(bit-and i (bit-not (bit-shift-right i 31))))

(defn get-byte
  [x n]
  (format "0x%x" 
        (bit-and 
         (bit-shift-right x (* 8 n)) 
         0xff)))

(def z 3)
(def a 3)

(defn sqr [x]
  (println "sqr")
  (* x x))

(defn tri [x]
  (println "tri")
  (+ x x x))

(defn main []
  (sqr (tri a)))


(defn get-string 
  [s] 
  (re-seq #"" s) )

(defn number
  [s]
  (re-seq #"[0-9]." s))


(defn character [] ())

(defn keywd [s]
  (re-seq #":.+" s))


(defn get-nil [s]
  (re-seq #"nil" s))



(def  int-pattern #"([-+]?)(?:(0)|([1-9][0-9]*)|0[xX]([0-9A-Fa-f]+)|0([0-7]+)|([1-9][0-9]?)[rR]([0-9A-Za-z]+)|0[0-9]+)(N)?")
(def  ratio-pattern #"([-+]?[0-9]+)/([0-9]+)")
(def  float-pattern #"([-+]?[0-9]+(\.[0-9]*)?([eE][-+]?[0-9]+)?)(M)?")


(defprotocol Walkable
  (walk [this]))

(defrecord Human [name]
  Walkable
  (walk [this] "Human walks"))

(defrecord Dog [name]
  Walkable
  (walk [this] "Woof"))

(defn head
 "clojure collection methods are excellent examples of 
  parametric functions"
  [coll]
   (first coll))

(defn fib [m n]
  (cons m (lazy-seq (fib n (+ m n)))))

(defn fibs []
  (fib 1 1))

(defn length
  [^String s]
  (.length s ))


(deftype Animal [name age])


(defn funk []
  (if true
    (if false 
      (println "nested")
      (println "this else knows...."))))
