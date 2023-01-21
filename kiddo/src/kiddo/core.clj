(ns kiddo.core
  (:require
    [ring.adapter.jetty :as jetty]
    [compojure.core :refer [defroutes, GET]]
    [kiddo.shared.handler-utils :refer [json-handler]]
    [kiddo.activities.api.controllers :as activities]))


(defroutes app
  (GET "/activities" [] (json-handler activities/index)))

;(def app
  ;(wrap-content-type handler "application/json"))

(defn -main
  [& [port]]
  (if port
    (jetty/run-jetty #'app {:port (Integer. port)})
    (println "No port specified, exiting.")))
