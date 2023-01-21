(defproject kiddo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [ring "1.9.6"]
                 [clj-http "3.12.3"]
                 [cheshire "5.11.0"]
                 [compojure "1.7.0"]]

  :main kiddo.core
  :ring {:handler kiddo.core/site
         :init kiddo.core/init}

  :repl-options {:init-ns kiddo.core})
