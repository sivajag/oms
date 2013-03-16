(require '[clj-http.client :as client])

(defn my-pp [m]
  (clojure.pprint/pprint (select-keys m [:status :body])))

;; Version 1
;; ---------

;; List Orders

(clj-http.client/get "http://localhost:4000/api" {:query-params {"action" "list_orders"}
                                                  :as :json})

;; Find Order 1

(clj-http.client/get "http://localhost:4000/api" {:query-params {"action" "view_order"
                                                                 "order_id" "1"}
                                                  :as :json})
;; Delete PAID order

(clj-http.client/get "http://localhost:4000/api" {:query-params {"action" "cancel_order"
                                                                 "order_id" "1"}
                                                  :as :json})

;; Find Order 1

(clj-http.client/get "http://localhost:4000/api" {:query-params {"action" "view_order"
                                                                 "order_id" "1"}
                                                  :as :json})

;; Delete SHIPPED order

(clj-http.client/get "http://localhost:4000/api" {:query-params {"action" "cancel_order"
                                                                 "order_id" "2"}
                                                  :as :json})

;; Delete already cancelled order

(clj-http.client/get "http://localhost:4000/api" {:query-params {"action" "cancel_order"
                                                                 "order_id" "1"}
                                                  :as :json})


