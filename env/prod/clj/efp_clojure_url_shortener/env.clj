(ns efp-clojure-url-shortener.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[efp-clojure-url-shortener started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[efp-clojure-url-shortener has shut down successfully]=-"))
   :middleware identity})
