/**
 * 
 */

 console.log("main.js");
 
 let obj = {name: "홍고령" , age:23, phone: "010-2222-3333"}
 console.log(obj.name, obj['age']);
 for (let prop in obj){
	 console.log("속성: " + prop + ", 값: " + obj[prop]);
 }
 
 let ary = [];
 ary.push({name: "홍테디" , age:23, phone: "010-2222-3333"});
 ary.push(obj);
 ary.push("홍이클");
 ary.pop();
 
 console.log(ary);
 
 
 for(let val of ary){
	 for(let prop in val){
	 console.log(val[prop]);
			 
	 }
 }
 
let ulTag =  document.createElement('ul'); // <ul />
for(let val of ary){
	let liTag = document.createElement('li'); // <li />
	liTag.innerText = val['name'];
	ulTag.appendChild(liTag);
	//button
	let btn = document.createElement('button'); // <button>클릭</button>
	btn.innerText = "클릭";
	liTag.appendChild(btn);
}
console.log(ulTag);

document.getElementById('page-content-wrapper').appendChild(ulTag);