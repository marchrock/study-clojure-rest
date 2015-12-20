(ns study-clojure-rest.server
  (:require [org.httpkit.server :refer [run-server]]))

(defonce server (atom nil))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello, Clojure World!"})

(defn start-server
  []
  (if (nil? @server) (reset! server (run-server #'app {:port 8080}))))

(defn stop-server
  []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))
