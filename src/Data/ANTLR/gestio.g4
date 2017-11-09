grammar gestio;

r  : 'user' (ID','ID)* 'endusers';         // match keyword hello followed by an identifier
ID : ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9')+;            // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines