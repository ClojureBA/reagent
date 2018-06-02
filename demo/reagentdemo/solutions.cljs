(ns reagentdemo.solutions
  "Solutions for the tutorial examples. Your code goes here."
  (:require
   [reagent.core :as r]))

(defn simple-component []
  [:div "Hello!"])

(defn simple-parent []
  [:div "Fix me in reagentdemo.solutions/simple-parent"])

(defn say-hello []
  [:div "Fix me in reagentdemo.solutions/say-hello"])

(defn lister [items]
  [:ul
   (for [_ items]
     :fix-me)])

(defn lister-user []
  [:div
   "Fix me in reagentdemo.solutions/lister-user"
   [lister (range 1)]])

(defn counting-component []
  [:div "Fix me in reagentdemo.solutions/counting-component"])

(defn timer-component []
  [:div "Fix me in reagentdemo.solutions/timer-component"])

(defn shared-state []
  [:div "Fix me in reagentdemo.solutions/shared-state"])

(def bmi-data (r/atom {:height 180 :weight 80}))

(defn calc-bmi []
  (let [{:keys [height weight bmi] :as data} @bmi-data
        h (/ height 100)]
    (if (nil? bmi)
      (assoc data :bmi (/ weight (* h h)))
      (assoc data :weight (* bmi h h)))))

(defn slider [param value min max]
  [:input {:type "range" :value value :min min :max max
           :style {:width "100%"}
           :on-change (fn [e]
                        ;; fix me
                        )}])

(defn bmi-component []
  (let [{:keys [weight height bmi]} (calc-bmi)
        [color diagnose] (cond
                          (< bmi 18.5) ["orange" "underweight"]
                          (< bmi 25) ["inherit" "normal"]
                          (< bmi 30) ["orange" "overweight"]
                          :else ["red" "obese"])]
    [:div
     [:h3 "Fix me in reagentdemo.solutions/bmi-component"]]))
