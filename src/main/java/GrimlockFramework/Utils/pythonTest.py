# coding: utf-8
import os
import sys
# str(sys.argv[0])


pythonIndentationSpace = "	";

path = str(sys.argv[1])
targetDirectory = str(sys.argv[2])
package_name = str(sys.argv[3])

files = []
# r=root, d=directories, f = files
for r, d, f in os.walk(path):
    for file in f:
        if '.png' in file:
            files.append(os.path.join(r, file))

while files:

	file = open(targetDirectory,"w")
	file.write("///////////////////////////     This Class auto created by python script - pythonTest.py     ///////////////////////////"+ '\n')
	file.write("package "+package_name+";"+ '\n')
	file.write("public final class ImageConstants {"+ '\n')
	for f in files:

		fullFilename = os.path.relpath(f,path).upper()
		filenameWithoutExt = os.path.splitext(fullFilename)[0]
		finalVariableName = filenameWithoutExt.replace("/","_")
		finalVariableName = finalVariableName.replace("-","_")
		finalVariableName = finalVariableName.replace(".","_")

		file.write(pythonIndentationSpace + "public static final String " + finalVariableName + " = "+"\"" +path+"/"+ os.path.relpath(f,path) + "\"" + ';' '\n')

		print(finalVariableName)
		#print(E + os.path.splitext(os.path.relpath(f,path).replace("/","_"))[0])
	break
print (targetDirectory)
file.write("}")
file.close()