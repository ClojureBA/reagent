(defproject reagent-tutorial "0.0.1"
  :url "http://github.com/ClojureBA/reagent-tutorial"
  :license {:name "MIT"}
  :description "A reagent tutorial"

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [reagent "0.8.1"]
                 [cljsjs/react "16.3.2-0"]
                 [cljsjs/react-dom "16.3.2-0"]
                 [cljsjs/react-dom-server "16.3.2-0"]
                 [cljsjs/create-react-class "15.6.3-0"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.16"]]

  :source-paths ["demo"]

  :profiles {:dev {:dependencies [[org.clojure/clojurescript "1.10.238"]
                                  [figwheel "0.5.16"]
                                  [com.google.javascript/closure-compiler-unshaded "v20180319"]
                                  [cljsjs/prop-types "15.6.1-0"]]
                   :source-paths ["demo" "examples/todomvc/src" "examples/simple/src" "examples/geometry/src"]
                   :resource-paths ["site" "target/cljsbuild/client"]}}

  :clean-targets ^{:protect false} [:target-path :compile-path "out"]

  :figwheel {:http-server-root "public" ;; assumes "resources"
             :css-dirs ["site/public/css"]
             :repl false}

  :cljsbuild
  {:builds
   [{:id "client"
     :source-paths ["demo"]
     :watch-paths ["src" "demo" "test"]
     :figwheel true
     :compiler {:parallel-build true
                :optimizations :none
                :main "reagentdemo.dev"
                :output-dir "target/cljsbuild/client/public/js/out"
                :output-to "target/cljsbuild/client/public/js/main.js"
                :asset-path "js/out"
                :npm-deps false}}]})
