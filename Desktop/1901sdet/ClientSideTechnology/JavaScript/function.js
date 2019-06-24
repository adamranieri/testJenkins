// There are several ways to creat functions in JavaScript

//1st way to make a function
// JS does not support overloading
function hello(){
    console.log("Hello Everyone");
}
hello()
// to store a function in a variable

// we are storing code within a variable
// the code is the value
let hola = function(){

    console.log("Hola")
}
//console.log(hola)
hola() // always remember to invoke your functions
// this is also an anonymous function
// because we never actually gave the function a name
// aka function expression
let add = function(num1,num2){
 //   console.log(num1+num2);
    return (num1+num2);
}

//console.log(add(70,50))

// arrow notation I am big fan
let gutentag = () => {

    console.log("gutentag")
}

let subtract = (num1,num2) =>{
    return num1-num2
}

gutentag()
console.log(subtract(100,85))

// because functions can  stored in variables
// techincally functions are also objects
// we can pass code around 
// we can put functions as parameters to other functions

// this function takes in two functions and calls them both
// we are passing in code to execute 
//not executed code or the return of one
function greetings(greet1, greet2){
        greet1();
        greet2();
}

// this is a callback function
// A callback function is a funtion that is passed a parameter
// to another function
greetings(hola,gutentag)

let multiply = (num1, num2) =>{
    return num1*num2
}

// avoid making functions like this for right now
// store functions in a variable 
function addminus(num1,num2,op1,op2 ){

    console.log(op1(num1,num2)) 
    console.log(op2(num1,num2))   
}

addminus(25,5,add,multiply)

// a self invoking function
// encapsulation, want some code to just exeute, protects name space
// anonymous IFE functions Immediate Invoked Function Expression
(function(){
    console.log("I am a self invoking function")
})();

