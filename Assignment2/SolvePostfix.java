package PA2;

//class to perform operation on postfix expression
public class SolvePostfix {

    public String evalPostfix(String exp){

        Stack st = new Stack();
        for(int i=0; i<exp.length(); i++){
            char value = exp.charAt(i);

            if(Character.isDigit(value)){
                st.push(Character.toString(value));
            }
            else if(Character.isLetter(value)){
                return "Please Enter an Integer for Evaluation.";
            }
            else{
                int tempValue1 = Integer.valueOf(st.top());
                st.pop();
                int tempValue2 = Integer.valueOf(st.top());
                st.pop();

                switch(value){
                    case '+':
                        st.push(String.valueOf(tempValue2 + tempValue1));
                        break;
                    case '-':
                        st.push(String.valueOf(tempValue2 - tempValue1));
                        break;
                    case '*':
                        st.push(String.valueOf(tempValue2 * tempValue1));
                        break;
                    case '/':
                        st.push(String.valueOf(tempValue2 / tempValue1));
                        break;
                    case '^':
                        st.push(String.valueOf((int)Math.pow(tempValue2,tempValue1)));
                    default:
                        break;
                }
            }
        }
        return (st.top());
    }
}
