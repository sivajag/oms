(require '[clj-http.client :as client])

;; Version 1
;; ---------

;; List Orders
(pprint (client/get "http://localhost:4000/api" {:query-params {"action" "list_orders"}
                                                 :as :json}))

;; Find Order 1
(pprint (client/get "http://localhost:4000/api" {:query-params {"action" "view_order"
                                                                "order_id" "1"}
                                                 :as :json}))
;; Delete PAID order
(pprint (client/get "http://localhost:4000/api" {:query-params {"action" "cancel_order"
                                                                "order_id" "1"}
                                                 :as :json}))

;; Find Order 1
(pprint (client/get "http://localhost:4000/api" {:query-params {"action" "view_order"
                                                                "order_id" "1"}
                                                 :as :json}))

;; Delete SHIPPED order
(pprint (client/get "http://localhost:4000/api" {:query-params {"action" "cancel_order"
                                                                "order_id" "2"}
                                                 :as :json}))

;; Delete already cancelled order
(pprint (client/get "http://localhost:4000/api" {:query-params {"action" "cancel_order"
                                                                "order_id" "1"}
                                                 :as :json}))


