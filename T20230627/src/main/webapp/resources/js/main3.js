/**
 * 
 */
console.log('main3.js');
let students = [
	 {name: "홍규루", age: "20", score:59}
	,{name: "홍두유", age: "25", score:94}
	,{name: "홍초코", age: "27", score:89}
]

function makeTr(obj = {}){
	let tr = document.createElement('tr');
	for(let prop in obj){
		let td = document.createElement('td');
		td.innerText = obj[prop];
		tr.appendChild(td);
	}
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerText = "삭제";
	btn.addEventListener('click',delFnc);
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}

function delFnc(e){
	e.target.parentElement.parentElement.remove();
}
// 배열의 값을 활용해서 목록에 정보생성
// 배열의 경우 반복문 : for ~ of 사용
for(let student of students){
	// student : {name: "홍규루", age: "20", score:59}
	let tr = makeTr(student); //tr생성
	document.getElementById('target').appendChild(tr);
}