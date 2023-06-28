<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>검색조건</h3>
시도:<input type="text" id="search"><button id="searchBtn">조회</button>
<br>
<div id = "show">
	<table border="1">
		<thead>
			<tr>
				<th>센터id</th>
				<th>센터명</th>
				<th>연락처</th>
				<th>시도</th>
				<th>우편번호</th>
			</tr>
		</thead>
		<tbody id="list">

		</tbody>
	</table>
</div>
<script>
let totalData = [];
let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=08WaAjyHlgHJzprwE9Z%2FO8s2FWsPjWQ8IHbSOwQKzqm9XrB9DzWP0q41qbWW3VkQXiLDMO%2B1quLAxFEypr4uWA%3D%3D`;
let xhtp = new XMLHttpRequest();
xhtp.open('get', url);
xhtp.send();

xhtp.onload = function(){
	let tbody = document.getElementById("list");
	let data = JSON.parse(xhtp.responseText);
	console.log(data.data);
	totalData = data.data;
	for(let i=0; i<data.data.length; i++){
		tbody.append(makeRow(data.data[i]));
	}
}	
	let fields = ['id','centerName','phoneNumber','sido','zipCode'];
	function makeRow(obj={}){
		let tr = document.createElement('tr');
		for(let field of fields){
			let td =document.createElement('td');
			td.innerText = obj[field];
			tr.appendChild(td);
		}
		return tr;
}

document.querySelector('#searchBtn').addEventListener('click',findfnc2);

function findfnc1(){
let trs = document.querySelectorAll('tbody tr')
let ary = [];
for(let tr of trs){
	if(tr.children[3].innerText == document.getElementById('search').value){
		ary.push(tr);
	}
}
	console.log(ary);
	document.getElementById('list').innerHTML="";
	for(let tr of ary){
		document.getElementById('list').appendChild(tr);
	}
}

function findfnc2(){
	let ary =[];
	console.log(totalData);
	//1.기존목록 clear 2.입력값 비교 vs totalData 3. tbody.appendChild()
	document.getElementById('list').innerHTML="";
	for(let totaldata of totalData){
		if(totaldata.sido == document.getElementById('search').value){
			document.getElementById('list').appendChild(makeRow(totaldata));
		}
	}
}
</script>
</body>
</html>