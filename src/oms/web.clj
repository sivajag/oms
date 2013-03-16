(ns oms.web
  (:use [slingshot.slingshot :only [throw+ try+]]
        oms.utils)
  (:require [clojure.data.json :as json]))

(defn json-response [data]
  {:status 200
   :headers {"Content-Type" "application/json; charset=utf-8"}
   :body (json/json-str data)})

(defn error-response [error-object]
  (json-response {:error (:message error-object)}))

(defn wrap-error-handling [handler]
  (fn [request]
    (try+
     (print-vals (handler request))
     (catch [:type :not-found] e
       (print-vals (error-response e)))
     (catch [:type :bad-request] e
       (print-vals (error-response e)))
     (catch Exception e
       (print-vals e)
       (json-response {:error (.getMessage e)})))))