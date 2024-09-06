# Business Intelligence per i Servizi Finanziari

## Project Overview

This project explores the application of Business Intelligence in the financial services sector by analyzing the performance of selected stocks from different industries. The analysis includes descriptive statistics, correlation analysis, backtesting of trading strategies, and the calculation of expected returns using the Capital Asset Pricing Model (CAPM). The goal is to provide insights into the behavior of different assets and develop data-driven strategies for financial decision-making.

## Data Description

The analysis focuses on six major stocks from three distinct sectors:

1. **Healthcare**: Johnson & Johnson (JNJ) and Pfizer Inc. (PFE)
2. **Technology**: Apple Inc. (AAPL) and Microsoft Corporation (MSFT)
3. **Financial Services**: JPMorgan Chase & Co. (JPM) and American Express Company (AXP)

These stocks were selected to represent a diverse set of market segments, allowing for a comprehensive analysis of different industry behaviors.

### Data Sources and Methodology

- Data was sourced using the `pandas_datareader` library to fetch daily adjusted close prices and other relevant financial metrics.
- The analysis involved merging various datasets, calculating returns, and performing statistical tests.

## Key Analyses

### 1. Descriptive Statistics
- **Simple and Compound Returns**: Calculation of daily, monthly, and annual returns for each stock, illustrating their performance over time.
- **Distribution Analysis**: Graphical representation of the return distributions to identify patterns such as skewness, kurtosis, and the presence of outliers.
- **Univariate Statistics**: Summary of mean, standard deviation, and other key metrics to understand the volatility and central tendency of each stock.

### 2. Correlation and Covariance
- **Correlation Matrix**: Shows the degree of correlation between stocks within the same sector and across different sectors.
- **Covariance Matrix**: Highlights how stocks move in relation to one another, helping assess risk diversification opportunities.

### 3. Trading Strategies and Backtesting
- **Moving Average Strategy**: Implementation of Exponential Weighted Moving Averages (EWM) as a trading strategy compared against a simple Buy and Hold approach.
- **Backtesting Results**: Analysis of the performance of the trading strategies, demonstrating instances where EWM outperforms Buy and Hold.

### 4. CAPM and Beta Calculation
- **Beta Calculation**: Assessment of each stock’s risk relative to the market, indicating how sensitive each stock is to broader market movements.
- **Expected Returns**: Calculation of expected returns using CAPM, providing insights into the anticipated performance of each stock under current market conditions.

## Conclusion

The analysis provided valuable insights into the behavior of selected stocks across different market segments. Key findings include:

- Healthcare stocks showed resilience during the COVID-19 pandemic, with Pfizer benefitting significantly from vaccine distribution.
- Technology stocks, particularly Apple and Microsoft, demonstrated strong performance, reflecting their role as market leaders.
- Financial services stocks displayed mixed results, influenced by broader economic conditions and specific market challenges.

The project demonstrated the effectiveness of using statistical analysis and backtesting to develop informed trading strategies. By leveraging data-driven approaches, investors can better understand market dynamics and make more strategic financial decisions.

---

This README file outlines the purpose, data, analyses, and key findings of the Business Intelligence project for financial services. It highlights the importance of data analytics in developing effective trading strategies and understanding market behavior.
