(defn step-count 
  [num-steps]
  (cond 
    (= num-steps 0)
      1
    (< num-steps 0)
      0
    :else
      (+ (step-count (- num-steps 1)) (step-count (- num-steps 2)) (step-count (- num-steps 3))))
) 


