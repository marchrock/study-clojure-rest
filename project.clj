(defproject study-clojure-rest "0.1.0-SNAPSHOT"
  :description "study-clojure-rest"
  :url "http://github.com/marchrock"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-core "1.4.0"]
                 [http-kit "2.1.19"]
                 [compojure "1.4.0"]]
  :profiles {:dev {:dependencies [[midje "1.8.3"]
                                  [ring/ring-mock "0.3.0"]
                                  [ring/ring-devel "1.4.0"]]}}
  :main study-clojure-rest.core)
