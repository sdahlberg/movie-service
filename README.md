# movie-demo

My playground spring boot app. I use data from IMDb's datasets (https://www.imdb.com/interfaces/). Currently only importing the main movie table with 5 millions records.

Main dependencies:
- spring boot - try to go with spring's choices as much as possible without too much performance trade-offs
- postgresql - earlier h2 database, but has performance issue when ordering large data sets
- lombok - why type those getters, setters, builder patterns, etc..
