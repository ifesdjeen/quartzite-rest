(ns clojurewerkz.quartzite-rest.views.api
  (:use noir.core clojurewerkz.quartzite-rest.conversions)
  (:require [noir.response                    :as response]
            [clojurewerkz.quartzite.scheduler :as scheduler]
            [clojurewerkz.quartzite.matchers  :as matchers]))

(defpage [:get "/api/v1/scheduler/groups"] {}
  (response/json
   (scheduler/get-job-group-names)))

(defpage "/api/v1/scheduler/groups/:group/triggers"
  {:keys [group]}
  (let [matcher  (matchers/group-equals group)
        triggers (scheduler/get-matching-triggers matcher)]
    (response/json (map to-hash triggers))))

(defpage "/api/v1/scheduler/groups/:group/jobs"
  {:keys [group]}
  (let [matcher  (matchers/group-equals group)
        jobs     (scheduler/get-matching-jobs matcher)]
    (response/json (map to-hash jobs))))
