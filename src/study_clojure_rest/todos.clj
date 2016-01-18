(ns study-clojure-rest.todos
  (:require [study-clojure-rest.database :refer [db-insert]]
            [compojure.core :refer [routes GET POST]]
            [ring.util.response :refer [response header]]))

(def todo-db-collection-name
  "Todos")

(defn has-todo-name?
  [todo-map]
  (contains? todo-map :name))

(defn is-todo?
  [probably-todo-map]
  (do (println probably-todo-map)
      (has-todo-name? probably-todo-map)))

(defn get-all-todos
  [req]
  (-> (response "{\"error\": \"not defined yet\"}")
      (header "Content-Type" "application/json")))

(defn add-new-todos
  [req]
  (let [body (req :body)]
    (if (is-todo? body) (do (db-insert todo-db-collection-name body)
                            (-> (response (assoc {} :result "success" :value body))
                                (header "Content-Type" "application/json; charset=utf-8")))
                        (-> (response {:error "invalid todo data"})
                            (header "Content-Type" "application/json; charset=utf-8")))))

(defn todos-routes
  []
  (routes
    (GET "/" [] get-all-todos)
    (POST "/" [] add-new-todos)))
