/**
 * 
 */
document.querySelectorAll('#page-content-wrapper table')
.forEach(function(tbl){
    tbl.innerHTML= "";
});

document.querySelectorAll('#page-content-wrapper h3')
.forEach(function(elem){
    elem.remove();
});


const str = 'is no mundi exerci eloquentiam. Hinc probo mei at, qui ei nonumy utamur. Pro ut dico ubique alterum, nam natum diceret salutandi in. Vim ne sumo zril. Duo magna forensibus id, sit debet constituto cu, an sit fugit homero dissentiunt.'

const strAry = str.split(' ');
let outer = document.querySelector('div.outer');
strAry.forEach(function(word){
    let span = document.createElement('span');
    span.innerText = word;
    outer.appendChild(span);
});


document.querySelector('#userInput').addEventListener('change',function(e){
    let span = document.querySelectorAll('div.outer span');
    for(let a of span){
        if(a.innerText == document.querySelector('#userInput').value){
        a.remove();
        document.querySelector('#userInput').value = ""; 
    }
    }
})

