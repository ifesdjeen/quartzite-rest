(ns clojurewerkz.quartzite-rest.views.webview
  (:use clojurewerkz.quartzite-rest.views.common
        clojurewerkz.quartzite-rest.conversions
        noir.core)
  (:require [stencil.core :as st]
            [noir.response                    :as response]
            [clojurewerkz.quartzite.matchers  :as matchers]
            [clojurewerkz.quartzite.scheduler :as scheduler]))

(defpage "/groups"
  []
  (let [groups (vec (scheduler/get-job-group-names))]
    (in-layout
     (st/render-file "templates/groups/index" {:groups groups}))))

(defpage "/groups/:group/triggers"
  {:keys [group]}
  (let [matcher  (matchers/group-equals group)
        triggers (map to-hash (scheduler/get-matching-triggers matcher))]
    (in-layout
     (st/render-file "templates/groups/triggers" {:triggers triggers}))))

(defpage "/groups/:group/jobs"
  {:keys [group]}
  (let [matcher  (matchers/group-equals group)
        jobs     (map to-hash (scheduler/get-matching-jobs matcher))]
    (in-layout
     (st/render-file "templates/groups/jobs" {:jobs jobs}))))
