package Lexema;
import static Main.Tokens.*;

%%
%class AFlex
%type Tokens

Letra=[a-zA-Z_]+
Digito=[0-9]+
espacio=[ ,\t,\r,\n]+
op_relacionales=[==, =!, <, >, >=, <=,]
op_logicos=[AND, OR, NOT]

%{
    public String lexeme;
%}

%%
int |
float |
null |
true |
false |
class |
try |
catch |
void |
public |
private |
this |
static |
return |
do |
if |
else |
elseif |
while |
for |
break |
case |
switch  {lexeme=yytext (); return Reservadas;}
{espacio} {/*Ingore*/}
"//".* {/*Ignore*/}
"=" {return Igual;}
"-" {return Resta;}
"+" {return Suma;}
"*" {return Multiplicar;}
"/" {return Dividir;}
{Letra}({Letra}|{Digito})* {lexeme=yytext(); return Identificador;}
("-"?)({Digito}+("."{Digito}+)?|("."{Digito}+)) {lexeme=yytext(); return Numero;}
{op_relacionales} {return Relacional;}
{op_logicos} {return Logico;}
. {return ERROR;}