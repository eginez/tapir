;; Spec from http://swagger.io/specification/
(ns tapir.swagger.spec
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]))


(def mime-types
  #{"text/plain; charset=utf-8"
    "text/plain"
    "application/json"
    "application/vnd.github+json"
    "application/vnd.github.v3+json"
    "application/vnd.github.v3.raw+json"
    "application/vnd.github.v3.text+json"
    "application/vnd.github.v3.html+json"
    "application/vnd.github.v3.full+json"
    "application/vnd.github.v3.diff"
    "application/vnd.github.v3.patch"})

;;Refine this
(s/def ::http-status-codes
  (s/and integer?
         #(> % 99)
         #(< % 502)))

(s/def ::data-types
  #{"integer" "long" "float" "double"
    "string" "byte" "binary" "boolean"
     "date" "dateTime" "password"})


(s/def ::name string?)
(s/def ::url string?)
(s/def ::email string?)
(s/def ::version string?)
(s/def ::title string?)
(s/def ::description string?)
(s/def ::termsOfService string?)

(s/def ::contact
  (s/keys :opt-un
          [::name ::url ::email]))
(s/def ::license
  (s/keys :req-un [::name] :opt-un [::url]))


(s/def ::swagger string?)
(s/def ::info
  (s/keys
    :req-un [::title ::version]
    :opt-un [::description ::termsOfService ::contact ::license]))
(s/def ::host string?)
(s/def ::basePath string?)
(s/def ::schemes #{"https" "http" "wss" "ws"})
(s/def ::consumes (s/coll-of mime-types))
(s/def ::produces ::consumes)
;;(s/def ::paths) TODO required
;;(s/def ::parameters) TODO required
;;(s/def ::responses) TODO required
;;(s/def ::securityDefinitions) TODO required
;;(s/def ::security) TODO required
;;(s/def ::tags) TODO required
;;(s/def ::tags) TODO required
;;(s/def ::externalDocs) TODO required
(s/def ::patternedObjects
  (s/and
    string?
    #(str/starts-with? % "x-")))




