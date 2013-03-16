(ns oms.domain.order
  (:use [slingshot.slingshot :only [throw+ try+]]
        oms.utils))

(def STORE (atom
            {:1 {:id :1 :products [:p1 :p2 :p3] :status "PAID"}
             :2 {:id :2 :products [:p2 :p4 :p6] :status "SHIPPED"}
             :3 {:id :3 :products [:p3 :p6 :p9] :status "DELIVERED"}}))

(defn- new-order-id []
  (keyword (str (rand))))

(defn create-order [attrs]
  (let [id (new-order-id)
        new-attrs (merge {:id id} attrs)]
    (swap! STORE merge {id new-attrs})
    new-attrs))

(defn find-all []
  (vals @STORE))

(defn find-order [id]
  (if-let [o ((keyword id) @STORE)]
    o
    (throw+ {:type :not-found :message "Order is not present with given ID"})))

(defn update [id attrs]
  (let [updated-attrs (merge (find-order id) attrs)]
    (swap! STORE assoc id updated-attrs)
    updated-attrs))

(defn delete [id]
  (let [o (find-order id)]
    (if (= "PAID" (:status o))
      (do (swap! STORE dissoc (:id o))
          {})
      (throw+ {:type :bad-request :message (str "Order is already " (:status o))}))))



