(ns efp-clojure-url-shortener.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [efp-clojure-url-shortener.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[efp-clojure-url-shortener started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[efp-clojure-url-shortener has shut down successfully]=-"))
   :middleware wrap-dev})
