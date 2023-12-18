(ns re-frame-base.core
  (:require
   [reagent.dom.client :as rdc]
   [re-frame.core :as re-frame]
   [re-frame-base.events :as events]
   [re-frame-base.views :as views]
   [re-frame-base.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defonce root (rdc/create-root (js/document.getElementById "app")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (rdc/render root [views/main-panel]))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
