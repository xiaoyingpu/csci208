# Answers to Clojure

`bucknell/csci208`

A semester-long project: pick up a new language and answer questions (~30).


## The report

- The PDF under `project` folder.
- if you have the Haskell and LaTeX dependencies figured out, do 

> `pandoc -s *.md --bibliography biblio.bib --csl apa.csl --toc  -o out.pdf` 


__Note:__ 

- the bibtex citations are in `biblio.bib`; they are cited as `[@citekey2015]` in the markdown files.


## How to run code

Since Clojure has a very nice read-evaluate-print-loop (REPL), separate `clj` files are not provided for each question.

1. Install Java.
2. Install [Clojure](http://clojure.org/getting_started).
3. Install [Leiningen](http://leiningen.org) and get the dependencies right.
4. Run `lein repl`
5. Enter code at the prompt


## Good-to-have

[braveclojure](http://www.braveclojure.com/basic-emacs/) teaches how to set up your emacs to work with Clojure conveniently.
