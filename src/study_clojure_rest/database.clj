(ns study-clojure-rest.database
  (:require [monger.core :as mg]
            [environ.core :refer [env]]))

(defonce db-connection (atom nil))

(def db-host
  (env :database-server-host))

(def db-port
  (env :database-server-port))

(defn start-db-connection
  []
  (if (nil? db-connection) (reset! db-connection (mg/connect {:host db-host :port db-port}))))

(defn get-db-connection
  []
  (start-db-connection)
  db-connection)
