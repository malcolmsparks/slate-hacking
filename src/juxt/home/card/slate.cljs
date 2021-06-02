;; Copyright © 2021, JUXT LTD.

(ns juxt.home.card.slate
  (:require
   ["react" :as react :refer [createElement useEffect useMemo useState]]
   ["react-dom" :refer [render]]
   ["slate" :as slate :refer [createEditor]]
   ["slate-react" :refer [Slate Editable withReact]]))

(defn App
  []
  (let [editor
        (useMemo #(withReact (createEditor)) #js [])

        [value setValue]
        (useState
         #js [#js {:type "paragraph"
                   :children
                   #js [#js {:text "A line of text in a paragraph."}]}])]

    (createElement Slate
                   #js {:editor editor
                        :value value
                        :onChange #(setValue %)}
                   (createElement Editable #js{}))))

(render
 (createElement App #js {})
 (js/document.getElementById "app"))
