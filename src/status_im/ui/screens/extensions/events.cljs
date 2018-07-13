(ns status-im.ui.screens.extensions.events
  (:require [re-frame.core :as re-frame]
            [status-im.extensions.registry :as registry]
            [status-im.utils.handlers :as handlers]
            status-im.ui.screens.extensions.add.events))

(re-frame/reg-fx
 ::toggle-activation
 (fn [[id m]]
   (if (registry/active? m)
     (registry/deactivate! id)
     (registry/activate! id))))

(handlers/register-handler-fx
 :extensions/toggle-activation
 (fn [_ [_ id m]]
   {::toggle-activation [id m]}))

(re-frame/reg-fx
 ::load
 (fn [url]
   (println "LOAD" url)
   (registry/load-from url)))

(handlers/register-handler-fx
 :extension/load
 (fn [_ [_ url]]
   {::load url}))
