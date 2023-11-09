# Lab 01 Assignment

> 班级：222111
>
> 学号：22373340
>
> 姓名：詹佳博

## Question 02

![Lab1(10)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(10).jpg)![Lab1(11)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(11).jpg)

## Question 03

![Lab1(3)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(6).jpg)![Lab1(3)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(3).jpg)

## Question 04

![Lab1(2)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(2).png)

## Question 05

![Lab1(1)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(1).jpg)

## Question 06

![Lab1(7)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(7).jpg)

| 基本类型 | 默认值 | **基本类型** |  默认值  |
| :------: | :----: | :----------: | :------: |
|   byte   |   0    |   boolean    |  false   |
|  short   |   0    |     char     | '\u0000' |
|   int    |   0    |    float     |   0.0f   |
|   long   |   0L   |    double    |   0.0d   |

## Question 07

![Lab1(8)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(8).jpg)

## Question 08

![Lab1(5)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(5).jpg)

**Java执行串联逻辑运算时的流程：** 

当执行||逻辑时，按顺序从左至右检视条件。只有当条件1为false的时候，才会继续检视条件2；否则直接输出true。若顺序检视条件的时候一直是false，则遇到第一个true条件时再直接终止检视，输出true。只有所有条件均为false时，才会检视所有条件，并输出false。

当执行&&逻辑时，按顺序从左至右检视条件。只有当条件1为true的时候，才会继续检视条件2；否则直接输出false。若顺序检视条件的时候一直是true，则遇到第一个false条件时再直接终止检视，输出false。只有所有条件均为true时，才会检视所有条件，并输出true。

**Java利用短路这个机制来优化程序：**

若遇到多条件逻辑判断的时候，可以事先计算该事件可能的结果几率。

在||判断的时候，优先将更可能为true的条件置于前面，这样可以减少计算次数优化程序速度；在&&判断的时候，优先将更可能为false的条件置于前面，这样可以减少计算次数优化程序速度。

## Question 09

![Lab1(4)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(4).jpg)

## Question 10

![Lab1(9)](C:\Users\28600\Desktop\Java\Lab1\work\Lab1(9).jpg)