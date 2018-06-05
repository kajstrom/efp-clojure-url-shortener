# efp-clojure-url-shortener

Exercise 54 from Exercises for Programmers in Clojure.

generated using Luminus version "2.9.12.60"

## Todo

- Listing URLs on the front page
- Collecting stats upon visit

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

For local configuration you will need to create dev-config.edn with content:

```
{:dev true
 :port 3000
 :nrepl-port 7000
 :database-url "mongodb://..."
}
```

To start a web server for the application, run:

    lein run 
