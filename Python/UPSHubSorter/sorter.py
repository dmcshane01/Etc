#Hub number in 3rd index of csv
#date at 2nd index
import csv

f = open('temp.csv') # Change File Name
csv_f = csv.reader(f) # Open Reader

hubs = []
found = False

"""
First iterate through and create a list of all unique hub #'s
"""
for row in csv_f:	#iterate through csv
	for i in range(len(hubs)):	# iterate through  hubs[]
		if row[2] == hubs[i]: # if the hub from csv is already in hubs
				found = True; # set found to true
	if found == False:
		hubs.append(row[2])
	else:
		found = False	# if found in list need to reset found to false



"""
Create sublists for each hub and store each sublist into  a masterlist
"""	
hubList = list()
for i in range(len(hubs)):
	# Reopen CSV at start of file
	f = open('temp.csv') # Change File Name
	csv_f = csv.reader(f) # Open Reader	
	tempList = list() # each loop tempList references a new list
	for row in csv_f:
		if hubs[i] == row[2]: # Loop through csv, if hub is same as outer loop add to sublist
			tempList.append(row)
	
	hubList.append(tempList[:]) #insert shallow copy sublist into master
	del tempList[:] # delete tempList AND its reference
"""
HUBLIST[HUB][RECORDINHUB][TUPLEOFHUB]
IE: Hublist[0][0][0] =  first hub/first record of hub/first tuple from csv
"""



finalList = list()
while(len(hubList) > 0):
	#grab first record for comparison
	month = int(hubList[0][0][1][5:7])
	day = int(hubList[0][0][1][8:])
	indexOut = 0
	for i in range(len(hubList)):
		print(i)
		for j in range(len(hubList[i])):
			tempMonth = int(hubList[i][j][1][5:7]) #grabs first two numbers in date (month)
			tempDay = int(hubList[i][j][1][8:])
			
			
			if tempMonth < month:
				indexOut = i
				month = tempMonth
				day = tempDay
			elif tempMonth == month and tempDay < day:
				indexOut = i
				month = tempMonth
				day = tempDay
			
		
	finalList.append(hubList.pop(indexOut))

i = 0
with open('output.csv', 'w') as w:
	writer = csv.writer(w)
	writer.writerows(finalList)
	print(i)
	i = i+1
	
"""
for row in csv_f:
	tempList = []
	print(tempList)
	for i in range(len(hubs)):
		if(hubs[i] == row[2]):
			tempList.append(row)
			print(tempList)
			
			
	hubList.append(tempList)
	"""