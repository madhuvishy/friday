(defn partition
  "vec1 is assumed to be preprocessed and pivot is at index 0"
  ([vec1]
   (let [pivot (first vec1)]
     (loop [vec1 vec1
            i 1
            j 1]
     (cond
       (= j (count vec1))
         {:pivot (dec i) :part-vec (-> vec1 (assoc (dec i) pivot) (assoc 0 (nth vec1 (dec i))))}
       (> (nth vec1 j) pivot)
         (recur vec1 i (inc j))
       :else
         (recur (-> vec1 (assoc i (nth vec1 j)) (assoc j (nth vec1 i))) (inc i) (inc j)))))))

(defn quicksort
  [vec1]
  (if (<= (count vec1) 1)
    vec1
    (let [{:keys [part-vec pivot]} (partition vec1)]
      (concat
         (quicksort (subvec part-vec 0 pivot))
         [(nth part-vec pivot)]
         (quicksort (subvec part-vec (inc pivot)))))))
