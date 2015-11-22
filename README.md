# Answers to Clojure

`bucknell/csci208`

A semester-long project: pick up a new language and answer questions.


__Note:__ 

- the bibtex citations are all broken in the markdown files. Please search for the citation keys within the project.
- if you have the Haskell and LaTeX dependencies figured out, do `pandoc -s -S --bibliography biblio.bib --filter pandoc-citeproc *.md -o report.pdf` will give a nice PDF of the whole thing.



## How to run code

Since Clojure has a very nice read-evaluate-print-loop (REPL), separate `clj` files are not provided for each question.

1. Install Java.
2. Install [Clojure](http://clojure.org/getting_started).
3. Install [Leiningen](http://leiningen.org) and get the dependencies right.
4. Run `lein repl`
5. Enter code at the prompt


## Good-to-have:

[braveclojure](http://www.braveclojure.com/basic-emacs/) teaches how to set up your emacs to work with Clojure conveniently.
