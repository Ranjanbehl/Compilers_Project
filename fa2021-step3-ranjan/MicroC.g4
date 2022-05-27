grammar MicroC;

@header {

package compiler;

import java.util.List;
import java.util.LinkedList;
import ast.*;

}

@members {
     private SymbolTable st; //Symbol table for the program
     private ASTNode ast; //AST for the program

     public void setSymbolTable(SymbolTable st) {
          this.st = st;
     }

     public SymbolTable getSymbolTable() {
          return st;
     }

     public ASTNode getAST() {
          return ast;
     }

}

program : decls function {ast = $function.node;};

/* Declarations */
decls : var_decl decls
      | str_decl decls
	 | /* empty */ ;

var_decls : var_decl var_decls 
          | /* emoty */ ;

/* Identifiers and types */		  
id : IDENTIFIER ;
		  
var_decl : base_type id ';' {st.addVariable($base_type.t, $id.text);};

str_decl : 'string' id '=' val= STR_LITERAL ';' {st.addVariable(Scope.Type.STRING, $id.text, $val.text);};

base_type returns [Scope.Type t]: 'int' {$t = Scope.Type.INT;}| 'float' {$t = Scope.Type.FLOAT;};

/* Functions */

function returns [StatementListNode node] : 'int' 'main' '(' ')' '{' statements '}' {$node = $statements.node;};
		 		 
/* Statements */
		 
statements returns [StatementListNode node] : statement s=statements {$node = new StatementListNode($statement.node, $s.node);}
            | /* empty */ {$node = new StatementListNode();};
			
statement returns [StatementNode node] : base_stmt ';' {$node = $base_stmt.node;}
		 | if_stmt {$node = $if_stmt.node;} /* FILL IN FROM STEP 1 */ /* FILL IN ACTIONS FOR STEP 3 */
		  | while_stmt {$node = $while_stmt.node;}; /* FILL IN ACTIONS FOR STEP 3 */
		  
base_stmt returns [StatementNode node] : assign_stmt {$node = $assign_stmt.node;}
          | read_stmt {$node = $read_stmt.node;}
		| print_stmt {$node = $print_stmt.node;}
		| return_stmt {$node = $return_stmt.node;};
		 
read_stmt returns [ReadNode node] : 'read' '(' id ')' {$node = new ReadNode(new VarNode($id.text));} ;

print_stmt returns [WriteNode node] : 'print' '(' expr ')' {$node = new WriteNode($expr.node);};

return_stmt returns [ReturnNode node] : 'return' expr {$node = new ReturnNode($expr.node);};

assign_stmt returns [AssignNode node] : id '=' expr {$node = new AssignNode(new VarNode($id.text), $expr.node);};

/* if_stmt rules go here */
/*  
if_stmt : FILL IN RULES FROM STEP 1

FILL IN ACTIONS FOR STEP 3
*/

if_stmt returns [IfStatementNode node] : 'if' '('cond ')' '{' statements '}' else_stmt {$node = new IfStatementNode($cond.node,$statements.node,$else_stmt.node);};

else_stmt returns [StatementListNode node]: 'else' '{' statements '}' {$node = $statements.node;} | {$node = new StatementListNode();};

while_stmt returns [WhileNode node] : 'while' '(' cond ')' '{' statements '}' {$node = new WhileNode($cond.node,$statements.node);}; /* FILL IN FOR STEP 3 */
	 
/* Expressions */

primary returns [ExpressionNode node] : id {$node = new VarNode($id.text);}
        | '(' expr ')' {$node = $expr.node;}
        | unaryminus_expr {$node = $unaryminus_expr.node;}
        | il = INT_LITERAL {$node = new IntLitNode($il.text);}
        | fl = FLOAT_LITERAL {$node = new FloatLitNode($fl.text);};

unaryminus_expr returns [ExpressionNode node] : '-' expr {$node = new UnaryOpNode($expr.node,"-");}; /* FILL IN FROM STEP 2 */
		 
/* This is left recursive, but ANTLR will clean this up */ 
expr returns [ExpressionNode node] : term {$node = $term.node;}
     | e1 = expr addop term {$node = new BinaryOpNode($e1.node,$term.node,$addop.text);}; /* FILL IN FROM STEP 2 */
	 
/* This is left recursive, but ANTLR will clean this up */
term returns [ExpressionNode node] : primary {$node = $primary.node;}
     | t1 = term mulop primary {$node = new BinaryOpNode($t1.node,$primary.node,$mulop.text);}; /* FILL IN FROM STEP 2 */
	   	   
cond returns [CondNode node] : e1=expr cmpop e2=expr {$node = new CondNode($e1.node,$e2.node,$cmpop.text);}; /* FILL IN FOR STEP 3 */

cmpop : '<' | '<=' | '>=' | '==' | '!=' | '>' ;

mulop : '*' | '/' ;

addop : '+' | '-' ;

/* Tokens */

IDENTIFIER : LETTER (LETTER | DIGIT)* ;

INT_LITERAL : DIGIT+;

FLOAT_LITERAL : DIGIT* '.' DIGIT+;

STR_LITERAL : '"' (~('"'))* '"' ;

COMMENT : '/*' .*? '*/' -> skip;

WS : [ \t\n\r]+ -> skip;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;

fragment DIGIT : ('0'..'9') ;
