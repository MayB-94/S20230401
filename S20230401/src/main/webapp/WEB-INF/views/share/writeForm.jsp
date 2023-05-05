<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/preset.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/share/writeForm.css">
<script type="text/javascript">
	
	// 첫번째 select박스 선택시 실행
	function firstSelect(){
		let locSelect = $('#location-firstSelect').val();
		console.log(locSelect);
		
		$.ajax({
			url:'${pageContext.request.contextPath}/board/share/selectRegion',
			data:{'reg_id':locSelect},
			success: function(data){
				console.log(data);
				
				let options = '';
				for(let i=0; i<data.length; i++){
					options += '<option value="'+data[i].reg_id+'">'+data[i].reg_name+'</option>';
				}
				// 지역 소분류의 옵션을 추가하고, name 속성 부여
				$('#location-secondSelect').append(options);
			}
		});
	}
	
	// 두번째 select박스 선택시
	function secondSelect(){
		// 지역 대분류의  name 속성 제거 소분류 name 추가
		$('#location-firstSelect').removeAttr('name');
		$('#location-secondSelect').attr('name', 'trade.reg_id');
	}
</script>
</head>
<body>
	<div class="container">

		<h1>글쓰기</h1>

		<div>
			<form action="${pageContext.request.contextPath}/board/share/writeArticleForm" method="post">
				<input type="hidden" 	name="category" 		value="${category}">
				<input type="hidden" 	name="brd_id" 			value="${category}">
			<!-- 임시 기본값 저장 -->
				<input type="hidden" 	name="trade.trd_status" value="401">
				<input type="hidden" 	name="trade.trd_cost" 	value="0">
				<input type="hidden" 	name="art_good" 		value="0">
				<input type="hidden" 	name="art_bad" 			value="0">
				<input type="hidden" 	name="art_read" 		value="0">
				<input type="hidden" 	name="isdelete" 		value="0">
				
				
				<div class="form-group">
					<label for="title">제목</label>
					<input type="text" id="art_title" name="art_title" placeholder="제목" required="required">
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea name="art_content" placeholder="내용을 입력하세요" required="required"></textarea>
				</div>

				<div class="form-group">
					<label for="tag">태그</label>
					<input type="text" 	name="art_tag1" value="태그1" placeholder="입력">
					<input type="text" 	name="art_tag2" value="태그2" placeholder="입력">
					<input type="text" 	name="art_tag3" value="태그3" placeholder="입력">
					<input type="text" 	name="art_tag4" value="태그4" placeholder="입력">
					<input type="text" 	name="art_tag5" value="태그5" placeholder="입력">
				</div>
				
				<!-- 대분류 -->
				<div class="form-group">
					<label for="location-limit">지역제한</label>
					<select id="location-firstSelect" name="trade.reg_id" onchange="firstSelect()">
						<option value="">지역 선택</option>
						<c:forEach var="region" items="${regionList}">
							<option id="region-parent" value="${region.reg_id}">${region.reg_name}</option>
						</c:forEach>
					</select>
					
					<!-- 소분류 -->
					<select id="location-secondSelect" onchange="secondSelect()">
						<option value="">선택</option>
					</select>
				</div>

				<div class="form-group">
					<label for="deal-location">거래 지역</label>
					<input type="text" name="trade.trd_loc" value="이대" required="required">
				</div>


				<div class="form-group">
					<label for="max-people">최대 인원</label>
					<input type="number" name="trade.trd_max" value="2" required="required">
				</div>

				<div class="form-group">
					<label for="deadline">마감일
					<input type="date" name="trd_endDate" required="required">
				</div>

				
				<div class="form-group">
					<select name="trade.trd_gender">
						<label for="gender-limit">성별</label>
						<option value="">제한 없음</option>
						<option value="201">남자</option>
						<option value="202">여자</option>
					</select>
				</div>

				<div class="form-group">
					<label for="age-limit">나이</label>
					<input type="number" name="trade.trd_minage" value="10">
					<input type="number" name="trade.trd_maxage" value="30">
				</div>

				<div class="form-group checkbox-group">
					<label for="notice">공지 여부</label> 
					<input type="checkbox" name="art_isnotice" value="1">
				</div>

				<div class="button-group">
					<button type="submit" class="btns-submit">작성</button>
					<button type="reset" class="btns-cancel">취소</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>