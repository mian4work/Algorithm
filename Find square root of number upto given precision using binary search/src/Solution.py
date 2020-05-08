def square_root(number, precision):
    start = 0
    end = number
    while start <= end:
        mid = end - (end - start) / 2
        if mid * mid == number:
            return mid
        elif mid * mid < number:
            start = mid + 1
        elif mid * mid > number:
            end = end - 1
    ans = start
    incremental = 0.1
    for i in range(0, precision):
        while ans * ans <= number:
            ans = ans + incremental
        ans = ans - incremental
        incremental = incremental / 10

    return ans


print(square_root(5, 2))
print(square_root(4, 2))
print(square_root(10, 2))
