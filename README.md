# App for parsing tweets from twitter

I needed to get tweets from different accounts and save them as a .csv file for statistics reasons.
The result was this short project. (it took something like 2h) Maybe it will help somebody.

## Properties file:
**It is compulsory to fill in the properties file:** TwitterApiParser\src\main\resources\twitter4j.properties<br>
```
oauth.consumerKey =
oauth.consumerSecret =
oauth.accessToken =
oauth.accessTokenSecret =
```

## Input:
1. Name of the twitter account <br>
2. Number of tweets

## Output:
CSV file

## Limitation
* Maximum number of tweets - **3200** (*due to the TwitterAPI limitation*)


##Example of usage:
```
java -classpath TwitterApiParser.jar com.janczura.Combiner unisyscorp 600
```