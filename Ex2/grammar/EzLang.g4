grammar EzLang;

file
: code EOF
;

code
: statement '.' code
|
;

statement
: declare
| assign
| math
| print
| loop
;

loop
: 'loop' '(' cond ')'
  code
  'end loop'
;

print
: 'print' atom
| 'print' cond
| 'print' math
;

declare
: 'var' ID
;

assign
: ID '=' INT
| ID '=' math
| ID '=' cond
;

math
: add
| mul
;

add
: atom '+' atom ('+' atom)*
;

mul
: atom '*' atom
;

cond
: equ
| nequ
;

equ
: atom 'equals' atom
;

nequ
: atom '!equals' atom
;

atom
: ID
| INT
;

ID:	 ('a'..'z')+ ;
INT: ('0'..'9')+ ;
WS:	 [ \n\t\r]+ -> skip ;