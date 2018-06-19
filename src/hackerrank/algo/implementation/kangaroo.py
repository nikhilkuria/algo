#!/bin/python3

import math
import os
import random
import re
import sys


# Complete the kangaroo function below.
def kangaroo(x1, v1, x2, v2):
    kangaroo_one_pos = x1
    kangaroo_two_pos = x2
    while True:
        if kangaroo_one_pos == kangaroo_two_pos:
            return "YES"
        if kangaroo_one_pos > kangaroo_two_pos and v1 >= v2:
            break
        if kangaroo_two_pos > kangaroo_one_pos and v2 >= v1:
            break

        kangaroo_one_pos = kangaroo_one_pos + v1
        kangaroo_two_pos = kangaroo_two_pos + v2

    return "NO"


print(kangaroo(0,2,5,3))
