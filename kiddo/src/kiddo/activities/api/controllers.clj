(ns kiddo.activities.api.controllers
  (:require
    [kiddo.activities.infra.repo :as repo]
    [cheshire.core :as json]))

(defn index [_request]
  "returns a list of activities"
    (try {:status 200
        :body (-> (repo/find-all)
                  (json/encode))}
       (catch Exception e   {:status 500 :body (json/encode {:msg (str "Error:" e)})})))

(defn create [_request data]
  "returns a list of activities"
    (try {:status 200
        :body (-> (repo/create {:data data} )
                  (json/encode))}
       (catch Exception e   {:status 500 :body (json/encode {:msg (str "Error:" e)})})))
