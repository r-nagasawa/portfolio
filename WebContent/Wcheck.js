
/*
let wCheck = new XMLHttpRequest();
wCheck.open('Post', 'jdbc:mysql://localhost:3306/javaexam?serverTimezone=UTC', true)
wCheck.responseType = 'json'
wCheck.send(null)
wCheck.onload = function(e) {
  if (wCheck.readyState == 4) {
    if (wCheck.status == 200 ) {

      let btn = document.getElementById('btn');
      let users = wCheck.response;

      btn.addEventListener('click', function() {
        users.forEach(function (user) {
          let li = document.createElement('li');
          li.innerText = user.name
          lists.appendChild(li)
        });
      });

    }
  }
}*/
