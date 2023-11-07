"# portfolio"   
# 商品の管理サイト  

## 説明  
商品の登録、変更、削除および、登録されている商品の検索ができるサイトです。  
ユーザー登録をして、登録したユーザー情報でログインをすることで管理画面に移行することができます。  

## 機能  
### ユーザー情報管理  
**【新規ユーザー登録画面】**  
任意のUSER NAMEとPASSWORDを入力することで登録可能です。  
ただし、既に登録されているUSER NAMEと同じものは登録できないようになっています。  
また入力欄に空白があるとアラートメッセージが表示されます。  

**【ログイン画面】**  


![from_issues]


登録済みのUSER NAMEとPASSWORDを入力することでログインができます。  
入力欄に空欄があるとアラートメッセージが表示されます。  
登録されていない情報が入力されると画面遷移はせずに、入力した値のみが消えます。  

## 商品情報管理
**【商品管理ページ】**  
新規商品登録ボタン、全商品一覧表示ボタン、商品検索欄、ログアウトボタンを実装しています。  

**新規商品登録**  
ボタンをクリックすると商品登録画面に遷移します。  
名前と価格を入力し、カテゴリーをプルダウン選択して商品登録が出来ます。  
入力欄が空白だとアラートが表示されます。  
価格に数字以外のものが入ると「入力が不正です」と表示され登録はされません。  
「管理ページに戻る」をクリックすることで商品管理ページに遷移します。  

**全商品一覧表示**  
ボタンをクリックするとこれまでに登録した商品の一覧が表示されます。  
表の中には変更ボタンと削除ボタンが実装されています。  

*変更機能*  
変更ボタンをクリックすると編集画面に遷移します。  
変更箇所を編集して完了を押すことで、変更が完了します。  
入力欄が空欄の場合はアラートが出ます。  

*削除機能*  
削除ボタンをクリックすると確認画面へ遷移します。  
「はい」で削除、「いいえ」で操作キャンセルが出来ます。

**商品検索機能**  
商品名での検索、カテゴリ別の検索、価格帯での検索の三種類があります。  
商品名検索は部分一致での検索が可能です。空白のまま検索ボタンをおすとアラートが出ます。  
それぞれの検索条件は独立しているため、組み合わせての検索が現状できません。

**ログアウト**  
クリックすることでログアウトし、ログイン画面に遷移します。  

## 使用技術   
IDE : Eclipse

frontEnd：HTML, JavaScript

BackEnd：Java, MySQL

etc:Git, GitHub, TomCat











