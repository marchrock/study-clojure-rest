(ns study-clojure-rest.core
  (:require [study-clojure-rest.server :refer [start-server]]
            [study-clojure-rest.routing :refer [routing]]
            [study-clojure-rest.database :refer [start-db-connection]]
            [ring.middleware.defaults :as ring-default]
            [ring.middleware.json :as ring-json]
            [ring.middleware.reload :as ring-reload]
            [environ.core :refer [env]]))

(defn in-dev?
  []
  (env :in-dev))

(def app
  (-> (ring-default/wrap-defaults routing ring-default/api-defaults)
      (ring-json/wrap-json-body {:keywords? true})
      (ring-json/wrap-json-response {:pretty true})
      (as-> handler (if (in-dev?) (ring-reload/wrap-reload handler)
                                  handler))))

(defn -main
  [& args]
  (study-clojure-rest.server/start-server app)
  (start-db-connection))
