(ns oms.api
  (:use oms.utils
        [slingshot.slingshot :only [throw+ try+]])
  (:require [oms.domain.order :as order]))

(defn order-url [o]
  (str "/orders/" (name (:id o))))

(defn create-order [params]
  (let [o (order/create-order params)]
    {:status 201
     :headers {"Content-Type" "application/json; charset=utf-8"
               "Location " (order-url o)}
     :body {}}))

(defn list-orders []
  (order/find-all))

(defn view-order [id]
  (order/find-order id))

(defn cancel-order [id]
  (order/delete id))


