(ns oms.api
  (:use oms.utils)
  (:require [oms.domain.order :as order]))

(defn perform [action params]
  (condp = (keyword action)
    :create_order (order/create-order params)
    :list_orders (order/find-all)
    :view_order (order/find-order (:order_id params))
    :pay_order (order/update (:order_id params) {:status "PAID"})
    :cancel_order (order/delete (:order_id params))))

