<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>memberInfo</h3>

<table class = "table">
	<tr>
		<th>아이디</th>
			<td class="uid">${member.userId }</td>
	</tr>
	<tr>
		<th>비밀번호</th>
			<td><input type="text" class="passwd" value="${member.userPw }"></td>
	</tr>
	<tr>
		<th>이름</th>
			<td>${member.userName }</td>
	</tr>		
	<tr>
		<th>연락처</th>
			<td><input type="text" class="phone" value="${member.userPhone }" ></td>
	</tr>
	<tr>
		<th>주소</th>
			<td><input type="text" class="addr" value="${member.userAddr }" ></td>
	</tr>
	<tr>
		<th>생일</th>
			<td>${member.userBirth }</td>
	</tr>
	<tr>
		<th>이미지</th>
			<td><img class="image" width="150px" src="images/${member.userImg }" />
			<input type="file" id="image" style="display: none;">
			</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button id="saveBtn">저장</button>
		</td>
</table>

<script>

	document.getElementById('image').addEventListener('change',function(e){
		console.log(e.target.files[0]);
		//multipart/form-data
		let formData = new FormData(); // <form></form>
		formData.append('id',document.querySelector('td.uid').innerText);
		formData.append('image',e.target.files[0]);
		
		let xhtp = new XMLHttpRequest();
		xhtp.open('post','imageUpload.do');
		xhtp.send(formData);
		xhtp.onload = function(){
			let result = JSON.parse(xhtp.responseText);
			if(result.retCode == 'Success'){
				document.querySelector('img.image').src = 'images/'+result.path;
			} else if (result.retCode == 'Fail') {
				alert('처리중 에러')
			} else {
				alert('알수없는 처리코드')
			}
		}
		
		
		
		
	});


	//img 클릭이벤트
	document.querySelector('img.image').addEventListener('click', function(e){
		document.getElementById('image').click();
	});
	document.querySelector('#saveBtn').addEventListener('click', function(e){
		let id = document.querySelector('td.uid').innerText;
		let pw = document.querySelector('input.passwd').value;
		let phone = document.querySelector('input.phone').value;
		let addr = document.querySelector('input.addr').value;
		//console.log(id,pw,phone,addr);
		
		let xhtp = new XMLHttpRequest();
		/*  xhtp.open('get', 'memberModify.do?uid='+id+'&upw='+pw+'&uph='+phone+'&uad='+addr);
		xhtp.send();*/
		xhtp.open('post', 'memberModify.do');
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhtp.send('uid='+id+'&upw='+pw+'&uph='+phone+'&uad='+addr)
		xhtp.onload = function(){
			console.log(xhtp.responseText);
			let result = JSON.parse(xhtp.responseText);
			if(result.retCode == 'Success'){
				alert("저장 성공")
			} else if (result.retCode == 'Fail'){
				alert("저장 실패")
			} else {
				alert("알수없는 코드")
			}
		}
	});
</script>