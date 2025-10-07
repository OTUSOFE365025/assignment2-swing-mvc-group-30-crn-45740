[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)
Example of an MVC design based on Swing. Answer questions 1 & 2 in this README file.

1. Swing is a GUI toolkit for Java that provides things like buttons, check boxes, trees, lists, and tables.
It was created as an extension of the Abstract Window Toolkit, a similar Java GUI toolkit. Newer, more sophisticated components were needed as programs and UIs evolved, 
and the AWT was too limited. Swing provides more flexible components, is loosely coupled, and makes use of the MVC design pattern unlike AWT.
![Class Diagram](swingclassdiagram.PNG)

2. In the Controller class, some functions directly modify UI elements instead of leaving those to the View class.
For example, saveFirstName(), saveLastName(), and sayHello() all change the JOptionPane directly using information passed from the Model class.
This differs from the typical MVC design pattern by not decoupling some of the classes as the typical MVC pattern does.
