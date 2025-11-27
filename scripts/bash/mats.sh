#!/bin/bash

MATERIALS=""
PLATFORM="android"

while getopts ":m:p:" opt; do
  case $opt in
    m)
      MATERIALS="$OPTARG"
      ;;
    p)
      PLATFORM="$OPTARG"
      ;;
    \?)
      echo "Error: unkown option: -$OPTARG" >&2
      exit 1
      ;;
    :)
      # Xử lý trường hợp thiếu đối số cho tùy chọn
      echo "Error: Options -$OPTARG need an argument." >&2
      exit 1
      ;;
  esac
done

# Kiểm tra và xây dựng lệnh cần thực thi
COMMAND="lazurite build ./proj"

# 1. Thêm tùy chọn -m nếu nó được cung cấp
if [ -n "$MATERIALS" ]; then
    COMMAND="$COMMAND -m $MATERIALS"
fi

# 2. Luôn thêm tùy chọn -p (sử dụng giá trị mặc định "android" nếu không được cung cấp)
# Lưu ý: Theo yêu cầu, nếu không có -p thì mặc định là -p android
COMMAND="$COMMAND -p $PLATFORM"

# In ra lệnh để kiểm tra (có thể bỏ qua khi chạy chính thức)
echo "Command will be execute: $COMMAND"

COMMAND="$COMMAND --shaderc env/shaderc"

$COMMAND

echo "Done"