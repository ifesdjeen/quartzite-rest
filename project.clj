(defproject quartzite-rest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure             "1.3.0"]
                 [noir                            "1.3.0-beta7"]
                 [com.novemberain/quartz-mongodb  "1.1.0-beta1"]
                 [clojurewerkz/quartzite          "1.0.0-rc5"]
                 [de.ubercode.clostache/clostache "1.3.0"]
                 [org.clojure/data.json           "0.1.2"]]
  :main quartzite-rest.core
  :resource-paths   ["src/resources"]
  :jvm-opts         ["-Dorg.quartz.properties=quartz.development.properties"]
  )

