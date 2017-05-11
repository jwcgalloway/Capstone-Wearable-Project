import csv

def formatString(row):
    list  = []
    list.append(row[0])
    list.append(str(round(float(row[1]),4)))
    list.append(str(round(float(row[2]),4)))
    list.append(str(round(float(row[3]),4)))
    return list
    
with open('rawdata2.csv','rb') as csvfile,open('outputFile2.csv','wb') as output :
    reader = csv.reader(csvfile)
    writer = csv.writer(output)
    movingX = [0, 0, 0, 0, 0]
    movingY = [0, 0, 0, 0, 0]
    movingZ = [0, 0, 0, 0, 0]
    for row in reader:  #print row[0]
        movingX.pop(0)
        movingX.append(int(row[1]))
        xAvg = reduce(sum(movingX)/len(movingX))
        
        movingY.pop(0)
        movingY.append(int(row[2]))
        yAvg = reduce(sum(movingY)/len(movingY))
        
        movingZ.pop(0)
        movingZ.append(int(row[3]))
        zAvg = reduce(sum(movingZ)/len(movingZ))
        
        newRow = [row[0], xAvg, yAvg, zAvg]
        writer.writerow(formatString(newRow))