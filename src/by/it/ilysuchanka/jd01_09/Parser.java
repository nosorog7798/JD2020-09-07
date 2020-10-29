package by.it.ilysuchanka.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
     Var calc(String expression){
         String [] operand = expression.split(Patterns.OPERATION);
         Var one = Var.createVar(operand[0]);
         Var two = Var.createVar(operand[1]);
         if (one==null || two==null)
//             TODO create error
             return null;
         Pattern p= Pattern.compile(Patterns.OPERATION);
         Matcher m=p.matcher(expression);
         if (m.find()){
             String operation=m.group();
             switch (operation){
                 case "+":return one.add(two);
                 case "-":return one.sub(two);
                 case "*":return one.mul(two);
                 case "/":return one.div(two);
             }
         }
         return null;
     }
}
