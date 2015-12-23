(ns study-clojure-rest.core
  (:require [study-clojure-rest.server :refer [start-server]]
            [study-clojure-rest.routing :refer [routing]]))

(defn -main
  [& args]
  (study-clojure-rest.server/start-server routing))
