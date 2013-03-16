(defproject oms "0.1.0-SNAPSHOT"

  :description "Order Management System"

  :url "http://zololabs.com"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.4.0"]

                 [compojure "1.1.5"]
                 [fuziontech/ring-json-params "0.2.0"]
                 [ring/ring-core "1.2.0-beta1"]

                 [org.clojure/data.json "0.1.2"]

                 [slingshot "0.10.3"]]

  :exclusions [org.clojure/clojure
               ring/ring-core]


  :plugins [[lein-ring "0.7.1"]]

  :profiles {:dev
             {:dependencies [[clj-stacktrace "0.2.4"]
                             [ring-serve "0.1.2"]
                             [clj-http "0.6.5"]]}}

  :min-lein-version "2.0.0"

  :repl-options {:init (do (use 'ring.util.serve) 
                           (use 'clojure.pprint)
                           (use 'oms.core)
                           (require '[clj-http.client :as client]))}

  :bootclasspath false

  :warn-on-reflection false

  :main oms.core)
