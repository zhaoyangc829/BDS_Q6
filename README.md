# BDS_Q6

Determine whether the given point located in the given polygon.

//---------------Input---------------//

"input_question_6_polygon"
1st column: x cartesian coordinate
2nd column: y cartesian coordinate

4 3
2 6
3 12
2 17
5 20
9 21
14 19
20 14
18 3
11 7

**NOTE** The order of points in forming polygon need to be preserved.

"input_question_6_points"
1st column: x cartesian coordinate
2nd column: y cartesian coordinate

7 11
10 14
11 4
12 21
16 3
16 10
17 4
18 7
18 17
20 7


//---------------Output---------------//

1st column: x cartesian coordinate
2nd column: y cartesian coordinate
3rd column: answer as either "inside" or "outside"
7 11   Inside
10 14  Inside
11 4   Outside
12 21  Outside
16 3   Outside
16 10  Inside
17 4   Inside
18 7   Inside
18 17  Outside
20 7   Outside
