(ns study-clojure-rest.core
  (:require [study-clojure-rest.server :refer [start-server]]))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello, Clojure World!"})

(defn -main
  [& args]
  (study-clojure-rest.server/start-server app))
