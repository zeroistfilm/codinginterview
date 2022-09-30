# 이미지NxN행렬 각픽셀 4바이트
# 이미지 90도 회전 메서드
# 행렬을 추가로 사용하지 않고 가능?
# 4바이트 = 4*8 비트 = 32비트  = 8비트 + 8비트 + 8비트 + 8비트 (rgba)


def rotate90WithCopy(image):
    assert len(image) == len(image[0])
    N = len(image)
    mat = [[0 for i in range(N)] for i in range(N)]
    for i in range(N):
        for j in range(N):
            mat[i][j]= image[N - 1 - j][i]
    return mat


def printImg(img):
    for i in img:
        print(i)


img = [[1, 2, 3, 4],
       [5, 6, 7, 8],
       [9, 10, 11, 12],
       [13, 14, 15, 16]]
printImg(img)
print()
printImg(rotate90WithCopy(img))
