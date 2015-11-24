# 40. What is a BNF grammar for it? 

Clojure, like Lisp, is known for having very simple grammar. [clojure official site (link)](http://clojure.org/reader) describes how reader deals with Clojure grammar through various forms. 

The closest thing to BNF for Clojure is attached (deleted some for succinctness), from [github/ccw (link)](https://github.com/laurentpetit/ccw/blob/3738a4fd768bcb0399630b7f6a6427a3066bdaa9/clojure-antlr-grammar/src/Clojure.g).


```g
/*
 * Lexer part
 */
 
SPECIAL_FORM: 'def' | 'if' | 'do' | 'let' | 'quote' | 'var' | 'fn' | 'loop' |
            'recur' | 'throw' | 'try' | 'monitor-enter' | 'monitor-exit' |
            'new' | 'set!' | '.'
    ;

STRING
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

NUMBER: '-'? '0'..'9'+ ('.' '0'..'9'+)? (('e'|'E') '-'? '0'..'9'+)?
    ;

CHARACTER:
        '\\newline'
    |   '\\space'
    |   '\\tab'
    |   '\\u' HEXDIGIT HEXDIGIT HEXDIGIT HEXDIGIT
    |   BACKSLASH .   // TODO : is it correct to allow anything ?
    ;

literal:
        STRING 
    |   NUMBER
    |   CHARACTER
    |   NIL
    |   BOOLEAN
    |   KEYWORD
    ;    

KEYWORD:
        ':' (':')? SYMBOL_REST+ ('/' SYMBOL_REST+)?
    ;

/*
 * Parser part
 */

form	:	   
	 {this.inLambda}? LAMBDA_ARG
    |    literal 
    |	COMMENT
    |   AMPERSAND
    |   macroForm
    |   dispatchMacroForm
    |   set
    ;
    
vector:  LEFT_SQUARE_BRACKET form* RIGHT_SQUARE_BRACKET
    ;
    
map:    LEFT_CURLY_BRACKET (form form)* RIGHT_CURLY_BRACKET
    ;
```

<!--[github/sad](https://github.com/arrdem/sad/blob/master/src/me/arrdem/sad/grammars/bnf.clj) -->



<!--Interestingly, there is a Clojure project for [instaparse](https://github.com/Engelberg/instaparse)-->
