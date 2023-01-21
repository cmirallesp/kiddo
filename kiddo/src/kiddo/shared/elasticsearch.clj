(ns kiddo.shared.elasticsearch
  (:require [clj-http.client :as client]
            [clojure.pprint :refer [pprint]]
            [cheshire.core :as json]))

(def host "http://localhost:9200/")
(def timeouts {:connection-timeout 1000 :socket-timeout 1000})

(defn es-url [index & args]
  ( ->> (apply str args)
       (str host index)))

(defn search [{:keys [index query] :or {query "*:*"}}]
   (let [url (es-url index "/_search?q=" query)]
     (pprint (str "search: " url))
     (-> (client/get url timeouts)
         (:body)
         (json/decode))))

(defn post [{:keys [index data]}]
  (let [url (es-url index "/_doc")]
    (pprint (str "post: " url))
    (pprint data)
    (pprint (str "index: " index))
    (client/post url
                 (assoc timeouts
                        :form-params data
                        :content-type :json ))))
