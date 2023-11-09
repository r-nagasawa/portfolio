/**
 * 入力チェック用JSファイル
 */

//商品の新規登録チェック
function check(){
	if(insert.name.value=="" && price.value==""){
		alert("商品名と価格を入力してください。");
		return false;
	}else if(insert.name.value==""){
		alert("商品名を入力してください。");
		return false;
	}else if(price.value==""){
		alert("価格を入力してください。");
		return false;
	}else if(insert.name.value == ItemDto.value){
		window.confirm("同じ名前の商品があります。登録しますか？");
		return true;
	}
}

//ユーザー新規登録チェック
function userCheck(){
	if(user.name.value=="" && user.password.value==""){
		alert("USER NAME と PASSWORDを設定してください。");
		return false;
	}else if(user.name.value==""){
		alert("USER NAME を設定してください。");
		return false;
	}else if(user.password.value==""){
		alert("PASSWORD を設定してください。");
		return false;
	}else if(user.name.value==UserDto.name.value){
		alert("このユーザー名は使用出来ません。");
		return false;
	}else{
		return true;
	}
}

//検索欄チェック
function serchCheck(){
	if(nameSerch.name.value == ""){
		alert("検索したい商品名を入力してください");
		return false;
	}else{
		return true;
	}
}

function editCheck(){
	if(edit.name.value=="" && edit.price.value==""){
		alert("商品名と価格を入力してください。");
		return false;
	}else if(edit.name.value==""){
		alert("商品名を入力してください。");
		return false;
	}else if(edit.price.value==""){
		alert("価格を入力してください。");
		return false;
	}else{
		return true;
	}
}