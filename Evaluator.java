package com.company;

import java.util.Stack;
import java.util.Scanner;

public class Evaluator {

    public static void main (final String[] args) {

        Stack<String> operations = new Stack<String>();

        Stack<Double> values = new Stack<Double>();
        //input format "( 2 + ( 3 * 5 ) )": expression must be separated by comma
        Scanner stdin = new Scanner (System.in, "US-ASCII");

        while (stdin.hasNextLine()) {

            String[] input = stdin.nextLine().split(" ");

            for (int i = 0; i < input.length; i++) {

                if (input[i].equals("(")) {

                    continue;

                }

                else if (input[i].equals("*")) {

                    operations.push(input[i]);

                }

                else if (input[i].equals("+")) {

                    operations.push(input[i]);

                }

                else if (input[i].equals("-")) {

                    operations.push(input[i]);

                }

                else if (input[i].equals("/")) {

                    operations.push(input[i]);

                }

                else if (input[i].equals("^")) {

                    operations.push(input[i]);

                }

                else if (input[i].equals("sqrt")) {

                    operations.push(input[i]);

                }

                else if (input[i].equals("abs")) {

                    operations.push(input[i]);

                }

                else if (input[i].equals(")")) {

                    values.push(evaluateOp(operations, values));

                }

                else {

                    try {

                        double x = Double.parseDouble(input[i]);

                        values.push(x);

                    }

                    catch (NumberFormatException e) {

                        System.out.println("NumberFormatException: " + input[i]);

                    }

                }

            }

            double result = values.pop();

            if (values.empty()) {

                System.out.printf("%.2f\n", result);

            }

            else {

                System.out.println("Error");

                operations.clear();

                values.clear();

            }

        }

    }



    public static double evaluateOp (Stack<String> operations, Stack<Double> values) {

        double result = values.pop();

        if (!operations.empty()) {

            String operator = operations.pop();

            switch (operator) {

                case "+":

                    result += values.pop();

                    break;

                case "-":

                    result = values.pop() - result;

                    break;

                case "*":

                    result *= values.pop();

                    break;

                case "/":

                    result = values.pop() / result;

                    break;

                case "sqrt":

                    result = Math.sqrt(result);

                    break;

                case "abs":

                    result = Math.abs(result);

                    break;

                case "^":

                    result = Math.pow(values.pop(), result);

                    break;

                default:

                    System.out.println("evaluate Op Error");

                    break;

            }

        }

        return result;

    }

}