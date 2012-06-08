(ns quartzite-rest.core
  (:use noir.core)
  (:require [noir.server :as server]
            [clojurewerkz.quartzite.scheduler :as scheduler]
            [clojurewerkz.quartzite.matchers  :as matchers]

            [clostache.parser     :as clstch]

            [noir.response        :as response]

            ))

(defpage [:get "/jobs/group_names"] {}
  (response/json
                 (scheduler/get-job-group-names)))


(defn initialize-quartz
  []
  (scheduler/initialize)
  (scheduler/start))

(defn -main
  []
  (initialize-quartz)
  (server/start 8080))