
func maxProfit(prices []int) int {
	buy := math.MaxInt
	var profit int
	for i:= 0; i < len(prices); i++ {
		sell := prices[i]
		if i > 0 && prices[i-1] < buy {
			buy = prices[i-1]
		}
		if sell > buy && sell - buy > profit {
			profit = sell - buy
		}
	}
	return profit
}
