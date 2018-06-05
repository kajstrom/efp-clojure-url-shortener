(ns efp-clojure-url-shortener.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [mount.core :refer [defstate]]
              [efp-clojure-url-shortener.config :refer [env]]
              [clojure.set :refer [rename-keys]]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

(defn format-url [url]
  (if-not (nil? url)
    (update (rename-keys url {:_id :id}) :id #(.toString %))))

(defn add-url [url]
  (format-url (mc/insert-and-return db "urls" {:url url})))

(defn find-url [url]
  (format-url (mc/find-one-as-map db "urls" {:url url})))