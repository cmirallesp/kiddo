(ns kiddo.activities.infra.repo
  (:require [kiddo.shared.elasticsearch :as es]))

(defn find-all []
  (let [activities (es/search {:index "activities"})
        hits (get activities "hits")]
    {:total (get-in hits ["total" "value"])
     :values (->>
               (get hits "hits")
               (map #(get %1 "_source")))}))

(defn create [data]
  (es/post {:index "activities", :data data}))
