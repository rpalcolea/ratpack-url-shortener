ratpack url shortener
=================================

Example of Ratpack / Redis for a URL Shortener service. 

## Getting Started

Check this project out, cd into the directory and run:

    ./gradlew shadowJar

This will build the jar. Now run:

    java -jar build/libs/ratpack-url-shortener-all.jar 

This will start the ratpack app.

## Add a URL

 <http://localhost:5050/add?url=url>
 
 example:
 
 <http://localhost:5050/add?url=http://www.ratpack.io>
 
## Go to URL

 <http://localhost:5050/0a9705a9>

## Notes
*To run this app, you need Redis installed*

