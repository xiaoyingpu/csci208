# 51. Free or fixed format? Dependent on the specific compiler? Always that way?


## Answer: free format

Since Clojure is fully parenthesized, there is no mandantory intentation for syntaxing purposes.

```clojure
(defn get-byte
  [x n]
  (format "0x%x" 
        (bit-and 
         (bit-shift-right x (* 8 n)) 
         0xff)))

;; no difference
(defn get-byte2 [x n] (format "0x%x" (bit-and (bit-shift-right x (* 8 n)) 0xff)))
```