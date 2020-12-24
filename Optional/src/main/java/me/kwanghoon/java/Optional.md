## Optional
#### 개념
- Optional ?
    - 오직 값 한 개가 들어있을 수도 없을 수도 있는 컨테이너
    
- 메소드에서 작업 중 특별한 상황에서 값을 제대로 리턴할 수 없는 경우 선택할 수 있는 방법
    - 예외를 던진다 -> 하지만 비싸다 스택 트레이스를 찍기 때문에
    - null을 리턴한다 -> 비용 문제는 없지만, 그 코드를 사용하는 클라이언트는 주의가 필요함
    - Optional 을 리턴한다.
    
- 주의사항
    - Optional 은 리턴 값으로만 사용해야 한다. 
      - 메소드 매개변수 타입, 맵의 키 타입, 인스턴스 필드 타입으로 사용 x
    - Optional 을 리턴하는 메소드에서 null을 리턴하지 말자
    - 프리미티브 타입용 Optional 은 따로 있다. -> OptionalInt, OptionalLong 
      - 프리미티브 타입은박싱, 언박싱이 발생해서 성능 안좋음
    - Collection, Map, Stream, Array 는 Optional 로 감싸지 말것
    
## Optional API
#### Optional 만들기
- Optional.of()
- Optional.ofNullable()
- Optional.empty()

#### Optional 에 값이 있는지 없느지 확인
- isPresent()
- isEmpty()

#### Optional 에 있는 값 가져오기
- get()
- 만약에 비어있는 Optional 에서 무언가를 꺼낸다면 ???

#### Optional 값이 있는 경우애 그 값을 가지고 ~~ 를 하라
- ifPresent(Consumer)
- ex) Spring 으로 시작하는 수업이 있으면 if를 출력하라

#### Optional 에 값이 있으면 가져오고 없는 경우에 ~~를 리턴하라
- orElse(T)
- ex) JPA 로 시작하는 수업이 없다면 비어있는 수업을 리턴하라

#### Optional 에 값이 있으면 가져오고 없는 경우에 ~~를 하라
- orElseGet(Supplier)
- ex) JPA 로 시작하는 수업이 없다면 새로 만들어서 리턴하라 

#### Optional 에 값이 있으면 가져오고 없는 경우 에러를 던져라
- orElseThrow()

#### Optional 에 들어있는 값 걸러내기
- Optional filter(Predicate)

#### Optional 에 들어있는 값 반환하기
- Optional map(Function)
- Optional fltMap(Function)
    - Optional 안에 들어있는 인스턴스가 Optional 인 경우에 사용하면 편리 