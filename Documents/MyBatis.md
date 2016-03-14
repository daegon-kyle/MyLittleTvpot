# MyBatis

## Why use MyBatis?
* 수 많은 형식적인 JDBC 코드 제거
* 배움이 쉬움
* 오래된 데이터베이스와 연동이 잘됨, 쿼리 결과와 자바 오브젝트를 맵핑한다. (Hibernate의 경우, 정적으로 자바 오브젝트를 데이터베이스의 테이블에 맵핑한다.)
* SQL 사용 가능
* Spring and Guice 프레임워크와 연동 지원
* 더 나은 성능
	* 데이터베이스 풀링 (나중에 빠른 연결 가능)
	* 캐쉬 메카니즘 지원 (이전과 동일한 **select 문**의 경우, 이전 sql 결과 반환)

## 파라미터와 결과타입
* hashmap, string, int와 같은 primitive type을 사용하였지만 사용자 정의 클래스로 입력 가능 (파라미터, 결과타입)(xml에서 상속도 가능)

## 동적 SQL도 사용가능
* if condition
* choose-when-otherwise
* trim(특정 string 삭제)
* foreach
* set (update 문) (<set>-----</set>)

## Annotation으로도 sql문 설정 (xml 외에서)

## Autogenerated Keys
* auto_increment 속성과 같은 효과로 사용 가능

## Transaction management using Spring (commit, rollback, close)
* '<'bean id=transactionManager class=org.springframework.jdbc.datasource.DataSourceTransactionManage'>'	'<'property name=dataSource ref=dataSource /'>'	'<'/bean'>'  --'>' 각 value들에 쌍따옴표 필요
* MyBatis - Spring을 같이 쓰는 이유 중의 하나는 MyBatis가 Spring의 트랜잭션을 다룰 수 있음. 새로운 트랜잭션을 만들기 보다는 Spring에 있는 DataSourceTransactionManager를 사용