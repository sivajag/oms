(ns oms.core
  (:use compojure.core
        ring.adapter.jetty
        ring.middleware.json-params)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :as json]
            [oms.api :as api]
            [oms.web :as web]))

(defroutes application-routes

  (POST "/orders" [params] (api/create-order params))

  (GET "/orders" [params] (web/json-response (api/list-orders)))

  (GET "/orders/:order-id" [order-id] (web/json-response (api/view-order order-id)))

  (DELETE "/orders/:order-id" [order-id] (web/json-response (api/cancel-order order-id)))
  
  (route/not-found "Page not found"))

(def app
  (-> application-routes
      handler/api
      wrap-json-params
      web/wrap-error-handling
      ))

(defn start-server []
  (run-jetty (var app) {:port 4000
                        :join? false}))

(defn -main [& args]
  (start-server))

             
                        


                        