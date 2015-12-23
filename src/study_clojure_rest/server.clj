(ns study-clojure-rest.server
  (:require [org.httpkit.server :refer [run-server]]))

(defonce server (atom nil))

(defn start-server
  [handler]
  (if (nil? @server) (reset! server (run-server handler {:port 8080}))))

(defn stop-server
  []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))
