package Service;

import Model.Monomial;
import Model.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexService {

        private final static String PATTERN = "((-?(\\d+)?\\*?x(\\^\\d+)?)|-?\\d+)";
        //String str = "-25*x^3+4*x^2-3*x+5";
        //String input = "-3*x^3-4x^2-x-3";

        public Polynomial getPolynomialFromString(String input){
            Pattern pattern = Pattern.compile(PATTERN);
            Matcher matcher = pattern.matcher(input);
            Polynomial polynomial = new Polynomial();
            Double coef;
            Integer degree;

            //"-25*x^3+4x^2-3*x-5" -> "-25*x^3"  "4x^2"  "-3*x"  "-5"

            while(matcher.find()){
                if(matcher.group().contains("x^")){  //daca nu e termenul liber fara x sau x^1
                    String[] parts = matcher.group().split(Pattern.quote("x^"));
                    if(parts[0].length() > 1 && parts[0].charAt(parts[0].length() - 1) == '*')  // eliminam * de la final
                        parts[0] = parts[0].substring(0, parts[0].length() - 1);

                    coef = 1.0;
                    if(!parts[0].equals("-") && !parts[0].equals(""))  //-x sau x
                        coef = Double.parseDouble(parts[0]);
                    else if(parts[0].equals(""))   // x
                        coef = 1.0;
                    else
                        coef = -1.0;
                    degree = Integer.parseInt(parts[1]);
                }
                else if (matcher.group().contains("x")){  // 3x sau -2*x sau x sau -x
                    if(matcher.group().length() == 1)// x
                        coef = 1.0;
                    else
                        if(matcher.group().equals("-x"))
                            coef = -1.0;
                        else
                            if(matcher.group().contains("*"))
                                coef = Double.parseDouble(matcher.group().substring(0, matcher.group().indexOf("*")));
                            else
                                coef = Double.parseDouble(matcher.group().substring(0, matcher.group().indexOf("x")));

                    degree = 1;
                }
                else{  // termenul liber fara x
                    coef = Double.parseDouble(matcher.group());
                    degree = 0;
                }

               // System.out.println("grad: " + degree + " coef: " + coef + "\n");

                polynomial.addNewMonomial(new Monomial(degree, coef));
            }

            return polynomial;
        }
}
