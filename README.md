# CS3398-Rio-Bobcats


Sifaben Vahora
Ayisha Sowkathali
Jon Pugh
Zach Sotak
Aryam Abebe

Steganography is the process of concealing data within a file so that the concealed data is not easily identifiable. 
Unlike encryption, steganography does not make it immediately apparent to a third party that data has been masked. 
This method of hiding data allows secure data transmission through public channels and is particularly useful to 
citizens in countries that have strict data encryption laws.

Our project will build on https://github.com/Jpadilla1/Steganography, a repository that uses steganography to hide 
text or images inside of images. We will be creating a user interface for this project that allows the user to hide 
text in an image and, if time allows, team members will explore adding additional functionality to the program.

What has been done:

● We have designed and implemented an interface design for the Steganography program that has 4 of the 6 options fully functioning.

● Created a “Browse” button that utilizes JFileChooser to allow user to browse files for a source image and allows the user to set the filename/path to the destination image.
 
● Created an image preview that shows the user the source image they’ve selected to mask data inside of.

● Created pop-ups for the completion of work.

● Convert Image Functional on Windows.


Additional features to be implemented (tentative):

● Get the last 2 functions working on the GUI.

● Add functionality to Convert Image for OS and LINUX.

● Make interface visually appealing and intuitively easy to use.

● Finish error handling.

● Clean up code and add comments to functions.

● Image masking - The user will be able to select an image to hide inside of the source image.

● Data encryption - The masked data will be encrypted before it is merged with the image. A passphrase will be required to encrypt and decrypt the data.

● Help text - A compiled help (.chm) file will be written that teaches the user how to use the program effectively.
