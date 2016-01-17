(ns study-clojure-rest.todos
  (:require [compojure.core :refer [routes GET POST]]
            [ring.util.response :refer [response header]]))

(defn get-all-todos
  [req]
  (-> (response "{\"error\": \"not defined yet\"}")
      (header "Content-Type" "application/json")))

(defn add-new-todos
  [req])

(defn todos-routes
  []
  (routes
    (GET "/" [] get-all-todos)
    (POST "/" [] add-new-todos)))
