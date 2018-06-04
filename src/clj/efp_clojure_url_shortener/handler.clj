(ns efp-clojure-url-shortener.handler
  (:require 
            [efp-clojure-url-shortener.layout :refer [error-page]]
            [efp-clojure-url-shortener.routes.home :refer [home-routes]]
            [compojure.core :refer [routes wrap-routes]]
            [compojure.route :as route]
            [efp-clojure-url-shortener.env :refer [defaults]]
            [mount.core :as mount]
            [efp-clojure-url-shortener.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
      (-> #'home-routes
          (wrap-routes middleware/wrap-csrf)
          (wrap-routes middleware/wrap-formats))
          (route/not-found
             (:body
               (error-page {:status 404
                            :title "page not found"}))))))

