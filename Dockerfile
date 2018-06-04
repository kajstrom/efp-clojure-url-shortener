FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/efp-clojure-url-shortener.jar /efp-clojure-url-shortener/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/efp-clojure-url-shortener/app.jar"]
