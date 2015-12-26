(ns study-clojure-rest.routing
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE ANY]]
            [ring.util.response :refer [response header]]))

(defn my-request
  [req]
  (response "Hello, Clojure World!"))

(defn header-test
  [req]
  (-> (response "{\"Hello\": \"Clojure\"}")
      (header "Content-Type" "application/json")))

(defroutes routing
           (ANY "/" []  my-request)
           (ANY "/header-test" []  header-test))
