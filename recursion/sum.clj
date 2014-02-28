(defn sum 
  ([numvec] (sum numvec 0))
  ([numvec total]
   (if (= (count numvec) 0)
     total
     (sum (subvec numvec 1) (+ total (first numvec))))))
  
