(require '[clj-http.client :as client])

(defn mpp [m]
  (clojure.pprint/pprint (select-keys m [:status :body])))

;; Version 2
;; ---------

;; List Orders

(clj-http.client/get "http://localhost:4000/list_orders" {:as :json})

;; Find Order 1

(clj-http.client/get "http://localhost:4000/view_order/1" {:as :json})

;; Delete PAID order

(clj-http.client/get "http://localhost:4000/cancel_order/1" {:as :json})

;; Find Order 1

(clj-http.client/get "http://localhost:4000/view_order/1" {:as :json})

;; Delete SHIPPED order

(clj-http.client/get "http://localhost:4000/cancel_order/2" {:as :json})

;; Delete already cancelled order

(clj-http.client/get "http://localhost:4000/cancel_order/1" {:as :json})


