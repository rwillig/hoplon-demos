(ns tailrecursion.hoplon.app-pages._index_DOT_html (:require [flickr :as flickr] [tailrecursion.javelin :refer [alts! cell-map propagate! next-rank deref* lift cell input? cell-doseq* bf-seq destroy-cell! last-rank set-cell! set-formula! cell?]] [tailrecursion.hoplon :refer [script do! track article noscript command h4 h3 mark basefont h5 span input h2 th label h6 pre nav vector?* address sup h1 table font option datalist u safe-nth on! footer select q samp source summary li p td noframes node? iframe rel tr s *initfns* add-attributes! colgroup relx html dfn optgroup tbody text-val! ul hgroup sub strong data progress loop-tpl* acronym append-child replace-children! img details fieldset html-head em html-time rt when-dom video keygen div val-id dt ol link init form is-ie8 check-val! menu timeout del a parse-args area legend hr dir header param meter tfoot blockquote eventsource b dl figcaption caption route-cell style rel-event abbr ruby applet html-meta bdi embed rp figure on-append! canvas section object strike title button output audio initialized? add-children! dd bdo cite code kbd big seq?* frame rely col tt i ins thead unsplice isindex frameset center spliced base $text by-id $comment br textarea wbr html-map small add-initfn! html-body aside html-var]]) (:require-macros [tailrecursion.javelin :refer [cell-doseq cell= defc defc= mx with-let prop-cell mx2 cell-let set-cell!= macroexpand-all]] [tailrecursion.hoplon :refer [with-init! body text defelem loop-tpl head with-timeout with-interval def-values flatten-expr]]))

(clojure.core/defn ^:export hoploninit [] (def queries "Flickr search API queries, will be chosen randomly and submitted to obtain\n  interesting images which will be displayed in the scrolling div." ["wtf" "meme" "happy" "jewels" "farming" "flamenco" "omg" "blue" "green" "castles" "goodbye" "spaghetti" "sad" "love" "space" "haircut" "amazing" "hilarious" "red" "hate" "tango" "tractor" "awesome" "submarines" "nyc" "nasa" "ships" "hunting" "alabama" "motorcycles" "hey" "fool" "funny" "sailing" "bananas" "underground"]) (defc state "The current list of image urls." []) (defc error "The last XHR error." nil) (defc loading "A vector of in-progress async calls." []) (defc= loading? "True if there are in-progress async calls." (seq loading)) (defn fetch-images! "Fetch some images from the Flickr API and append them to the state cell." [] (when-not (clojure.core/deref loading?) (reset! error nil) (swap! loading conj :loading) (let [q (rand-nth queries)] (flickr/image-search q (fn* [p1__6558#] (do (swap! loading pop) (swap! state into p1__6558#))) (fn* [] (do (swap! loading pop) (reset! error :error))))))) (defmethod on! :scroll-end [elem _ callback] (on! elem :scroll (fn* [p1__6559#] (let [el (.-target p1__6559#) ch (.-clientHeight el) sh (.-scrollHeight el) st (.-scrollTop el) at-end? (= ch (- sh st))] (when at-end? (callback p1__6559#)))))) (with-init! (fetch-images!)) (html :lang "en" (head (meta :charset "utf-8") (title "Hoplon • Infinite Scroll Demo") (link :rel "stylesheet" :type "text/css" :href "css/main.css")) (body (div :id "container" (h1 "Infinite Scrolling") (p "Scroll down to see more images...") (div :id "wrapper" (div :id "loading" :toggle loading? "LOADING IMAGES...") (div :id "error" :toggle error "Error fetching images: " (a :href "javascript:void(0)" :click fetch-images! "try again")) (div :id "scroll" :scroll-end fetch-images! (loop-tpl :bindings [{:keys [link image]} state] (div (a :href link :target "_blank" (img :src image))))) (p (a :href "https://github.com/tailrecursion/hoplon-demos/tree/master/infinite-scroll/src/index.cljs.hl" "Source Code")))))) (tailrecursion.hoplon/init))
