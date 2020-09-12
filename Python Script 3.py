import csv
# In this script we are dropping ORDER_DATE column because we can retrieve the same from MONTH_ID, QTR_ID, YEAR_ID.
with open('OrderTable.csv') as f:
    reader = csv.reader(f)
    with open('FinalOrderTable.csv', 'w', newline="") as g:
        writer = csv.writer(g)
        for row in reader:
         writer.writerow([row[0], row[1], row[2], row[3], row[5], row[6]])






