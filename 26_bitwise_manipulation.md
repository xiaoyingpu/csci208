# 26. Can you directly access or manipulate the bits of an integer value? What operations are possible?

Yes. 

According to Clojure’s official site[8], it can do 
* bit-and
* bit-or
* bit-xor
* bit-not
* bit-shift-right 
* bit-shift-left. 

The following example uses bitwise and & bitwise shift right.


``` clj
;; from a CSCI 206 lab
;; get_byte - Extract byte n from word x
;; example: get_byte(0x12345678, 1) = 0x56
(defn get-byte
  [x n]
  (format "0x%x" 
        (bit-and 
         (bit-shift-right x (* 8 n)) 
         0xff)))
user> (get-byte 0xdeadbeef 0)
"0xef"	;; endianness
```

See [clojuredoc](https://clojuredocs.org/clojure.core/bit-shift-right).