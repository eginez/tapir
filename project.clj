(defproject tapir "0.1.0-SNAPSHOT"
  :description "swagger spec to clojure spec"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [org.clojure/clojure "1.9.0-alpha17"]
                 [clj-yaml "0.4.0"]]
  :src ["src/"]
  :main ^:skip-aot tapir.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
