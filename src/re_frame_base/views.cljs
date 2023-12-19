(ns re-frame-base.views
  (:require
   [re-frame.core :as re-frame]
   [re-frame-base.subs :as subs]
   [reagent.core :as r]))

(defn good []
  (r/with-let [a (r/atom "good")]
    [:div "I'm " @a "!"]))

(defn bad []
  (let [a (r/atom "bad")]
    (fn []
      [:div "I'm " @a "!"])))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      "Hello from " @name]
     [good]
     [bad]]))
