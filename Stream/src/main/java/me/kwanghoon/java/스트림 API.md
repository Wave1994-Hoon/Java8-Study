## 스트림 API
#### Stream
- sequence of elements supporting sequential and parallel aggregate operations
- 데이터를 담고 있는 저장소(Collection)이 아니다.
- Functional in nature, 스트림이 처리하는 데이터 소스를 변경하지 않음
- 스트림으로 처리하는 데이터는 오직 한번만 처리
- 무제한일 수도 있음 -> short Ciruit 메소드로 제한 가능
- 중개 오퍼레이션은 기본이 LAZY 
- parallel stream 으로 병렬 처리 가능

#### 스트림 파이프라인
- 0 또는 다수의 중개 오퍼레이션 (intermediate operation) 과 한개의 종료 오퍼레이션 (terminal operation)으로 구성
- 스트림의 데이터 소스는 오직 터미널 오퍼레이션을 실행할 때만 처리

#### 중개 오퍼레이션
- Stream 을 리턴함 !
- Stateless / Stateful 오퍼레이션으로 더 상세하게 구분 가능
    - distinct, sorted 처럼 이전 소스 오퍼레이션을 참조해야 되는 오퍼레이션은 stateful 
- filter, map, limit, skip, sorted ....

#### 종료 오퍼레이션
