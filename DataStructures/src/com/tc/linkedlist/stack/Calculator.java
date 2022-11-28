package com.tc.linkedlist.stack;

public class Calculator {
    public static void main(String[] args) {
//
        String expression = "7*2*2-5+1-5+3-4";
        String keyValue = "";
//        相当于一个遍历指针
        int temp = 0;
//        存放数字的数栈
        ArrayStack2 numStack = new ArrayStack2(10);
//        存放运算符的符号栈
        ArrayStack2 operStack = new ArrayStack2(10);
        while (true) {
//            获取字符串第temp个字符
            char ch = expression.charAt(temp);
//            判断是否是符号
            if (numStack.isOper(ch)) {
//                判断符号栈是否为空
                if (operStack.isEmpty()) {
//                    符号栈为空则直接存入符号栈中
                    operStack.push(ch);
//                    遍历指针加一
                    temp++;
//                    中断这次循环
                    continue;
                }
//                判断ch的优先级是否大于符号栈栈顶元素的优先级
                if (operStack.priority(ch) > operStack.priority(operStack.peek())) {
//                    大于直接存入符号栈中
                    operStack.push(ch);

//                    遍历指针向后移一位
                    temp++;
                    //                    中断这次循环
                    continue;
                }
//                ch的优先级小于等于符号栈栈顶元素的优先级
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                int oper = operStack.pop();
                int val = numStack.cal(num1, num2, oper);
                numStack.push(val);
                operStack.push(ch);
                temp++;
                continue;
            }
//            ch为数字则直接存入
//            numStack.push(ch - 48);

            keyValue += ch;
            if (temp == expression.length() - 1) {
                numStack.push(Integer.parseInt(keyValue));//这行代码执行则无需执行else里面的了
                temp++;
                break;
            }
            if (numStack.isOper(expression.charAt(temp + 1))) {
                numStack.push(Integer.parseInt(keyValue));
                keyValue = "";

            }

            temp++;
//            当遍历指针等于字符串长度则推出循环
            if (temp >= expression.length()) {
                break;
            }

        }
//        该循环是直接计算取两个数和一个运算符最后将结果存入numsStack中，直到运算符数组为空
        while (true) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int oper = operStack.pop();
            int val = numStack.cal(num1, num2, oper);
            numStack.push(val);
            if (operStack.isEmpty()) {
                break;
            }
        }
        System.out.println(numStack.pop());
    }
}
