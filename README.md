# My Little Tvpot


## 프로젝트 배경
* 교육생의 특성상 (단기, 권한 없음) 업무 밀접한 프로젝트는 진행하기가 힘듬.
* 전 영역에 걸친 웹 어플리케이션 개발 원함 (DB, Back-end, Front-end)

## 개요
* My Little tvpot ... 마리팟
* 간단한 기능을 갖춘 클립뷰 서비스를 만든다.
* 기능명세
  * 서비스 페이지는 클립을 재생할 수 있는 플레이어를 포함한다.
  * 서비스 페이지는 더보기 기능을 포함한 클립 리스트를 갖는다.
  * 서비스 페이지는 각 클립에 해당하는 댓글 리스트를 갖는다.
  * 클립 리스트와 댓글 리스트는 Tabbed UI 형태로 제공한다. 
  * 각 클립은 좋아요 버튼을 제공한다.
  * 카카오 계정으로 로그인 가능한 별도의 페이지를 제공한다. 로그인 한 사용자에게는 다음의 기능이 제공된다.
    * 각 클립은 담기 버튼을 제공한다.
    * 사용자별로 담은 클립을 모아 볼 수 있는 즐겨찾기 페이지를 별도로 제공한다.
    * 즐겨찾기 페이지는 개별 클립을 담기 취소할 수 있도록 편집기능을 제공한다.
    * 즐겨찾기 페이지는 모든 담은 클립을 일괄적으로 취소할 수 있도록 전체 삭제 기능을 제공한다.
    * 로그인 한 사용자에 한 해 댓글 쓰기 기능을 제공한다. 이 때 댓글 쓰기 영역은 댓글 리스트와 같은 탭에 제공된다.
  * 서비스 페이지는 클립에 대한 정보를 표시한다. 
  * 제목, 출처, 좋아요 수, 재생 시간, 재생 수 등.
  * 댓글은 삭제 기능만을 제공한다.
  * 기본적인 레이아웃은 tv팟/카카오tv 를 참고한다.

## 개발환경
* Git
* Local MySQL Server (스키마 작성 후 필요한 샘플데이터는 구성하여 제공)
* Apache/Tomcat
* Spring
* MyBatis
* jQuery 
* Bootstrap 사용
* iframe Player 사용
* 로그인 개발 시 카카오 서비스 API 이용 (kakao.js)

## 평가 계획
* 상시 코드리뷰 (on Github)
* 개발 완료 후 최종 시연 및 결과 공유 
* 진행상황에 따라 스펙 축소 / 혹은 연속재생, 검색 등 별도의 기능 추가 예정. 
