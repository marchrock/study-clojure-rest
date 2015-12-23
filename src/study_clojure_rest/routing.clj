(ns study-clojure-rest.routing
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE ANY]]
            [ring.util.response :refer [response]]))

(defn my-request
  [req]
  (response "Hello, Clojure World!"))

(defroutes routing
           (ANY "/" []  my-request))
