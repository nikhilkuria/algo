import math
import os
import random
import re
import sys


# Complete the climbingLeaderboard function below.
def climbingLeaderboard(scores, alice):
    positions = []
    unique_scores = set(scores)
    sorted_scores = sorted(unique_scores, reverse = True)
    for alice_score in alice:
        if sorted_scores.index(alice_score)
        unique_scores.add(alice_score)
        positions.append(sorted_scores.index(alice_score) + 1)

    return positions


if __name__ == '__main__':
    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    print('\n'.join(map(str, result)))
