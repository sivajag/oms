(require '[clj-http.client :as client])

;; Version 1
;; ---------

;; Create Order
(pprint (client/get "http://localhost:4000/api" {:query-params {"action" "create_order"
                                                                "products" ["p5" "p7"]}
                                                 :as :json}))

;; List Orders
(pprint (client/get "http://localhost:4000/api" {:query-params {"action" "list_orders"}
                                                 :as :json}))

;; View Order


;; Pay Order


;; Cancel Order