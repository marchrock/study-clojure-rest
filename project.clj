(defproject study-clojure-rest "0.1.0-SNAPSHOT"
  :description "study-clojure-rest"
  :url "http://github.com/marchrock"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [http-kit "2.1.19"]
                 [compojure "1.4.0"]
                 [environ "1.0.1"]
                 [com.novemberain/monger "3.0.1"]]
  :profiles {:dev {:dependencies [[midje "1.8.3"]
                                  [ring/ring-mock "0.3.0"]
                                  [ring/ring-devel "1.4.0"]]
                   :env {:server-port-number 3000
                         :database-server-host "localhost"
                         :database-server-port 27017
                         :database-name "db-study-clojure-rest"
                         :in-dev true}}}
  :main study-clojure-rest.core)
