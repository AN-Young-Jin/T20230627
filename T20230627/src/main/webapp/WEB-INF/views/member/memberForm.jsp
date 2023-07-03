<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script>
        let today = new Date('Dec 14, 2005, 12:00:00 AM');
        Date.prototype.timeFormat = function(){
           // console.log(this.getFullYear());
            let yyyy = this.getFullYear();
            let mm = this.getMonth() + 1;
            let dd = this.getDate();

            return yyyy + '-' + ('0'+mm).slice(-2) + '-' + ('0'+dd).slice(-2);
        }
        console.log(today.timeFormat());


        $(document).ready(function(){
            //jquery의 ajax 실행.
            $.ajax({
                url : 'memberListJson.do',
                method : 'get',
                success : function(result){
                    console.log(result);
                    result.forEach(item => {
                    let tr = $('<tr />').append($('<td />').text(item.userId)
                                                ,$('<td />').text(item.userName)
                                                ,$('<td />').text(new Date(item.userBirth).timeFormat())
                                                ,$('<td />').text(item.userPhone)
                                                ,$('<td />').append($('<img />').attr('src','images/' +item.userImg)
                                                                                .attr('width','25px'))                  
                        )
                        tr.on('click',modifyFnc);
                        $('#list').append(tr);
                    })
                },
                error : function(err){
                    console.error(err);
                }
                
            });

            function modifyFnc(e){
             //console.log($(this).children().eq(0).text());
              let id = $(this).find('td:nth-child(1)').eq(0).text();
              $.ajax({
                    url : 'memberInfoJson.do',
                    method : 'post',
                    data : {uid: id}, // req.getParameter("uid")
                    success : function (result){
                        console.log(result);
                        $('#uid').val(result.userId),
                        $('#upw').val(result.userPw),
                        $('#uname').val(result.userName),
                        $('#ubirth').val(new Date(result.userBirth).timeFormat()),
                        $('#uphone').val(result.userPhone)
                    },
                    error : function(err){
                        console.error(err);
                    }
              })
            }

            //등록버튼 클릭시 
            $('form[name="myFrm"]').on('submit',submitForm);

            function submitForm(e){
                e.preventDefault();
                console.log(e);

                $.ajax({
                    url : $('form[name = "myFrm"]').attr('action'),
                    method : 'post',
                    data : $('form[name = "myFrm"]').serialize(),   //"{uid=" + $('input[name="uid"]').val(),
                    success : function(result){
                        console.log(result);
                        let tr = $('<tr />').append($('<td />').text(result.userId)
                                                ,$('<td />').text(result.userName)
                                                ,$('<td />').text(new Date(result.userBirth).timeFormat())
                                                ,$('<td />').text(result.userPhone)
                                                ,$('<td />').append($('<img />').attr('src','images/' +result.userImg)
                                                                                .attr('width','25px'))                  
                        )
                        $('#list').append(tr);
                    },   
                    error : function(err){
                        console.error(err);
                    }     
                });
            }

            
            
        })
    </script>
<h3>Jquery 연습</h3>
<form name="myFrm" action="memberAdd.do">
    <table class="table">
        <tr>
            <th>아이디</th>
            <th><input type="text" name="uid" id="uid" value="hky07013" ></th>
        </tr>
        <tr>
            <th>패스워드</th>
            <th><input type="password" name="upw" id="upw" value="newbie"></th>
        </tr>
        <tr>
            <th>이름</th>
            <th><input type="text" name="uname" id="uname" value="홍규연"></th>
        </tr>
        <tr>
            <th>연락처</th>
            <th><input type="text" name="uphone" id="uphone" value="010-2443-3453"></th>
        </tr>
        <tr>
            <th>주소</th>
            <th><input type="text" name="uaddr" id="uaddr" value="고령"></th>
        </tr>
        <tr>
            <th>생년월일</th>
            <th><input type="date" name="ubirth" id="ubirth" value="1997-02-25"></th>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="등록">
                <input type="reset" value="초기화">
                <button type="button">변경</button>
            </td>
        </tr>
    </table>
</form>
<br>
<table class="table">
    <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>생일</th>
            <th>연락처</th>
            <th>사진</th>
        </tr>   
    </thead>
    <tbody id="list"></tbody>
</table>























