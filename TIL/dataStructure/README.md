# Data Structure

## Hash Table
### Features
- hashcode는 정수로 이루어짐 -> 중복이 발생할 가능성이 있을 수 밖에 없음
- 입력받은 키값으로 해시코드 생성 -> 인덱스 키값으로 사용 -> 저장된 값 접근
- Hash Algorithm -> Collision 주의
- 충돌이 일어나면 값은 `LinkedList` 형태로 저장 (최악의 경우 시간 복잡도는 O(1)에서 -> O(n)로 바뀐다)
- 해시함수를 잘 만들면 충돌 위험이 적어짐
- Hash Table (synchronized) / Hash Map (not synchronized)
