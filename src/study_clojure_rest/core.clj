(ns study-clojure-rest.core
  (:require [study-clojure-rest.server :refer [start-server]]
            [ring.util.response :refer [response]]))

(defn app
  [req]
  (response "Hello, Clojure World!"))

(defn -main
  [& args]
  (study-clojure-rest.server/start-server app))
