#동아리 미팅룸 배정 2번
a = [['문학회', 9.0, 11.0], ['지역봉사회', 9.0, 12.5], ['서예회', 13.0, 14.5],
     ['바둑회', 14.0, 17.0], ['미술회', 11.0, 14.0], ['사진회', 9.0, 11.0],
     ['음악회', 15.0, 16.5], ['창조회', 15.0, 16.5], ['독서회', 11.0, 12.5],
     ['토론회', 13.0, 14.5]]


n = len(a)
a.sort(key=lambda key : key [1])

solution = [[a[0]]]
finish_time = [a[0][2]]

k = 0

for i in range(1, n):
  flag = False
  for j in range(k + 1):
    if a [i][1] >= finish_time[j]:
      solution[j].append(a[i])
      finish_time[j] = a[i][2]
      flag = True
      break

  if not flag:
    k += 1
    solution.append(a[i])
    finish_time.append(a[i][2])

for i in range(k + 1):
  print("미팅룸", i + 1, " : ", solution[i])
