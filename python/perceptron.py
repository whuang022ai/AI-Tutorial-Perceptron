# -*- coding: utf-8 -*-
"""
Created on Thu May 10 15:27:35 2018

@author: lovedoglion
"""

import math,random

eta=0.7 #learning rate
w1=0
w2=0
b1=0

#neural(input1,input2,desire output)
def neural(x1, x2, d):
    global w1,w2,b1 #在函数内部访问并修改全局变量
    net=w1*x1+w2*x2+b1
    Y=1/(1+ math.exp(-net))#Sigmoid函數
    #backward path 更新權重的方法
    w1+=eta*(d-Y)*Y*(1-Y)*x1
    w2+=eta*(d-Y)*Y*(1-Y)*x2
    b1+=eta*(d-Y)*Y*(1-Y)*1
    return d-Y

#learn AND
def neuralAND():
    x=random.randint(0,1)
    y=random.randint(0,1)
    z=x&y
    return print('neuralAND：',neural(x,y,z))

#learn OR
def neuralOR():
    x=random.randint(0,1)
    y=random.randint(0,1)
    z=x|y
    return print('neuralOR：',neural(x,y,z))

#learn XOR
def neuralXOR():
    x=random.randint(0,1)
    y=random.randint(0,1)
    z=x^y #XOR位元運算
    return print('neuralXOR：',neural(x,y,z))
    
#初始化權重與
def init():
    global w1,w2,b1
    w1=random.random()
    w2=random.random()
    b1=random.random()
    
#main
for j in range(1000):
    neuralOR()