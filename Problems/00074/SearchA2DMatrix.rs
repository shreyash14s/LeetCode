impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        let mut low = 0;
        let m = matrix.len();
        if m == 0 { return false; }
        let n = matrix[0].len();
        let mut high = m * n;
        if high == 0 { return false; }
        while low < high {
            let mid = low + (high - low) / 2;
            let v = matrix[mid / n][mid % n];
            if v == target {
                return true;
            } else if v < target {
                low = mid+1;
            } else {
                high = mid;
            }
            // println!("{} {} {} {}", v, mid, low, high);
        }
        if low < m * n {
            let v = matrix[low / n][low % n];
            return v == target;
        }
        false
    }
}
