(ns oms.core
  (:use compojure.core
        ring.adapter.jetty
        ring.middleware.json-params)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes application-routes
  
  (route/not-found "Page not found"))

(def app
  (-> application-routes        
      handler/api
      wrap-json-params))

(defn start-server []
  (run-jetty (var app) {:port 4000
                        :join? false}))

(defn -main []
  (start-server))

             
                        


                        