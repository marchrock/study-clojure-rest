(ns study-clojure-rest.routing-test
  (:require [clojure.test :refer :all]
            [midje.sweet :refer [fact]]
            [midje.parsing.arrow-symbols :refer [=>]]
            [study-clojure-rest.routing :refer :all]
            [ring.mock.request :as mock]))

(deftest my-request-test
  (is (= (routing (mock/request :get "/"))
         {:status 200
          :headers {}
          :body "Hello, Clojure World!"})))

(fact "about '/'"
      (routing (mock/request :get "/")) => {:status 200
                                            :headers {}
                                            :body "Hello, Clojure World!"})
