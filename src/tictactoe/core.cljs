(ns tictactoe.core
    (:require 
              [reagent.core :as reagent :refer [atom]]
              [reagent.dom :as rd]))

(enable-console-print!)

(println "I changed some text")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state 
  (atom {:text "Welcome to tic tac toe"}))


(defn tictactoe []
  [:div
   [:h1 (:text @app-state)]
   [:svg 
    {:view-box "0 0 30 30"
     :width 500
     :height 500}
    [:circle {:r 30 :cx 30 :cy 30}]]])

(rd/render [tictactoe]
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  (swap! app-state assoc-in [:text] "Hi")
)
