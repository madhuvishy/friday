(defn last-index 
  ([n numvec] (last-index n numvec -1 0))
  ([n numvec index pos] 
   (cond (>= pos (count numvec) )
            index
         (= n (nth numvec pos))
            (last-index n numvec pos (+ pos 1))
         :else
            (last-index n numvec index (+ pos 1))
         )))
