/*
 * The next step in our DQL journey will be viewing Aggregate and Scalar functions
 * 
 * Aggregate Functions
 * 	These are functions that combine or aggregate multiple rows/records into one single result
 * 	Think of various Math operations (MAX, MIN, AVG, COUNT, SUM)
 * Scalar Functions
 * 	The functions perform some sort of transformation on each row passed to them
 * 	Think of various transformation functions (LOWER, UPPER, FLOOR, CEIL, ROUND, ABS)
 * 
 * Using these functions we can query the data in more complex ways and perform various operations on them 
*/

CREATE TABLE stocks(
	stock_record_id serial PRIMARY KEY,
	stock_ticker varchar(10),
	date varchar(12),
	"close" numeric(10,2),
	"open" NUMERIC(10,2),
	sector varchar(25)
);


-- This is a table to represent Stock information include a date, stock and open/close prices
-- Let's add in some data

insert into stocks (stock_ticker, date, close, open, sector) values ('EEA', '4/27/2024', 48.86, 82.07, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('WRLD', '4/27/2024', 8.58, 45.96, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('TCBIW', '1/22/2025', 75.14, 63.84, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('FOANC', '2/9/2025', 59.68, 90.9, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('ALG', '11/18/2024', 82.41, 9.05, 'Capital Goods');
insert into stocks (stock_ticker, date, close, open, sector) values ('ATHN', '5/26/2024', 74.96, 64.09, 'Miscellaneous');
insert into stocks (stock_ticker, date, close, open, sector) values ('PB', '1/29/2025', 58.06, 84.21, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('GDL', '12/2/2024', 88.19, 10.25, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('CCE', '9/8/2024', 11.23, 6.72, 'Consumer Non-Durables');
insert into stocks (stock_ticker, date, close, open, sector) values ('AHGP', '5/26/2024', 99.99, 77.76, 'Energy');
insert into stocks (stock_ticker, date, close, open, sector) values ('TPB', '11/21/2024', 15.32, 13.49, 'Consumer Non-Durables');
insert into stocks (stock_ticker, date, close, open, sector) values ('FB', '9/5/2024', 12.07, 63.79, 'Technology');
insert into stocks (stock_ticker, date, close, open, sector) values ('JJSF', '11/3/2024', 66.32, 46.92, 'Consumer Non-Durables');
insert into stocks (stock_ticker, date, close, open, sector) values ('TGP^A', '4/22/2024', 60.92, 59.07, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('SPB           ', '2/13/2025', 43.14, 36.05, 'Miscellaneous');
insert into stocks (stock_ticker, date, close, open, sector) values ('NGLS^A', '4/17/2024', 11.47, 70.45, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('LCM', '4/22/2024', 72.18, 72.24, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('HK.WS', '11/17/2024', 77.55, 66.34, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('BFK', '12/18/2024', 54.09, 36.13, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('TPIC', '1/25/2025', 96.5, 91.56, 'Energy');
insert into stocks (stock_ticker, date, close, open, sector) values ('LMRKP', '4/27/2024', 35.71, 65.21, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('RP', '8/10/2024', 1.05, 59.05, 'Technology');
insert into stocks (stock_ticker, date, close, open, sector) values ('CBL', '6/27/2024', 77.29, 42.93, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('OTEX', '8/3/2024', 65.87, 61.49, 'Technology');
insert into stocks (stock_ticker, date, close, open, sector) values ('RKDA', '9/7/2024', 93.87, 3.41, 'Basic Industries');
insert into stocks (stock_ticker, date, close, open, sector) values ('HD', '10/4/2024', 48.44, 48.31, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('HOME', '5/2/2024', 35.86, 85.05, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('TI', '6/14/2024', 57.09, 30.39, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('STZ.B', '5/2/2024', 73.61, 41.9, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('RAS', '3/29/2024', 49.21, 36.1, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('BMLA', '11/9/2024', 3.72, 12.26, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('SGOC', '2/4/2025', 20.39, 12.51, 'Technology');
insert into stocks (stock_ticker, date, close, open, sector) values ('GBAB', '1/7/2025', 65.09, 60.98, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('SMG', '11/16/2024', 98.35, 12.95, 'Basic Industries');
insert into stocks (stock_ticker, date, close, open, sector) values ('XCO', '5/6/2024', 11.58, 51.47, 'Energy');
insert into stocks (stock_ticker, date, close, open, sector) values ('UBSI', '10/5/2024', 66.72, 38.17, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('GG', '8/31/2024', 22.75, 58.67, 'Basic Industries');
insert into stocks (stock_ticker, date, close, open, sector) values ('TPC', '5/11/2024', 31.63, 68.94, 'Basic Industries');
insert into stocks (stock_ticker, date, close, open, sector) values ('AFMD', '5/13/2024', 22.39, 3.59, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('ALR', '8/22/2024', 4.04, 53.39, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('CLI', '2/20/2025', 10.36, 2.15, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('STRA', '6/14/2024', 29.05, 4.63, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('PLT', '1/27/2025', 33.5, 14.88, 'Public Utilities');
insert into stocks (stock_ticker, date, close, open, sector) values ('GRP.U', '4/2/2024', 83.26, 72.8, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('FNV', '6/24/2024', 9.23, 46.84, 'Basic Industries');
insert into stocks (stock_ticker, date, close, open, sector) values ('RRD', '8/27/2024', 97.45, 75.21, 'Miscellaneous');
insert into stocks (stock_ticker, date, close, open, sector) values ('WLTW', '10/15/2024', 11.46, 69.75, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('TPVZ', '6/24/2024', 97.69, 90.33, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('RVLT', '12/18/2024', 7.31, 27.57, 'Consumer Durables');
insert into stocks (stock_ticker, date, close, open, sector) values ('KRMA', '3/6/2025', 63.28, 54.27, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('CADE', '5/19/2024', 86.9, 84.58, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('SPR', '8/26/2024', 65.7, 37.49, 'Capital Goods');
insert into stocks (stock_ticker, date, close, open, sector) values ('INN^C', '11/22/2024', 5.16, 91.92, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('NVRO', '7/30/2024', 77.93, 72.05, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('WINA', '12/22/2024', 10.8, 56.19, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('HTA', '12/13/2024', 81.76, 43.21, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('MCO', '6/12/2024', 62.89, 14.68, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('SPTN', '12/22/2024', 84.47, 76.52, 'Consumer Non-Durables');
insert into stocks (stock_ticker, date, close, open, sector) values ('TEVA', '7/5/2024', 92.16, 47.82, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('TIME', '12/10/2024', 66.34, 19.16, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('BAC', '5/4/2024', 1.63, 15.03, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('TRPX', '3/17/2024', 87.55, 9.64, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('GBT', '12/28/2024', 56.19, 19.02, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('NCMI', '3/3/2025', 62.73, 50.79, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('LUV', '10/1/2024', 71.27, 34.24, 'Transportation');
insert into stocks (stock_ticker, date, close, open, sector) values ('NGVC', '7/19/2024', 30.5, 60.92, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('CE', '9/26/2024', 92.19, 91.72, 'Basic Industries');
insert into stocks (stock_ticker, date, close, open, sector) values ('JRO', '10/3/2024', 32.94, 83.13, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('MOFG', '12/17/2024', 8.42, 94.02, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('LTRPA', '12/5/2024', 16.11, 55.9, 'Technology');
insert into stocks (stock_ticker, date, close, open, sector) values ('DEI', '1/20/2025', 46.15, 60.45, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('USPH', '5/5/2024', 36.4, 2.48, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('BTE', '4/11/2024', 99.32, 22.88, 'Energy');
insert into stocks (stock_ticker, date, close, open, sector) values ('BTU', '12/8/2024', 26.6, 52.9, 'Energy');
insert into stocks (stock_ticker, date, close, open, sector) values ('FLWS', '11/13/2024', 64.76, 70.73, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('TYL', '1/25/2025', 36.06, 53.07, 'Technology');
insert into stocks (stock_ticker, date, close, open, sector) values ('BKHU', '8/18/2024', 3.37, 57.67, 'Public Utilities');
insert into stocks (stock_ticker, date, close, open, sector) values ('XNCR', '10/13/2024', 7.13, 48.3, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('PLYAW', '4/7/2024', 58.11, 73.99, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('AGRX', '9/21/2024', 85.48, 34.06, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('OPXAW', '9/11/2024', 80.6, 26.56, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('NSM', '11/25/2024', 53.38, 97.83, 'Finance');
insert into stocks (stock_ticker, date, close, open, sector) values ('CTLT', '7/6/2024', 6.84, 34.96, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('TYHT', '6/7/2024', 61.12, 83.47, 'Consumer Non-Durables');
insert into stocks (stock_ticker, date, close, open, sector) values ('CLD', '7/14/2024', 44.66, 73.65, 'Energy');
insert into stocks (stock_ticker, date, close, open, sector) values ('CJJD', '8/31/2024', 94.83, 64.47, 'Consumer Durables');
insert into stocks (stock_ticker, date, close, open, sector) values ('NWE', '3/9/2025', 58.2, 19.84, 'Public Utilities');
insert into stocks (stock_ticker, date, close, open, sector) values ('EACQ', '2/15/2025', 81.84, 53.97, 'Capital Goods');
insert into stocks (stock_ticker, date, close, open, sector) values ('NEOT', '3/17/2024', 71.88, 54.03, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('CCL', '6/23/2024', 36.1, 51.88, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('HTBX', '9/18/2024', 43.25, 70.36, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('AMN', '4/30/2024', 55.76, 68.65, 'Technology');
insert into stocks (stock_ticker, date, close, open, sector) values ('AWR', '11/1/2024', 44.81, 65.73, 'Public Utilities');
insert into stocks (stock_ticker, date, close, open, sector) values ('AMT', '7/28/2024', 67.31, 15.85, 'Consumer Services');
insert into stocks (stock_ticker, date, close, open, sector) values ('FFA', '8/26/2024', 77.9, 26.89, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('BBK', '7/18/2024', 68.16, 26.6, 'n/a');
insert into stocks (stock_ticker, date, close, open, sector) values ('VJET', '1/31/2025', 94.83, 81.66, 'Capital Goods');
insert into stocks (stock_ticker, date, close, open, sector) values ('PAHC', '7/29/2024', 95.55, 99.8, 'Health Care');
insert into stocks (stock_ticker, date, close, open, sector) values ('ISSC', '2/25/2025', 98.66, 58.73, 'Technology');
insert into stocks (stock_ticker, date, close, open, sector) values ('HQY', '4/8/2024', 23.72, 45.67, 'Miscellaneous');



-- Before we got all of the information from basic select statements
SELECT * FROM STOCKS;

-- What if we want to perform various math operations for data analysis;
-- What was the MAX opening price for a stock?
SELECT MAX(open) FROM stocks;

SELECT MIN(open) FROM Stocks;

SELECT AVG(open) FROM stocks;
-- Aggregate functions will group all of the data and return 1 results for the batchALTER 
-- For those curious you can also perform general math
-- Get the profits for each stock for the day
SELECT stock_ticker, "date", "close" - "open" FROM stocks;

-- The column with the math operation doesn't have a name, let's give it one with an ALIAS
-- ALIASing can be used on columns and tables to make it easier to get info from them or to name
-- things in the result set
SELECT stock_ticker, "date", "close" - "open" AS "DAILY_PROFIT" FROM stocks ORDER BY "DAILY_PROFIT";


-- Let's say I want to find the number of records per stock sector
-- As said before the Aggregate functions combine all the records for a GROUP
-- Using the GROUP BY clause we can create some groups here
SELECT COUNT(*) FROM stocks GROUP BY sector;

-- So lets group and add the sector name
SELECT sector, Count(*) FROM STOCKS GROUP BY sector;
-- Grouping is important for any sort of data analysis

-- What if I want to filter these again
-- Show me all sectors that have a count of records greater than 10
-- HAVING clause allows us to filter like WHERE but it occurs AFTER aggregation
SELECT sector, Count(*) FROM STOCKS GROUP BY sector HAVING COUNT(*) > 10;

-- TODO Come back when talking about subqueries

-- SCALAR FUNCTIONS
-- These are used to transform data into different output values
-- The amount of rows you pass to a scalar function is the amount you return
-- LOWER, UPPER
-- Floor, CEILING, ROUND, ABS

SELECT name FROM employees ORDER BY name;

SELECT LOWER(name) FROM employees ORDER BY name;

SELECT UPPER(name) FROM employees ORDER BY name;

SELECT FLOOR(OPEN)  FROM stocks ORDER BY open;
SELECT CEIL(OPEN)  FROM stocks ORDER BY open;
SELECT ROUND(OPEN,1) FROM stocks ORDER BY OPEN;

-- ABS is absolute value which is the distance from 0, basically the positive version of whatever number
SELECT ABS(CLOSE - OPEN) AS "DAILY_PRICE_CHANGE" FROM stocks ORDER BY "DAILY_PRICE_CHANGE";









