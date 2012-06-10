(ns clojurewerkz.quartzite-rest.conversions
  (:import [org.quartz.impl.triggers AbstractTrigger]
           [org.quartz.impl JobDetailImpl]
           [org.quartz JobKey TriggerKey]))

(defprotocol ToHash
  (to-hash [x]))

(extend-protocol ToHash
  JobKey
  (to-hash [job-key]
    {:name (.getName job-key) :group (.getGroup job-key) }))

(extend-protocol ToHash
  TriggerKey
  (to-hash [trigger-key]
    {:name (.getName trigger-key) :group (.getGroup trigger-key) }))

(extend-protocol ToHash
  AbstractTrigger
  (to-hash [trigger]
    {:end-time         (.getEndTime trigger)
     :final-fire-time  (.getFinalFireTime trigger)
     :calendar-name    (.getCalendarName trigger)
     :description      (.getDescription trigger)
     :fire-instance-id (.getFireInstanceId trigger)
     :full-job-name    (.getFullJobName trigger)
     :full-name        (.getFullName trigger)
     :group            (.getGroup trigger)
     :job-group        (.getJobGroup trigger)
     :job-name         (.getJobName trigger)
     :job-key          (to-hash (.getJobKey trigger))
     :key              (to-hash (.getKey trigger))
     :name             (.getName trigger)
     :priority         (.getPriority trigger)}))


(extend-protocol ToHash
  JobDetailImpl
  (to-hash [job]
    {:description (.getDescription job)
     :full-name   (.getFullName job)
     :group       (.getGroup job)
     :key         (to-hash (.getKey job))
     :name        (.getName job)}))