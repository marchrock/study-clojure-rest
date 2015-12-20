(ns study-clojure-rest.core
  (:require [study-clojure-rest.server :refer [start-server]]))

(defn -main
  [& args]
  (study-clojure-rest.server/start-server))
