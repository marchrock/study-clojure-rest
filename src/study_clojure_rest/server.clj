(ns study-clojure-rest.server
  (:require [org.httpkit.server :refer [run-server]]
            [environ.core :refer [env]]))

(defonce server (atom nil))

(def server-port-number
  (env :server-port-number))

(defn start-server
  [handler]
  (if (nil? @server) (reset! server (run-server handler {:port server-port-number}))))

(defn stop-server
  []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))
