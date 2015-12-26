(ns study-clojure-rest.routing-test
  (:require [clojure.test :refer :all]
            [midje.sweet :refer :all :exclude [=>]]
            [midje.parsing.arrow-symbols :refer [=>]]
            [study-clojure-rest.routing :refer :all]
            [ring.mock.request :as mock]))

(fact "about '/'"
      (routing (mock/request :get "/")) => {:status 200
                                            :headers {}
                                            :body "Hello, Clojure World!"})

(fact "about '/header-test'"
      (routing (mock/request :get "/header-test")) => {:status 200
                                                       :headers {"Content-Type" "application/json"}
                                                       :body "{\"Hello\": \"Clojure\"}"})
