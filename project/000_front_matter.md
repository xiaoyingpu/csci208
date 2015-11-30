\newpage

# Front Matter

This project is also on [github (link)](http://xiaoyingpu.github.io/csci208/).

## This report

- is the PDF under `project` folder in the repository.
- if you have the Haskell and LaTeX dependencies figured out, do the following to compile

> `pandoc -s *.md --bibliography biblio.bib --csl apa.csl --toc  -o report.pdf` 


## How to run code

Clojure has a very nice read-evaluate-print-loop (REPL). _Separate `clj` files are not provided for each question._


### Dependencies

1. Install Java Runtime Environment (JRE).
2. Install [Clojure (link)](http://clojure.org/getting_started).
3. Install [Leiningen (link)](http://leiningen.org) and get the dependencies right.
4. Run `lein repl`.
5. Enter code at the prompt.


## Good-to-have

[braveclojure](http://www.braveclojure.com/basic-emacs/) teaches how to set up your emacs to work with Clojure conveniently. You can compile Clojure code and run REPL within emacs.


![Emacs with REPL on the lower pane](resources/emacs.png)



\newpage




