(ns clojurewerkz.quartzite-rest.views.webview
  (:use clojurewerkz.quartzite-rest.views.common noir.core)
  (:require [stencil.core :as st]
            [noir.response                    :as response]
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
