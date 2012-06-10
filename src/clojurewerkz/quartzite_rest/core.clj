(ns clojurewerkz.quartzite-rest.core
  (:require [noir.server :as server]
            [clojurewerkz.quartzite.scheduler :as scheduler]

            [stencil.core :as st]
            [noir.response        :as response]))

(defn initialize-quartz
  []
  (scheduler/initialize)
  (scheduler/start))

(defn start-server!
  []
  (server/load-views-ns 'clojurewerkz.quartzite-rest.views)
  (server/start 8080))

(defn -main
  []
  (initialize-quartz)
  (start-server!))