# 35. Does it have exceptions? 


If not, then how does it do error handling? Java supports exceptions.


## Yes.


Throwing and catching Java exceptions are suppported.

```clojure
user> (throw (Exception. "I am thrown"))
Exception I am thrown  
user/eval3369 (form-init1375997426799586524.clj:1)

(defn throw-catch [f]
  [(try
    (f)
    (catch ArithmeticException e "No dividing by zero!")
    (catch Exception e (str "You are so bad " (.getMessage e)))
    (finally (println "returning... ")))])

user> (throw-catch #(/ 1 0))
returning... 
["No dividing by zero!"]
```
See [@fogus2014joy].

