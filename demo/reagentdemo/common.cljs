(ns reagentdemo.common
  (:require [reagent.core :as r]
            [reagent.debug :refer-macros [dbg println]]))

(defn demo-component [{:keys [expected comp src hint complete no-heading]}]
  (r/with-let [showing-solution (r/atom false)
               showing-hint (r/atom false)]
    [:div
     (when expected
       [:div.demo-example.clearfix
        (when-not no-heading
          [:h3.demo-heading "Expected output "])
        (if-not complete
          [:div.simple-demo [expected]]
          [expected])
        (when comp
          [:div
           (when-not no-heading
             [:h3.demo-heading "Actual output "])
           (if-not complete
             [:div.simple-demo [comp]]
             [comp])])
        (when hint
          [:div
           [:a.demo-example-hide {:on-click (fn [e]
                                              (.preventDefault e)
                                              (swap! showing-hint not)
                                              nil)}
            (if @showing-hint "hide" "show")]
           [:h3.demo-heading "Hint"]
           (when @showing-hint
             hint)])])

     (if src
       [:div.demo-source.clearfix
        [:a.demo-example-hide {:on-click (fn [e]
                                           (.preventDefault e)
                                           (swap! showing-solution not)
                                           nil)}
         (if @showing-solution "hide" "show")]
        (when-not no-heading
          [:h3.demo-heading "Solution"])
        (when @showing-solution src)]
       [:div.clearfix])]))
