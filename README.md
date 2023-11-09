### Scala Application: Minimum Path Sum in a Triangle

This Scala application takes an input document representing a triangle where the first row has the least number of elements, and the last row has the most.
It calculates and prints both the sum of the minimum path through the triangle and the actual path taken.

#### How to run
You can run the application using the provided jar or <br>
`sbt run`<br>
The application requires you to chose from 4 options.<br>
The first 3 files are provided textual data with example triangles<br>
The 4th option requires you to enter a number between 10 and 5000 and it randomly generates a triangle<br>

#### Description

The input document should be formatted as a triangle, where each row represents a level of the triangle, and elements in each row are separated by spaces.
Example:<br>
1<br>
1 2<br>
1 2 3<br>
1 2 3 4


#### Output

The application will compute the minimum path sum, which is the sum of the smallest numbers along a path from the top to the bottom of the triangle. Additionally, it will print the actual path taken to achieve the minimum sum.

#### Implementation

The Scala application uses dynamic programming to efficiently calculate the minimum path sum and track the path taken through the triangle.

