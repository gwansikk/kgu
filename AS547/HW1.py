import os
import pandas as pd
import numpy as np


def solve_linear_equations(a, b):
    n = len(a)
    ab = np.hstack((a, b.reshape(-1, 1)))  # 확장 행렬 생성

    for i in range(n):
        # i번째 열에서 첫 번째로 0이 아닌 요소를 찾아 그 행을 i번째 행으로 이동하고 1로 만듦
        for j in range(i, n):
            if ab[j, i] != 0:
                ab[[i, j]] = ab[[j, i]]  # 행 교환
                ab[i] = ab[i] / ab[i, i]  # i번째 행의 i번째 요소를 1로 만듦
                break

        # i번째 행을 사용하여 아래 행들의 i번째 요소를 0으로 만듦
        for j in range(i+1, n):
            ab[j] = ab[j] - ab[i] * ab[j, i]

    # 후진 대입법으로 해 구하기
    x = np.zeros(n)
    for i in range(n-1, -1, -1):
        x[i] = (ab[i, -1] - np.dot(ab[i, i+1:n], x[i+1:n])) / ab[i, i]

    return x


# (2) 일차연립방정식 계수 입력 또는 엑셀 파일에서 불러오기
df = pd.DataFrame(np.array([[6, -3, 2], [5, 1, 12], [8, 5, 1]], dtype=float))
b = np.array([31, 36, 11], dtype=float)

# 입력 출력
print(df)

a = df.values
solution = solve_linear_equations(a, b)

# 연산 후 출력
print(solution)
