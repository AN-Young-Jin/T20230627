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


const array1 = ['a','b','c'];

array1.forEach(function(element, idx,ary){
    console.log(element,idx,ary);
});


document.querySelector('#userInput').addEventListener('change',function(e){
    let span = document.createElement('span');
    span.innerText = document.querySelector('#userInput').value;
    document.querySelector('.outer').appendChild(span);
    
    
    document.querySelector('#userInput').value = "";
});