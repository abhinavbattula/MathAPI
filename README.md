# MathAPI

Application - 'math api'
Implement a web service (in Go, Python, or Java). Feel free to use a framework, if desired.
/min - given list of numbers and a quantifier (how many) provides min number(s)
/max - given list of numbers and a quantifier (how many) provides max number(s)
/avg - given list of numbers calculates their average
/median - given list of numbers calculates their median
/percentile - given list of numbers and quantifier 'q', compute the qth percentile of the list elements
No need to be concerned with resources, we're assuming there's plenty enough of memory, etc. The percentile should just return one
number. Use the nearest-rank method. https://en.wikipedia.org/wiki/Percentile#The_nearest-rank_method

### Description
This Application exposes various endpoints of math api to calculate min,max,avg,median and percentile as per the problem.

### Running the Application
1.Run MathApiApplication.java as spring web application.
2.App launches on tomcat server which runs on localhost:8080.
3.we can test the application from the apps like postman. 
4.IMathController is the interface which exposes the information of the different endpints.

### Testing
Run the tests in MathControllerImplTest file.
