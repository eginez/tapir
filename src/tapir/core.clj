(ns tapir.core
  (:require [clojure.spec.alpha :as s]
            [tapir.swagger.spec :as sw]
            [clojure.pprint :as pp]
            [clj-yaml.core :as yaml]))

(defn -main
  [& args]
  (println "Hello, World!"))

(defn assert-not [ex]
  (assert (not ex)))

(defn assert-valid [spec val]
  (assert (s/valid? spec val)))

(defn assert-not-valid [spec val]
  (assert-not (s/valid? spec val)))

(def sample-schema
  (->> "test/specs/spec1.yaml" slurp yaml/parse-string))


;;;Testing
;;(pp/pprint sample-schema)
(assert (s/valid? ::sw/http-status-codes 501))

(assert (s/valid? ::sw/data-types "integer"))
(assert-not (s/valid? ::sw/data-types "int"))

(assert (s/valid? ::sw/schemes "https"))
(assert-not (s/valid? ::sw/schemes "ftp"))

(assert-valid ::sw/consumes '("text/plain" "application/json"))
(assert-valid ::sw/consumes [])
(assert-not-valid ::sw/consumes ["nn"])

(assert-valid ::sw/patternedObjects "x-internal-id")
(assert-not-valid ::sw/patternedObjects "internal-id")

(assert-valid ::sw/info (get-in sample-schema [:info]))

