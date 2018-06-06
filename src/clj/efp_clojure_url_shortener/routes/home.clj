(ns efp-clojure-url-shortener.routes.home
  (:require [efp-clojure-url-shortener.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [efp-clojure-url-shortener.db.core :as db]))

(defn home-page [{:keys [flash]}]
  (layout/render
    "home.html" {:flash flash}))

(defn stats-page [id]
  (layout/render "stats.html" (db/find-by-id id)))

(defn add-url [request]
  (let [url (get-in request [:params :url])]
    (if-let [prev-url (db/find-url url)]
      (-> (response/found "/")
          (assoc :flash {:url (:id prev-url) :existing true}))
      (-> (response/found "/")
          (assoc :flash {:url (:id (db/add-url url)) :existing false})))))

(defn forward-to-url [id]
  (println id)
  (try
    (if-let [url (db/find-by-id id)]
      (do
        (db/update-url (update url :visits inc))
        (response/found (:url url)))
      (response/found "/"))
    (catch java.lang.IllegalArgumentException e (response/found "/"))))

(defroutes home-routes
  (GET "/" request(home-page request))
  (GET "/u/:id" [id] (forward-to-url id))
  (GET "/u/:id/stats" [id] (stats-page id))
  (POST "/add" request (add-url request)))

