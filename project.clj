(defproject oms "0.1.0-SNAPSHOT"

  :description "Order Management System"

  :url "http://zololabs.com"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.4.0"]

                 [compojure "1.1.5"]
                 [fuziontech/ring-json-params "0.2.0"]]

  :exclusions [org.clojure/clojure]


  :plugins [[lein-ring "0.7.1"]]

  :profiles {:dev
             {:dependencies [[clj-stacktrace "0.2.4"]
                             [ring-serve "0.1.2"]]}}

  :min-lein-version "2.0.0"

  :repl-options {:init (do (use 'ring.util.serve) 
                           (use 'clojure.pprint))}

  :bootclasspath false

  :warn-on-reflection false

  :main oms.core)
