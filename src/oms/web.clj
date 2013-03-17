(ns oms.web
  (:use [slingshot.slingshot :only [throw+ try+]]
        oms.utils)
  (:require [clojure.data.json :as json]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json; charset=utf-8"}
   :body (json/json-str data)})

(defn error-response [error-object & [status]]
  (json-response {:error (:message error-object)} (or status 500)))

(defn wrap-error-handling [handler]
  (fn [request]
    (try+
     (handler request)
     (catch [:type :not-found] e
       (error-response e 404))
     (catch [:type :bad-request] e
       (error-response e 400))
     (catch [:type :method-not-allowed] e
       (error-response e 405))
     (catch Exception e
       (json-response {:error (.getMessage e)} 500)))))