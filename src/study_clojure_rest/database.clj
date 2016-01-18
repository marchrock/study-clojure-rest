(ns study-clojure-rest.database
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [environ.core :refer [env]])
  (:import (org.bson.types ObjectId)))

(defonce db-connection (atom nil))

(def db-host
  (env :database-server-host))

(def db-port
  (env :database-server-port))

(def db-name
  (env :database-name))

(defn start-db-connection
  ([] (start-db-connection db-host db-port))
  ([host] (start-db-connection host db-port))
  ([host port] (if (nil? db-connection) (reset! db-connection (mg/connect {:host host :port port})))))

(defn get-db-connection
  (start-db-connection)
  db-connection)

(defn get-db
  ([] (get-db (get-db-connection) db-name))
  ([conn] (get-db conn db-name))
  ([conn name] (mg/get-db conn name)))
