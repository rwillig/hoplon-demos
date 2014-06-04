(ns tailrecursion.hoplon.app-pages._index_DOT_html (:require [tailrecursion.hoplon.reload :refer [reload-all]] [hoplon.jquery.daterangepicker :refer [daterange]] [hoplon.twitter.bootstrap :refer [checkbox container control-label form-group form-horizontal]] [tailrecursion.javelin :refer [alts! cell-map propagate! next-rank deref* lift cell input? cell-doseq* bf-seq destroy-cell! last-rank set-cell! set-formula! cell?]] [tailrecursion.hoplon :refer [script do! track article noscript command h4 h3 mark basefont h5 span input h2 th label h6 pre nav vector?* address sup h1 table font option datalist u safe-nth on! footer select q samp source summary li p td noframes node? iframe rel tr s *initfns* add-attributes! colgroup relx html dfn optgroup tbody text-val! ul hgroup sub strong data progress loop-tpl* acronym append-child replace-children! img details fieldset html-head em html-time rt when-dom video keygen div val-id dt ol link init form is-ie8 check-val! menu timeout del a parse-args area legend hr dir header param meter tfoot blockquote eventsource b dl figcaption caption route-cell style rel-event abbr ruby applet html-meta bdi embed rp figure on-append! canvas section object strike title button output audio initialized? add-children! dd bdo cite code kbd big seq?* frame rely col tt i ins thead unsplice isindex frameset spliced base $text by-id $comment br textarea wbr html-map small add-initfn! html-body aside html-var]]) (:require-macros [tailrecursion.javelin :refer [cell-doseq cell= defc defc= mx with-let prop-cell mx2 cell-let set-cell!= macroexpand-all]] [tailrecursion.hoplon :refer [with-init! body text defelem loop-tpl head with-timeout with-interval def-values flatten-expr]]))

(clojure.core/defn ^:export hoploninit [] (reload-all) (defc close? true) (defc dates nil) (defc tab-state 0) (cell= (print :dates dates)) (html :lang "en" (head (title "Hoplon • jQuery Date Range Picker")) (body (container (h1 "Hoplon & jQuery Date Range Picker") (hr) (form-horizontal (form-group :success dates (control-label :col {:sm 2} "Date Range") (div :col {:sm 10} (daterange :state dates :class "form-control" :placeholder "Enter a date range" :opts (cell= {:autoClose close?})))) (form-group (div :col {:sm 10} :offset {:sm 2} (checkbox (label (input :type "checkbox" :value close? :change (fn* [] (do (swap! close? not) false))) "auto-close enabled"))))) (hr) (p :css {:text-align "center"} (a :href "https://github.com/tailrecursion/hoplon-demos/blob/master/jquery-date-picker/src/index.cljs.hl" "source code"))))) (tailrecursion.hoplon/init))
