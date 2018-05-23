/***************************************************************************
*
*  Perceptron.java
*  
*
*
* This is a hard coding version of Sigmoid Perceptron.
* It is just for "Hello World" for the A.I beginners.
*
*
***************************************************************************
* Copyright 2018 whuang022.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
* 
 **************************************************************************/

package perceptron;

import java.util.Random;

/**
 * Perceptron
 * @author whuang022
 */


public class Perceptron {
    
    
    private Random ran = new Random();   
    private double eta=0.7;//learning rate
    private double w1=0;
    private double w2=0;
    private double b1=0;

    double boolTdouble(boolean in){
        if(in){
            return 1.0;
        }else{
            return 0.0;
        }
    }
    // The Neural
    // neural(input1,input2,desire output)

    private double neural(double x1,double x2,double d){
        //forward path
        //System.out.println("Input"+x1+":"+x2+""+d);
        double n=w1*x1+w2*x2+b1;	
        double o =1/(1+Math.pow(Math.E,(-1*n)));
        //backward path
        w1+=eta*(d-o)*o*(1-o)*x1;
        w2+=eta*(d-o)*o*(1-o)*x2;
        b1+=eta*(d-o)*o*(1-o)* 1;	
        return (d-o);
    }

    // learn AND
    // this will converge
    public void neuralAND(){
       boolean x=ran.nextBoolean();
       boolean y=ran.nextBoolean();
       boolean z=x&y;
       System.out.println(neural(boolTdouble(x),boolTdouble(y),boolTdouble(z)));
    }

    // learn OR
    // this will converge
    public void neuralOR(){
       boolean x=ran.nextBoolean();
       boolean y=ran.nextBoolean();
       boolean z=x|y;
       System.out.println(neural(boolTdouble(x),boolTdouble(y),boolTdouble(z)));
    }

    // learn XOR
    // this will not converge
    public void neuralXOR(){
       boolean x=ran.nextBoolean();
       boolean y=ran.nextBoolean();
       boolean z=x^y;
       System.out.println(neural(boolTdouble(x),boolTdouble(y),boolTdouble(z)));
    }

    // Init the weight
    // random 0~1 

    public void init(){
        w1=ran.nextDouble();
        w2=ran.nextDouble();
        b1=ran.nextDouble();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Perceptron neural=new Perceptron();
        neural.init();
        for(int i=0;i<5000;i++){
            neural.neuralAND();
	}
    }
    
}
