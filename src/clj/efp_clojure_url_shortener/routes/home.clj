(ns efp-clojure-url-shortener.routes.home
  (:require [efp-clojure-url-shortener.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html"))

(defn add-url [request]
  (println request)
  (response/found "/"))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/add" request (add-url request))
  (GET "/about" [] (about-page)))

