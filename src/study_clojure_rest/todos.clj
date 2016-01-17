(ns study-clojure-rest.todos
  (:require [compojure.core :refer [routes GET]]
            [ring.util.response :refer [response header]]))

(defn get-all-todos
  [req]
  (-> (response "{\"error\": \"not defined yet\"}")
      (header "Content-Type" "application/json")))

(defn todos-routes
  []
  (routes
    (GET "/" [] get-all-todos)))
