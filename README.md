# movie-demo

My playground spring boot app. I use data from IMDb's datasets (https://www.imdb.com/interfaces/). Currently only importing the main movie table with 5 million records.

## Build

When using docker toolbox make sure the docker-machine has enough memory (default of 2GB is not enough):
`docker-machine create -d virtualbox --virtualbox-cpu-count=2 --virtualbox-memory=4096 --virtualbox-disk-size=50000 default`

`docker-compose up --build`

Some choices:
- spring boot - try to go with spring boot's default choices and most simple setup as much as possible without too much performance trade-offs
- spring data specifications for data filtering   
- postgresql - earlier h2 database, but has performance issue when ordering large data sets
- lombok - why type those getters, setters, builder patterns, etc..
- hexagonal/union architecture: domain in middle, all ports depend on application or domain (rest api, importer), no dependencies between ports. However, keep JPA annotations on domain classes. Converting messages from domain to port or back with spring's ConversionService mechanism
- clear separation of concerns; global converters - annotation on fields shouldn't tell how to (de)serialize to json/database

(possible) TODOs:
- mavenize docker build & run
- performance of SortingAndPagingRepository using the Page return type sucks due to additional count query. Possible fixes:
  - find out whether JPA's L2 cache mechanism can help?
  - endless search so no grand total needs to be fetched
  - asynchronous count query by splitting result set retrieval from count query
  - elastic search / solr like solution
- split off importer as seperate microservice and use spring cloud stream
- import more tables from IMDB
- investigate / experiment with spring web reactive framework
- further experiments with docker (swarm), kubernetes?
  
