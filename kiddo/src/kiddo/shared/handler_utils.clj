(ns kiddo.shared.handler-utils)


(defn content-type-response [response content-type]
  (assoc-in response [:headers "Content-Type"] content-type))


(defn with-content-type [handler contet-type]
  (fn [request]
    (-> (handler request)
        (content-type-response contet-type))))

(defn json-handler [handler]
  (with-content-type handler "application/json"))
