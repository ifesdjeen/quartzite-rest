(ns clojurewerkz.quartzite-rest.views.common
  (:require [stencil.core :as st]))

(def ^{:const true}
  default-layout "templates/layout/application")

(defn in-layout
  ([^String body]
     (in-layout default-layout body {}))
  ([^String body options]
     (st/render-file default-layout body options))
  ([^String layout ^String body options]
     (st/render-file layout (merge  options {:content body}))))
