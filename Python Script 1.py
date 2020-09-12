import csv

with open('sales_data_sample.csv') as f:
    reader = csv.reader(f)
    with open('salesoutput.csv', 'w', newline="") as g:
        writer = csv.writer(g)
        for row in reader:
            if row[5] == '':
             new_row = str(row[4])+str(row[5])          #This will concatenate Address 1 & 2 Columns
             writer.writerow([row[0],row[1],row[2],row[3],new_row])
            else:
                new_row = str(row[4])+':'+str(row[5])   #This will concatenate Address 1 & 2 Columns with a ','
                writer.writerow([row[0],row[1],row[2],row[3],new_row])







                