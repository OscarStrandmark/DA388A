grammar EzLang;

file
: code EOF
;

code
: statement '.' code
| statement '.'
| loop code
;

statement
: declare
| assign
| math
| print
| loop
;

loop
: 'loop' '(' cond '):'
  code
  'end loop.'
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
| sub
;

add
: atom '+' atom ('+' atom)*
;

sub
: atom '-' atom ('-' atom)*
;

mul
: atom '*' atom
;

cond
: equ
| nequ
| less
| greater
;

equ
: atom 'equals' atom
;

nequ
: atom '!equals' atom
;

less
: atom '<<' atom
;

greater
: atom '>>' atom
;

atom
: ID
| INT
;

ID:	 ('a'..'z')+ ;
INT: ('0'..'9')+ ;
WS:	 [ \n\t\r]+ -> skip ;