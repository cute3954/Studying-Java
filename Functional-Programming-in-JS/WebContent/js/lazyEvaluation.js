// 遅延評価とは
// 値が必要になるまで、値の評価を後回しにするということ
// 参考：　https://qiita.com/BooookStore/items/2627f33764dbabbcf55f#:~:text=%E3%81%8A%E9%A1%98%E3%81%84%E3%81%97%E3%81%BE%E3%81%99%E3%80%82-,%E9%81%85%E5%BB%B6%E8%A9%95%E4%BE%A1%E3%81%A8%E3%81%AF,%E8%A1%8C%E3%81%86%E3%81%93%E3%81%A8%E3%82%92%E8%A8%80%E3%81%84%E3%81%BE%E3%81%99%E3%80%82

// 正格評価をするコード
var mi = 0;
var fi = 0;

_.go(
	_.range(100),
	_.map(function(val) {
		++mi;
		return val * val;
	}),
	_.filter(function(val) {
		++fi;
		return val % 2;
	}),
	_.some(function(val) {
		return val > 100;
	}),
	console.log
);
console.log(mi, fi);

// 遅延評価をするコード
var mi = 0;
var fi = 0;

_.go(
	_.range(100),
	L.map(function(val) {
		++mi;
		return val * val;
	}),
	L.filter(function(val) {
		++fi;
		return val % 2;
	}),
	L.some(function(val) {
		return val > 100;
	}),
	console.log
);
console.log(mi, fi);
console.clear();

// 参考：https://qiita.com/hiruberuto/items/7b1b6eb45f8207ea96e4
// https://aratama.github.io/lazyscript/で確認できる
square = (x) => x * x;
console.log(square(4 + 2));

//cst = (x, y) => x;
//console.log(cst(20 + 22, foo)); // Uncaught ReferenceError: foo is not defined

zeroToTwo = {head: 0, tail: {head: 1, tail: {head: 2, tail: null}}};
console.log(zeroToTwo.tail.tail.head);

//answers = {head: 42, tail: answers};
//console.log(answers.tail.tail.tail.head); // Uncaught ReferenceError: answers is not defined

//iterate = (n, f) => ({head: n, tail: iterate(f(n), f)});
//nat = iterate(0, (x) => x + 1);
//console.log(nat.tail.tail.tail.tail.head); // Uncaught RangeError: Maximum call stack size exceeded

// 遅延評価ではスペースリークという問題が起こる
//foldl = (f, a, xs) => xs == null ? a : foldl(f, f(a, xs.head), xs.tail);
foldlP = (f, a, xs) => {
	b = f(a, xs.head);
	return xs == null ? a : (b, foldlP(f, b, xs.tail));
}
cons = (head, tail) => ({head: head, tail: tail});
xs = cons(1, cons(2, cons(3, null)));
sum = foldlP((x, y) => x + y, 0, xs);
console.log(sum); // Uncaught TypeError: Cannot read property 'head' of null