import csv

with open('salesoutput.csv') as f:
    reader = csv.reader(f)
    with open('xyz.csv', 'w', newline="") as g:
        writer = csv.writer(g)
        for row in reader:
            if row[1] == '':
             new_row = str(row[0])+str(row[1])     #This will concatenate Address 1 & 2 Columns
             writer.writerow([new_row])
            else:
                new_row = str(row[0])+':'+str(row[1])
                new_row1 = new_row.replace(',','')  #This will concatenate Address 1 & 2 Columns with a ':' and removes ','
                print(new_row1)
                writer.writerow([new_row1])







