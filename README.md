# SAD-

## Assignment Description

The task was to implement tour recommending system generating user-friendly results by analysing the user’s online activity 
and collecting information related to their interests & locations. This system based on data science is developed as an online application, 
which is capable of producing a personalized list of recommendations by mining & analysing the user’s data from their social network 
data history to perform better analysis & predictions.

In this system, the user can make a day plan by selecting his list of places based on his preferences of Food & place type. 
There can be any number of plans made and all the places are fetched using Google place API and based on Highest rating. 
The Plan considered your total number of hours added, so that it can calculate your travelling time + time spend on a particular location. 
The final places can be manually sorted by the user or can use auto sort to get the proper route. The system will give 
suggestions of places where and when required based on other users plans.

## Rationale for choosing the Chain of Responsibility design pattern

We have chosen Chain of Responsibility design pattern because we have many handlers, and it is the best pattern to pass requests within hierarchy of classes.

## Job we have done:

Firstly, we constructed a UML diagram containing interfaces, enumerators, and classes. In these objects, we have implemented all need things to manipulate with map and users. Secondly, we wrote code that realizes all objects from UML and creates a CLI application.

## The place of the Chain of Responsibility pattern in our code

In our code, Chain of Responsibility pattern takes place right in ApplicationFacade class, which is called by Main method. ApplicationFacade class gets arguments from input  file and then creates instances of consecutive classes(dataHandler, dataFetcher, dataFiltrer and DisplayService), sets the order of running of this classes, passes arguments to the first component of execution and catches Ecxeptions during runtime. This orderly executing of program componets is realization of Chain of Responsibility.

## The application of a Chain of Responsibility pattern

Chain of Responsibility pattern controls sequential executing of programm classes designed for different needs in the following order: dataHandler -> data Fetcher -> dataFiltrer -> DisplayService.

## Steps to execute our program:

1)  Create text file with data written as in the example below:

Example file for `com.slewie.recommender.service.CsvMapDataFetcher`:
```csv
108, 5, bar, american, italian
innomax, 4, cafe, italian, japanese, russian
Жар Свежар, 3, cafe, russian, tatar
Art Space, 4, cinema
Cava, 2, cafe, russian, italian
```
2) Run the Main method with the name of the input file as the first argument.
