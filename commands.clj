(require '[clj-http.client :as client])

(defn mpp [m]
  (clojure.pprint/pprint (select-keys m [:status :body])))

;; Version 3
;; ---------

;; List Orders

(clj-http.client/get "http://localhost:4000/orders" {:as :json})

;; Find Order 1

(clj-http.client/get "http://localhost:4000/orders/1" {:as :json})

;; Delete PAID order

(clj-http.client/delete "http://localhost:4000/orders/1" {:as :json})

;; Find Order 1

(clj-http.client/get "http://localhost:4000/orders/1" {:as :json
                                                       :throw-exceptions false})

;; Delete SHIPPED order

(clj-http.client/delete "http://localhost:4000/orders/2" {:as :json
                                                          :throw-exceptions false})

;; Delete already cancelled order

(clj-http.client/delete "http://localhost:4000/orders/1" {:as :json
                                                          :throw-exceptions false})


