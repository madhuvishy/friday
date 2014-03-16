;;Merge Sort in Clojure

(defn merge-sorted 
  "Takes two sorted array and recursively merges them"
  ([vec1 vec2] (merge-sorted vec1 vec2 [] 0 0 0))

  ([vec1 vec2 merged vec1-iter vec2-iter merged-iter ]
   (let [iter-count (+ (count vec1) (count vec2))]
        (cond
          (= (count vec1) vec1-iter)
            (vec (flatten (conj merged (subvec vec2 vec2-iter))))
          (= (count vec2) vec2-iter)
            (vec (flatten (conj merged (subvec vec1 vec1-iter))))
          (>= merged-iter iter-count)
            merged
          (< (nth vec1 vec1-iter) (nth vec2 vec2-iter))
              (recur vec1 vec2 (assoc merged merged-iter (nth vec1 vec1-iter)) (inc vec1-iter) vec2-iter (inc merged-iter)) 
          :else
              (recur vec1 vec2 (assoc merged merged-iter (nth vec2 vec2-iter)) vec1-iter (inc vec2-iter) (inc merged-iter))))))

              
                
(defn merge-sort
  "Implements the divide and conquer merge sort algorithm"
 [input]
  (if (< (count input) 2)
      input
      (merge-sorted   
        (merge-sort (subvec input 0 (/ (count input) 2))) 
        (merge-sort (subvec input (/ (count input) 2))))))
          



