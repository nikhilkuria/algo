import math
import os
import random
import re
import sys
import bisect


# Complete the climbingLeaderboard function below.

def climbingLeaderboard_with_cache(scores, alice):
    positions = []
    unique_scores = set(scores)
    sorted_scores = sorted(unique_scores)
    alice_scores = sorted(alice)

    alice_positions = {}

    for alice_score in alice_scores:
        if alice_score in alice_positions:
            print("getting from cache")
            position = alice_positions[alice_score]
        else:
            if alice_score not in sorted_scores:
                bisect.insort(sorted_scores, alice_score)
            position = len(sorted_scores) - sorted_scores.index(alice_score)
            alice_positions[alice_score] = position
        print(alice_positions)
        positions.append(position)

    return positions


def climbingLeaderboard(scores, alice):
    positions = []
    unique_scores = sorted(set(scores))
    print(unique_scores)
    start = 0
    for alice_score in alice:
        position = len(unique_scores) + 1 - start
        print("Starting at ", start)
        for score in unique_scores[start:]:
            print("Initial Position : ", position)
            print("Comparing ", alice_score, " to ", score)
            if alice_score > score:
                position = position - 1
                start = start + 1
                continue
            if alice_score == score:
                position = position - 1
                break
            break
        positions.append(position)

    return positions


if __name__ == '__main__':
    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    print('\n'.join(map(str, result)))
