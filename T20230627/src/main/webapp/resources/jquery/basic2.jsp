<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
    $(document).ready(function(){
       // document.addEventListener('DOMContentLoaded', function(){
            $('li:nth-Child(1)').css('background','yellow');
           let li =  $('<li />').text('Melon');
           console.log(li);

            $('ul').append(li); // ul요소의 하위에 li 요소를 추가           
            
            //버튼추가 
            $('li').append($('<button />').text('삭제').on('click',delBtn));
            function delBtn(e){
                console.log(e);
                // e.currentTarget : DOM
                // $(e.currentTarget) : jquery 객체
                $(e.currentTarget).parent().remove();
            }

            //이벤트 : on
            $('body>button:nth-Child(1)').on('click',function(){
                $('li:nth-Child(1)').remove();
            })

            //추가이벤트
            $('#addBtn').on('click',function(e){
               let li =  $('<li />').text($('#userInput').val()).append($('<button />').text('삭제').on('click',delBtn));
               // $('ul').prepend(li);
               //li.prependTo($('ul'));
               $('li:nth-child(2)').after(li);
                //init
                $('#userInput').val('');

            })
           // $('button').wrap($('<div />')); // 각각의 button을 div태그로 감싼다
       // })
    });
</script>
</head>
<body>

    <button>요소제거</button>
    <input id="userInput"><button id="addBtn">추가</button>
    <ul>
        <li>Apple</li>
        <li>Banana</li>
        <li>Cherry</li>
    </ul>

</body>
</html>