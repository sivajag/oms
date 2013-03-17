(ns oms.api
  (:use oms.utils)
  (:require [oms.domain.order :as order]))

(defn create-order [params]
  (order/create-order params))

(defn list-orders []
  (order/find-all))

(defn view-order [id]
  (order/find-order id))

(defn cancel-order [id]
  (order/delete id))


