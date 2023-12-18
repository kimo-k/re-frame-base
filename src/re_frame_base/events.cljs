(ns re-frame-base.events
  (:require
   [re-frame.core :as re-frame]
   [re-frame-base.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
