# 40. What is a BNF grammar for it? 

Clojure, like Lisp, is known for having very simple grammar. [clojure official site](http://clojure.org/reader) describes how reader deals with Clojure grammar through various forms. 

The closest thing to BNF for Clojure is attached (deleted some for succinctness), from [github/ccw](https://github.com/laurentpetit/ccw/blob/3738a4fd768bcb0399630b7f6a6427a3066bdaa9/clojure-antlr-grammar/src/Clojure.g).


````
/* reader form clojure page errors
 * symbols can contain chars < >  = $ ($ is mandatory for member class resolving, and is used in boot.clj) in the implementation (and in fact functions < and > are defined in clojure core !!)
 * Metadata must be Symbol,Keyword,String or Map : add this precision to the documentation ?
 */
grammar Clojure;


/*
 * Lexer part
 */
 
OPEN_PAREN: '('
 	;
CLOSE_PAREN: ')'
	;
AMPERSAND: '&'
        ;

....
        
SPECIAL_FORM: 'def' | 'if' | 'do' | 'let' | 'quote' | 'var' | 'fn' | 'loop' |
            'recur' | 'throw' | 'try' | 'monitor-enter' | 'monitor-exit' |
            'new' | 'set!' | '.'
    ;

STRING
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

REGEX_LITERAL
    : NUMBER_SIGN '"' ( ~('\\' | '"') | '\\' . )* '"'
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

HEXDIGIT:
        '0'..'9' | 'a'..'f' | 'A'..'F';
        
NIL:    'nil'
    ;
    
BOOLEAN:
        'true'
    |   'false'
    ;

SYMBOL:
        '/'
    |   NAME ('/' NAME)?
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

SYNTAX_QUOTE:
        '`'
    ;
    

/*
 * Parser part
 */

file:   
        ( form  { System.out.println("form found"); }  )*
    ;
    
form	:	   
	 {this.inLambda}? LAMBDA_ARG
    |    literal 
    |	COMMENT
    |   AMPERSAND
    |   metadataForm? ( SPECIAL_FORM | s=SYMBOL { symbols.add(s.getText()); } | list | vector | map )
    |   macroForm
    |   dispatchMacroForm
    |   set
    ;
        
macroForm:   
        quoteForm
    |   metaForm
    |   derefForm
    |   syntaxQuoteForm
    |	{ this.syntaxQuoteDepth > 0 }? unquoteSplicingForm
    |	{ this.syntaxQuoteDepth > 0 }? unquoteForm
    ;
    
    
vector:  LEFT_SQUARE_BRACKET form* RIGHT_SQUARE_BRACKET
    ;
    
map:    LEFT_CURLY_BRACKET (form form)* RIGHT_CURLY_BRACKET
    ;
    
    
set:    NUMBER_SIGN LEFT_CURLY_BRACKET form* RIGHT_CURLY_BRACKET
    ;


````

<!--[github/sad](https://github.com/arrdem/sad/blob/master/src/me/arrdem/sad/grammars/bnf.clj) -->



Interestingly, there is a Clojure project for [instaparse](https://github.com/Engelberg/instaparse)
