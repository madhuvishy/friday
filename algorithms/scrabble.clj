
;;Define list A-Z
(def a-zlist (map #(str (char %)) (range 65 68)))

;;Define file location
(def dict-file "/Users/madhu/src/hackerschool/friday/algorithms/dictionary.txt")

;;Define dictionary
(def dictionary (clojure.string/split (slurp dict-file) #"\r\n"))


(defn char-appears?
  "Returns true if char-val appears in word else false"
  [char-val word]
  (>= (.indexOf word char-val) 0))

(defn words-with-char
  "Returns filtered set of words where given character appears"
  [char-val]
  (set (filter #(char-appears? char-val %) dictionary)))

(def single-char-indeces
  "Defines indices on A-Z for words that have the given character"
  (apply assoc {} (interleave a-zlist (map #(words-with-char %) a-zlist))))

(words-with-char "A")
single-char-indeces
(get single-char-indeces "B")
