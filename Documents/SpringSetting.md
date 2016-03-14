# Spring Project 설정

1. 보여줄 page는 src/main/webapp에 저장

2. 메인화면이 될 index.jsp를 만듬

3. src/main/webapp/views/web.xml에 아랫 부분 추가 -> 프로젝트 시작되면 index.jsp를 호출
<welcome-file-list>
	<welcome-file>index.jsp</welcome-file>
</welcome-file-list>

4. 서블릿 설정 변경 -> 일반적으로 쓰는 .do로 변경
ser/main/webapp/views/web.xml 이동하여 변경
<servlet-mapping>
	<servlet-name>action</servlet-name>
	<url-pattern>*.do</url-pattern>
<servlet-mapping>

5. -> <context-param> 부분 수정
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value></param-value>
/context-param>

6. ContextConfigLocation 변경
/WEB-INF 우클릭 -> new -> Folder 선택

7. "config"를 이름으로 하는 폴더 생성

8. /WEB-INF/spring/appServlet 디렉토리에 있는 servlet-context.xml을 복사 

9. /WEB-INF/config 폴더에 붙여넣고 이름을 action-servlet.xml로 변경

10. /WEB-INF에 있는 spring이라는 디렉토리는 삭제
