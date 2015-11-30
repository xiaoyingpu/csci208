\newpage

# Front Matter

This project is also on [github (link)](http://xiaoyingpu.github.io/csci208/), with _incomprehensive_ code examples in `test.clj`. 


## How to run code


![Emacs with REPL running on the lower pane. You can just enter code or call compiled functions at the prompt.](https://raw.githubusercontent.com/xiaoyingpu/csci208/master/resources/emacs.png)


[braveclojure (link)](http://www.braveclojure.com/basic-emacs/) teaches how to set up your emacs to work with Clojure conveniently. You can compile Clojure code and run REPL within emacs. In summary:

1. Install Java Runtime Environment (JRE).
2. Install [Clojure (link)](http://clojure.org/getting_started).
3. Install [Leiningen (link)](http://leiningen.org) and get the dependencies right.
4. Install [cider (link)](https://github.com/clojure-emacs/cider), a plug-in for emacs.
5. Open source (if any) file in emacs.
6. `M-x` and choose `cider-jack-in` to start REPL.
7. `C-c C-k` in the code buffer to compile current file.
8. Paste an expression at the prompt in REPL, or paste a function into a file, compile and call the function from prompt.



## This report


- there are a lot of inline hyperlinks as citations; those links unfortunately are not underlined, nor are they blue. 
- if you have the Haskell and LaTeX dependencies figured out, you can go to the `project` directory and compile the PDF from source!

> `pandoc -s *.md --bibliography biblio.bib --csl apa.csl --toc  -o report.pdf` 




\newpage




