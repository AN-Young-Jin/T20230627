<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset='utf-8' />
  <script src='fullcalendar-6.1.8/dist/index.global.js'></script>
  <script>
    let data = [{
      title: '회의',
      start: '2023-01-02T13:00:00',
      end: '2023-01-02T15:00:00'
    }]
    document.addEventListener('DOMContentLoaded', function () {

      //Ajax 호출
      let xhtp = new XMLHttpRequest();
      xhtp.open('get', 'eventList.do');
      xhtp.send();
      xhtp.onload = function () {
        let result = JSON.parse(xhtp.responseText);
        for (let cal of result) {
          let obj = {
            title: cal.title,
            start: cal.startDate,
            end: cal.endDate
          }
          data.push(obj);
        }
        console.log(data);



        var calendarEl = document.getElementById('calendar');

        var calendar = new FullCalendar.Calendar(calendarEl, {
          headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
          },
          initialDate: "2023-06",
          navLinks: true, // can click day/week names to navigate views
          selectable: true,
          selectMirror: true,
          select: function (arg) { // 이벤트추가
            var title = prompt('일정을 등록하세요');
            if (title) {
              console.log(arg);
              let addxhtp = new XMLHttpRequest();
              addxhtp.open('post', 'addEvent.do');
              addxhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
              addxhtp.send('title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr);
              addxhtp.onload = function () {
                let result = JSON.parse(addxhtp.responseText);
                if (result.retCode = 'Success') {
                  calendar.addEvent({
                    title: title,
                    start: arg.start,
                    end: arg.end,
                    allDay: arg.allDay
                  })
                } else {
                  alert("안댕");
                }
              }
            } // end if
            calendar.unselect()
          },
          eventClick: function (arg) { // 이벤트제거
            if (confirm('일정을 삭제하겠습니까?')) {
              console.log(arg);
                let remxhtp = new XMLHttpRequest();
                remxhtp.open('post', 'removeEvent.do');
                remxhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                remxhtp.send('title=' + arg.event._def.title);
                remxhtp.onload = function () {
                  let result = JSON.parse(remxhtp.responseText);
                  if (result.retCode = 'Success') {
                    arg.event.remove();
                  } else {
                    alert("안댕");
                  }
                }
              
            }
          },
          editable: true,
          dayMaxEvents: true, // allow "more" link when too many events
          events: data
        });

        calendar.render();
      } // end onload
    });
  </script>
  <style>
    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>
</head>

<body>

  <div id='calendar'></div>

</body>

</html>