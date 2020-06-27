/*
 * JavaScriptで関数型プログラミングの入門
  参照：　https://qiita.com/takeharu/items/cf98d352ff574c5ac536
 
 注意点
 ・ すべての関数が値を返す
 ・関数は参照透過性が保たれている（引数が同じであれば何回その関数を実行しても結果が変わらない）
 ・関数を値として扱える
 
 ↓　関数型を支援するUnderscore.jsについて書かれているため、時間があれば参考してもよい気がする。
 https://qiita.com/takeharu/items/7d4ead780710c627172e
 */

/* 純粋関数 */
function add(a, b) {
	return a + b;
}

console.log(add(10, 5));

var c = 10;

function add2(a, b) {
	return a + b + c;	
}

console.log(add2(10, 2));
console.log(add2(10, 3));
console.log(add2(10, 4));

c = 20;

console.log(add2(10, 2));
console.log(add2(10, 3));
console.log(add2(10, 4));

// 副作用がある（外側の変数を変更する）
function add3(a, b) {
	c = b;
	return a + b;
}

console.log("c: ", c);
console.log(add3(20, 30));
console.log("c: ", c);

/* 第一級関数（高階関数が扱える） */
// 関数は外側の変数を変更しない
// 参照渡しの引数の値を変更しない
var obj1 = {val:10};
function add4(obj1, b) {
	obj1.val += b;
}

console.log(obj1.val);
add4(obj1, 20);
console.log(obj1.val);

var obj2 = {val:10};

function add5(obj, b) {
	return {val:obj.val + b}
}

console.log(obj2.val);
var obj3 = add5(obj2, 20);
console.log(obj2.val);
console.log(obj3.val);

// 関数が値として扱える
var f1 = function(a) {return a * a;}
console.log(f1);
var f2 = add;
console.log(f2);

function f3(f) {
	return f();
}

console.log(f3(function() {return 10;}));
console.log(f3(function() {return 20;}));

/* add_maker */
// 関数を返り値として処理を委譲している。
function add_maker(a) {
	return function(b) {
		return a + b;
	}
}
var add10 = add_maker(10);
console.log(add10(20));

var add5 = add_maker(5);
var add15 = add_maker(15);
console.log(add5(10));
console.log(add15(10));

function f4(f1, f2, f3) {
	return f3(f1() + f2());
}

console.log(
	f4(
		function() {return 2;},
		function() {return 1;},
		function(a) {return a * a;}

	)
);

console.clear();