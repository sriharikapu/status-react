(ns status-im.ui.screens.extensions.subs
  (:require [re-frame.core :as re-frame]
            [status-im.utils.ethereum.core :as ethereum]))

(re-frame/reg-sub :settings/current-wnode
                  (fn [db _]
                    (:inbox/current-id db)))

(re-frame/reg-sub :settings/network-wnodes
                  :<- [:network]
                  :<- [:get :inbox/wnodes]
                  (fn [[network wnodes]]
                    (let [chain (ethereum/network->chain-keyword network)]
                      (chain wnodes))))
