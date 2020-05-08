from typing import List


class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if len(coordinates) == 2:
            return True
        x0 = coordinates[0][0]
        y0 = coordinates[0][1]
        x1 = coordinates[1][0]
        y1 = coordinates[1][1]

        for i in range(2, len(coordinates) - 1):
            xi = coordinates[i][0]
            yi = coordinates[i][1]
            if (yi - y0) * (x1 - x0) != (xi - x0) * (y1 - y0):
                return False
        return True
