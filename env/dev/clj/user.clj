(ns user
  (:require [efp-clojure-url-shortener.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [efp-clojure-url-shortener.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'efp-clojure-url-shortener.core/repl-server))

(defn stop []
  (mount/stop-except #'efp-clojure-url-shortener.core/repl-server))

(defn restart []
  (stop)
  (start))


