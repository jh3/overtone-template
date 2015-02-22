(ns leiningen.new.overtone
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "overtone"))

(defn overtone
  "overtone project template"
  [name]
  (let [render (renderer "overtone")
        data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' overtone project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["doc/intro.md" (render "intro.md" data)]
             [".gitignore" (render ".gitignore" data)]
             ["src/{{sanitized}}.clj" (render "core.clj" data)]
             ["test/{{sanitized}}_test.clj" (render "test.clj" data)]
             "resources")))
