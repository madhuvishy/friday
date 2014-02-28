(defn largest
  ([numvec] (largest numvec 0))
  ([numvec max-val] 
   (cond (= (count numvec) 0)
            max-val
         (> (first numvec) max-val)
            (largest (subvec numvec 1) (first numvec))
         :else
            (largest (subvec numvec 1) max-val)
         )))
