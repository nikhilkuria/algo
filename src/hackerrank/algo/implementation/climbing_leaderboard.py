import math
import os
import random
import re
import sys
import bisect


# Complete the climbingLeaderboard function below.
# def climbingLeaderboard_with_cache(scores, alice):
#     positions = []
#     unique_scores = set(scores)
#     alice_scores = sorted(alice)
#
#     for alice_score in alice_scores:
#         if alice_score in positions:
#             print("getting from cache")
#             position = positions[alice_score]
#         else:
#             if alice_score not in unique_scores:
#                 bisect.insort(unique_scores, alice_score)
#             position = len(unique_scores) - unique_scores.index(alice_score)
#             positions[alice_score] = position
#         print(positions)
#         positions.append(position)
#
#     return positions
#
#
# def climbingLeaderboard(scores, alice):
#     positions = []
#     unique_scores = set(scores)
#     sorted_scores = sorted(unique_scores)
#     alice_scores = sorted(alice)
#
#     start = 0
#     position = len(sorted_scores) + 1
#     for alice_score in alice_scores:
#         for score in sorted_scores[start:]:
#             if alice_score >= score:
#                 position = position - 1
#                 start = start + 1
#                 continue
#             break
#         positions.append(position)
#
#     return sorted(positions, reverse=True)


# def climbingLeaderboard(current_scores, alice_scores):
#     current_scores = sorted(set(current_scores), reverse=True)
#     alice_scores = sorted(alice_scores, reverse=True)
#     alice_positions = []
#     position = 0
#     for alice_score in alice_scores:
#         start_index = position
#         for score in current_scores[start_index:]:
#             if alice_score < score:
#                 position = position + 1
#             else:
#                 break
#
#         alice_positions.append(position+1)
#
#     return sorted(alice_positions, reverse=True)

# def climbingLeaderboard(current_scores, alice_scores):
#     current_scores = sorted(set(current_scores))
#     alice_positions = []
#     position = len(current_scores)
#     for alice_score in alice_scores:
#         start_index = len(current_scores) - position
#         for score in current_scores[start_index:]:
#             if alice_score >= score:
#                 position = position - 1
#             else:
#                 break
#
#         alice_positions.append(position+1)
#
#     return alice_positions


#
# from bisect import bisect_right
#
# n = int(input())
# scores = sorted(set(map(int,input().split())))
# m = int(input())
# alice = map(int,input().split())
#
# # your code goes here
# for i in alice:
#     print(len(scores)-bisect_right(scores,i)+1)


if __name__ == '__main__':
    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    print('\n'.join(map(str, result)))
