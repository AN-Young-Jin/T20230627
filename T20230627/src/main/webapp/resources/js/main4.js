/**
 * 
 */
let jsonData = `[{"id":1,"first_name":"Larissa","last_name":"Yewdale","email":"lyewdale0@bloglovin.com","gender":"Female","salary":2947},
{"id":2,"first_name":"Leroi","last_name":"Goold","email":"lgoold1@newsvine.com","gender":"Male","salary":3518},
{"id":3,"first_name":"Emily","last_name":"Biddwell","email":"ebiddwell2@gravatar.com","gender":"Female","salary":4417},
{"id":4,"first_name":"Malvin","last_name":"Farthin","email":"mfarthin3@theatlantic.com","gender":"Male","salary":4311},
{"id":5,"first_name":"Averill","last_name":"Sumshon","email":"asumshon4@businessinsider.com","gender":"Genderqueer","salary":2500},
{"id":6,"first_name":"Ardra","last_name":"Fernihough","email":"afernihough5@barnesandnoble.com","gender":"Non-binary","salary":4054},
{"id":7,"first_name":"Tova","last_name":"Heeps","email":"theeps6@ycombinator.com","gender":"Female","salary":2022},
{"id":8,"first_name":"Crysta","last_name":"Duignan","email":"cduignan7@msu.edu","gender":"Female","salary":3986},
{"id":9,"first_name":"Thaddus","last_name":"Strahan","email":"tstrahan8@princeton.edu","gender":"Male","salary":4039},
{"id":10,"first_name":"Anetta","last_name":"Jehan","email":"ajehan9@xrea.com","gender":"Female","salary":1813},
{"id":11,"first_name":"Guinevere","last_name":"McCunn","email":"gmccunna@t.co","gender":"Polygender","salary":1772},
{"id":12,"first_name":"Timmi","last_name":"Darbey","email":"tdarbeyb@opera.com","gender":"Female","salary":3590},
{"id":13,"first_name":"Thorsten","last_name":"Schruurs","email":"tschruursc@discovery.com","gender":"Male","salary":1062},
{"id":14,"first_name":"Ernesta","last_name":"Haberjam","email":"ehaberjamd@japanpost.jp","gender":"Female","salary":1046},
{"id":15,"first_name":"Berny","last_name":"Kurt","email":"bkurte@stanford.edu","gender":"Male","salary":1960}]`;

let data = JSON.parse(jsonData); //json 문자열값을 편하게 오브젝트로 변환하는게 parse
//console.log(data);

let xhtp = new XMLHttpRequest();
xhtp.open('get', 'chartData.do');
xhtp.send();
xhtp.onreadystatechange = function(e) {
	if (xhtp.readyState == 4 && xhtp.status == 200) {
		console.log(xhtp.responseText);
		let data = JSON.parse(xhtp.responseText);
		console.log(data);
	}

}