package PA2;

//class to perform operation on postfix expression
public class Infix_postfix {
    //function is designed to set precedence of operators
    public static int precedence(String ch){
        switch(ch){
            case "+":
            case "-":
                return 1;
            
            case "*":
            case "/":
                return 2;
            
            case "^":
                return 3;
        }
        return -1;
    }

    //function to convert infix expression to postfix expression
    public String inf_to_Post(String exp){

        Stack st = new Stack();
        String postfix = "";
        for(int i=0; i<exp.length(); i++){
            char temp_ch = exp.charAt(i);

            if(temp_ch == '('){
                st.push(Character.toString(temp_ch));
            }
            else if(temp_ch == ')'){
                String top = st.top();
                st.pop();
                while(!(top.equalsIgnoreCase("("))){
                    postfix += top;
                    top = st.top();
                    st.pop();
                }
            }
            else if(Character.isLetterOrDigit(temp_ch)){
                postfix += temp_ch;
            }
            else{
                while((!(st.isEmptyStack())) && (precedence(Character.toString(temp_ch)) <= precedence(st.top()))){
                    postfix += (st.top());
                    st.pop();
                }
                st.push(Character.toString(temp_ch));
            }
        }
        while(!st.isEmptyStack()){
            postfix += st.top();
            st.pop();
        }
        return postfix;
    }

    //function to check balenced brackets
    public boolean brac(String exp){

        Stack st = new Stack();
        for(int i=0; i<exp.length(); i++){
            char brac = exp.charAt(i);
            if(brac=='('){
                st.push(Character.toString(brac));
            }
            else if(brac==')' && (st.isEmptyStack())){
                return false;
            }
            else if((!(st.isEmptyStack()) && (brac == ')'))){
                st.pop();
            }     
        }
        if(st.isEmptyStack()){
            return true;
        }
        else{
            return false;
        }
    }
}