import java.awt.*;
import java.awt.event.*;
public class CalculatorAWT extends Frame implements ActionListener{
    TextField tf;
    String num1 = "",num2 = "",operator = "";
    CalculatorAWT(){
        setTitle("Calculator");
        setSize(350,500);
        setLayout(new BorderLayout());
        tf = new TextField();
        tf.setFont(new Font("Arial",Font.BOLD,75));
        add(tf,BorderLayout.NORTH);
        Panel p = new Panel();
        p.setLayout(new GridLayout(4,4,5,5));
        String buttons[] = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","=","C","+"
        };
        for(String b : buttons){
            Button btn = new Button(b);
            btn.setFont(new Font("Arial",Font.BOLD,20));
            btn.addActionListener(this);
            p.add(btn);
        }
        add(p, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                dispose();
            }
        });
        setVisible(true);
        }
        public void actionPerformed(ActionEvent e){
            String s = e.getActionCommand();
            if(s.charAt(0)>='0' && s.charAt(0)<= '9'){
                if(operator.equals(""))
                    num1 = num1 + s;
                else
                    num2 = num2 + s;
                tf.setText(num1 + operator + num2);
            }
            else if (s.equals("C")){
                num1 = num2 = operator = "";
                tf.setText("");
            }
            else if(s.equals("=")){
                double result = 0;
                double n1 = Double.parseDouble(num1);
                double n2 = Double.parseDouble(num2);
                switch(operator){
                    case"+":
                        result = n1 + n2;
                        break;
                        case"-":
                        result = n1 - n2;
                        break;
                        case"*":
                        result = n1 * n2;
                        break;
                        case"/":
                        result = n1/n2;
                        break;  
                }
                if(result == (int) result)
                    tf.setText("" + (int) result); 
                else
                    tf.setText("" + result);
                num1 = "" + result;
                operator = "";
                num2 = "";
            }
            else{
                operator = s;
                tf.setText(num1 + operator);
            }
        }
        public static void main(String[] args){
            new CalculatorAWT();
        }
        
    }