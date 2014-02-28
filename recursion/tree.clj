(defrecord TreeNode [value l r])

(defn insert [t v]
  (cond 
    (nil? t)
      (TreeNode. v nil nil)
    (< v (:value t)) 
      (TreeNode. (:value t) (insert (:l t) v) (:r t))
    :else
      (TreeNode. (:value t) (:l t) (insert (:r t) v))))

(defn print-tree [t]
  (when t 
    (concat (print-tree (:l t)) [(:value t)] (print-tree (:r t)))))

(defn sum-tree [t]
  (if (nil? t)
    0
    (+ (:value t) (sum-tree (:l t)) (sum-tree (:r t)))))


(def sample-tree (reduce insert nil [3 5 2 4 6]))

