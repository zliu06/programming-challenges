func isValidSudoku(board [][]byte) bool {
	for i := 0; i < 9; i++ {

		// iterate square
		r0 := (i / 3) * 3
		c0 := (i % 3) * 3
		mask := [9] int {}
		for j := r0; j < r0+3; j++ {
			for k := c0; k < c0 + 3; k++ {
				b := board[j][k]
				if b == '.' {
					continue
				}
				n := int(b - '1')
				if mask[n] == 0 {
					mask[n] = 1
				} else {
					return false
				}	
			}
		}

		// iterate row
		mask = [9] int {}
		for k := 0; k < 9; k++ {
			b := board[i][k]
			if b == '.' {
				continue
			}
			n := int(b - '1')
			if mask[n] == 0 {
				mask[n] = 1
			} else {
				return false
			}	
		}

		// iterate col
		mask = [9] int {}
		for j := 0; j < 9; j++ {
			b := board[j][i]
			if b == '.' {
				continue
			}

			n := int(b - '1')
			if mask[n] == 0 {
				mask[n] = 1
			} else {
				return false
			}	
		}
	}
	return true
}
