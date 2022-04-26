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

## Rationale for choosing the Facade design pattern

We have chosen Facade design pattern to isolate main code from complexity of subclasses and their relationships.

## Job we have done:

To be written...

## The place of the Facade pattern in our code


## Running:

Example file for `com.slewie.recommender.service.CsvMapDataFetcher`:
```csv
108, 5, bar, american, italian
innomax, 4, cafe, italian, japanese, russian
Жар Свежар, 3, cafe, russian, tatar
Art Space, 4, cinema
Cava, 2, cafe, russian, italian
```
