package com.tc.linkedlist.stack;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//逆波兰计算器的实现
public class PolandNotation {
    public static void main(String[] args) {
       /* String value = "4 5 * 8 - 60 + 8 2 / +";
        calculator(value);*/
        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        List<String> suffixConvert = suffixConvert(list);
        calculator2(suffixConvert);

    }

    public static List<String> suffixConvert(List<String> prefix) {
//        存符号的栈
        Stack<String> s1 = new Stack<>();
//        存后缀表达式
        ArrayList<String> s2 = new ArrayList<>();

        for (String item : prefix) {
            if (item.matches("\\d+")) {
                s2.add(item);
                continue;
            }
            if (s1.size() == 0) {
                s1.push(item);
                continue;
            }
            if (item.equals("(")) {
                s1.push(item);
                continue;
            }
            if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
                continue;
            }

            if (operatorPriority(item) <= operatorPriority(s1.peek())) {
                while (s1.size() != 0 && operatorPriority(item) <= operatorPriority(s1.peek())) {
                    s2.add(s1.pop());
                }
            }
            s1.push(item);
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //判断符号优先级
    public static int operatorPriority(String operator) {
        int res = 0;
        switch (operator) {
            case "+":
            case "-":
                res = 1;
                break;
            case "*":
            case "/":
                res = 2;
                break;
            default:
                System.out.println("该符号不存在");
                break;
        }
        return res;

    }


    //将中缀表达式转为ArrayList数组
    public static List<String> toInfixExpressionList(String expression) {

        int temp = 0;
        char ch;
        String key;
        ArrayList<String> list = new ArrayList<>();
        do {
            ch = expression.charAt(temp);
            if (expression.charAt(temp) < 48 || expression.charAt(temp) > 57) {
                list.add(ch + "");
                temp++;
                continue;
            }
            key = "";
            while (temp < expression.length() && (expression.charAt(temp) >= 48 && expression.charAt(temp) <= 57)) {
                key += expression.charAt(temp);
                temp++;
            }
            list.add(key);

        } while (temp < expression.length());


        return list;

    }

    //计算后缀表达式
    public static void calculator(String value) {
        Stack<String> stack = new Stack<>();
        List<String> elementList = getList(value);
        for (String item : elementList) {
            if (item.matches("\\d+")) {
                stack.push(item);
                continue;
            }
            int num1 = Integer.parseInt(stack.pop());
            int num2 = Integer.parseInt(stack.pop());
            int res = 0;
            if (item.equals("+")) {
                res = num2 + num1;
            }

            if (item.equals("-")) {
                res = num2 - num1;
            }

            if (item.equals("*")) {
                res = num2 * num1;
            }
            if (item.equals("/")) {
                res = num2 / num1;
            }
            stack.push(res + "");
        }
        System.out.println(stack.pop());
    }
    //计算后缀表达式
    public static void calculator2(List<String> elementList) {
        Stack<String> stack = new Stack<>();
        for (String item : elementList) {
            if (item.matches("\\d+")) {
                stack.push(item);
                continue;
            }
            int num1 = Integer.parseInt(stack.pop());
            int num2 = Integer.parseInt(stack.pop());
            int res = 0;
            if (item.equals("+")) {
                res = num2 + num1;
            }

            if (item.equals("-")) {
                res = num2 - num1;
            }

            if (item.equals("*")) {
                res = num2 * num1;
            }
            if (item.equals("/")) {
                res = num2 / num1;
            }
            stack.push(res + "");
        }
        System.out.println(stack.pop());
    }
    //    将后缀表达式转为ArrayList集合
    public static List<String> getList(String value) {
        String[] val = value.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String item : val) {
            list.add(item);
        }
        return list;


    }
}
