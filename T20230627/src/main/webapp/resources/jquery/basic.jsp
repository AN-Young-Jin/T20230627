<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 p:nth-child(2) {
  color : red;
 }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
<p>Hello, World1</p>
<p>Hello, World2</p>
<script>
 $('p').css('background','yellow');
 $('p:nth-child(1)').after($('<p />').text('Hello World3'));
 // document.querySelectorAll('p').forEach(pTag =>{
 // pTag.style.background = 'yellow';
 //})

 //pTag = document.querySelector('p:nth-child(1)')
 //let newPTag = document.querySelector('p').appendChild(document.createTextNode('Hello, World3'))
 // document.appenChild(newPTag);
</script>
</body>
</html>