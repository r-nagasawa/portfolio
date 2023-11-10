

let wCheck = new XMLHttpRequest();

wCheck.onreadystatechange = function(){
	if(wCheck.readyState == 4){
		if(wCheck.status == 200){
			let data = request.responseText;
			console.log(data);
		}
	}
}

wCheck.open('GET', 'jdbc:mysql://localhost:3306/javaexam?serverTimezone=UTC', true)
request.send(null);


