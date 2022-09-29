# 이미지NxN행렬 각픽셀 4바이트
# 이미지 90도 회전 메서드
# 행렬을 추가로 사용하지 않고 가능?
# 4바이트 = 4*8 비트 = 32비트  = 8비트 + 8비트 + 8비트 + 8비트 (rgba)


def rotate90(image):
    return image


def printImg(img):
    for i in img:
        print(i)


img = [[1, 2, 3, 4],
       [5, 6, 7, 8],
       [9, 10, 11, 12],
       [13, 14, 15, 16]]

printImg(rotate90(img))
