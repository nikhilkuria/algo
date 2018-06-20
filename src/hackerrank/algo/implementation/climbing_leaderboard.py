import math
import os
import random
import re
import sys
import bisect


# Complete the climbingLeaderboard function below.
def climbingLeaderboard(scores, alice):
    positions = []
    unique_scores = set(scores)
    sorted_scores = sorted(unique_scores)
    alice_scores = sorted(alice)

    for alice_score in alice_scores:
        if alice_score not in sorted_scores:
            bisect.insort(sorted_scores, alice_score)
        positions.append(len(sorted_scores) - sorted_scores.index(alice_score))

    return positions


if __name__ == '__main__':
    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    print('\n'.join(map(str, result)))
