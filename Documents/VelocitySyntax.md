# Apache Velocity Syntax

## 참조
	* http://velocity.apache.org/engine/devel/apidocs/
	* https://velocity.apache.org/engine/devel/user-guide.html

* 변수에 값 저장하기
	* #set ($a = "Velocity")

* 주석 달기
	* 한줄 주석은 ##
	* 여러줄 주석은 #* *# 사용
	* 작성자와 version 정보는 #**로 표현

* 자바 객체에서 설정한 property 및 method불러오기
	* .을 이용 ($customer.address 또는 $customer.getAddress())

* Index 사용해서 자료구조 접근
	* $foo[0]
	* $foo[$i]
	* $foo["bar"] -> 맵 객체인 경우

* 정의 안된 참조값을 사용하는 데, 빈칸으로 보여주고 싶은 경우
	* $!{email}

* 반복문
	* #foreach (condition) .... #end
	
* 조건문
	* #if (condition) .... #end
	* #if (condition) .... #elseif(condition) .... #else .... #end
	* condition 안에서 논리 연산자(&& || !) 사용 가능

* 파일 첨부
	* #include("....") -> TEMPLATE_ROOT 내에서만 첨부 가능
	* #include("....", "....")

* local file을 import
	* #parse("A.vm")

* define
	* #define ($A) $who#end $set ($who = 'ABC')  ->  A 호출 시, ABC 출력

* macro
	* #macro (d) <tr>$!bodyContent</tr> #end -> #@d()Hello!#end
	* #macro (d $color $something) <td bgcolor=$color>$something</td> -> #d("blue" "lake")

* 자바 객체 사용 가능 (라이브러리 메소드 또는 정의한 메소드)
	* $객체.메소드 ->  #set ($Integer=0) ... $Integer.parseInt("10")
