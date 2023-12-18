(ns re-frame-base.views
  (:require
   [re-frame.core :as re-frame]
   [re-frame-base.subs :as subs]
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      "Hello from " @name]
     ]))
